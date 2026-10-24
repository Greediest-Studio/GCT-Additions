package com.shiver.gct_additions.common.entity;

import com.brandon3055.draconicevolution.entity.EntityChaosGuardian;
import com.brandon3055.draconicevolution.entity.EntityGuardianProjectile;
import com.brandon3055.draconicevolution.entity.DragonChunkLoader;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

/** 复用 DE 的飞行、模型和四种追踪弹；保留本包的晶体、家园和额外攻击语义。 */
public class EntityOrderGuardian extends EntityChaosGuardian {
    private boolean carryingCrystal;
    private int specialAttackTicks;

    public EntityOrderGuardian(World world) {
        super(world);
        enablePersistence();
        experienceValue = 200000;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2000.0D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(30.0D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(20.0D);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0D);
    }

    @Override
    public void updateCrystals() {
        // 终序岛的守护使不依赖原生混沌岛晶塔，也不能复活或删除附近的 DE 晶塔。
        crystals = new ArrayList<>();
        activeCrystals = 0;
        healingChaosCrystal = null;
        setCrystalPos(null);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (world.isRemote || getHealth() <= 0.0F) return;
        if (ticksExisted % 10 == 0) heal(1.0F);
        if (carryingCrystal) heal(0.1F);
        if (--specialAttackTicks > 0) return;
        EntityPlayer target = world.getClosestPlayer(posX, posY, posZ, 200.0D, true);
        if (target == null || target.isSpectator() || target.capabilities.isCreativeMode) return;
        specialAttackTicks = getHealth() < getMaxHealth() * 0.2F ? 60 : 160;
        // 原生 DE 弹幕之外保留雷击、末影冲击、混合弹幕、强风和低血量传送弹。
        switch (rand.nextInt(5)) {
            case 0:
                world.addWeatherEffect(new EntityLightningBolt(world, target.posX, target.posY, target.posZ, false));
                break;
            case 1:
                targetX = target.posX;
                targetY = target.posY + 10.0D;
                targetZ = target.posZ;
                Vec3d rush = new Vec3d(target.posX - posX, target.posY - posY, target.posZ - posZ).normalize().scale(2.0D);
                motionX = rush.x;
                motionY = rush.y;
                motionZ = rush.z;
                double dx = target.posX - dragonPartHead.posX;
                double dy = target.posY + 1.0D - dragonPartHead.posY;
                double dz = target.posZ - dragonPartHead.posZ;
                net.minecraft.entity.projectile.EntityDragonFireball fireball =
                        new net.minecraft.entity.projectile.EntityDragonFireball(world, this, dx, dy, dz);
                fireball.setPosition(dragonPartHead.posX, dragonPartHead.posY + 0.5D, dragonPartHead.posZ);
                world.spawnEntity(fireball);
                onCrystalTargeted(target, true);
                break;
            case 2:
                for (int type : new int[]{3, 4, 5}) {
                    EntityGuardianProjectile projectile = new EntityGuardianProjectile(world, type, target, 12.0F, this);
                    projectile.setPosition(dragonPartHead.posX, dragonPartHead.posY + 1.5D, dragonPartHead.posZ);
                    world.spawnEntity(projectile);
                }
                break;
            case 3:
                for (EntityPlayer player : world.getEntitiesWithinAABB(EntityPlayer.class, getEntityBoundingBox().grow(40.0D))) {
                    if (player.isSpectator() || player.capabilities.isCreativeMode || isOnSameTeam(player)) continue;
                    double distance = Math.max(1.0D, getDistance(player));
                    player.addVelocity((player.posX - posX) / distance * 1.5D, 0.5D,
                            (player.posZ - posZ) / distance * 1.5D);
                    player.velocityChanged = true;
                }
                break;
            case 4:
                EntityGuardianProjectile teleport = new EntityGuardianProjectile(world, 2, target, 12.0F, this);
                teleport.setPosition(dragonPartHead.posX, dragonPartHead.posY, dragonPartHead.posZ);
                world.spawnEntity(teleport);
                break;
        }
    }

    public boolean destroyOrderBlocks(net.minecraft.util.math.AxisAlignedBB bounds) {
        if (world.isRemote || !net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, this)) return false;
        boolean blocked = false;
        for (net.minecraft.util.math.BlockPos pos : net.minecraft.util.math.BlockPos.getAllInBox(
                new net.minecraft.util.math.BlockPos(bounds.minX, bounds.minY, bounds.minZ),
                new net.minecraft.util.math.BlockPos(bounds.maxX, bounds.maxY, bounds.maxZ))) {
            net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
            net.minecraft.block.Block block = state.getBlock();
            if (block.isAir(state, world, pos)) continue;
            if (block == net.minecraft.init.Blocks.BEDROCK || block == net.minecraft.init.Blocks.END_PORTAL
                    || block == net.minecraft.init.Blocks.END_PORTAL_FRAME || block == net.minecraft.init.Blocks.COMMAND_BLOCK
                    || block == net.minecraft.init.Blocks.CHAIN_COMMAND_BLOCK || block == net.minecraft.init.Blocks.REPEATING_COMMAND_BLOCK
                    || block == net.minecraft.init.Blocks.BARRIER || block.getHarvestLevel(state) >= 12) {
                blocked = true;
            } else world.destroyBlock(pos, true);
        }
        return blocked;
    }

    @Override
    public boolean attackEntityFromPart(MultiPartEntityPart part, DamageSource source, float amount) {
        String type = source.getDamageType();
        if (type.equals("chaosImplosion") || type.startsWith("de.Guardian")) amount *= 0.15F;
        if (part != dragonPartHead) amount = amount / 4.0F + 1.0F;
        return attackEntityFrom(source, amount);
    }

    @Override
    protected void onDeathUpdate() {
        // 独立死亡动画，避免原生守卫搜索并修改整个岛屿的混沌水晶。
        deathTicks++;
        if (deathTicks == 1) world.playSound(null, posX, posY, posZ, SoundEvents.ENTITY_ENDERDRAGON_DEATH,
                SoundCategory.HOSTILE, 50.0F, 1.0F);
        if (deathTicks >= 180) world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, posX + rand.nextGaussian() * 4,
                posY + rand.nextDouble() * 4, posZ + rand.nextGaussian() * 4, 0, 0, 0);
        if (!world.isRemote && deathTicks >= 200) {
            int remaining = experienceValue;
            while (remaining > 0) {
                int split = EntityXPOrb.getXPSplit(remaining);
                remaining -= split;
                world.spawnEntity(new EntityXPOrb(world, posX, posY, posZ, split));
            }
            DragonChunkLoader.stopLoading(this);
            setDead();
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("CarryingCrystal", carryingCrystal);
        tag.setInteger("OrderSpecialAttackTicks", specialAttackTicks);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        carryingCrystal = tag.getBoolean("CarryingCrystal");
        specialAttackTicks = tag.getInteger("OrderSpecialAttackTicks");
        // 仪式给出三个 Home 坐标时，不能在首次 tick 用当前位置覆盖它们。
        if (tag.hasKey("HomeXCoord") && tag.hasKey("HomeYCoord") && tag.hasKey("HomeZCoord")) homeSet = true;
    }
}
