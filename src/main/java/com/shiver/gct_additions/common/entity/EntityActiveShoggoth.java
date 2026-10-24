package com.shiver.gct_additions.common.entity;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.api.item.ACItems;
import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
import com.shinoow.abyssalcraft.api.entity.EntityUtil;
import com.shinoow.abyssalcraft.common.blocks.BlockShoggothOoze;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenShoggothMonolith;
import com.shinoow.abyssalcraft.lib.ACConfig;
import com.shinoow.abyssalcraft.lib.ACLoot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/** 活化实体有独立的玩家关系，不继承混合修格斯的敌对 AI。 */
public class EntityActiveShoggoth extends EntityTameable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityActiveShoggoth.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> FOOD = EntityDataManager.createKey(EntityActiveShoggoth.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> CLIMBING = EntityDataManager.createKey(EntityActiveShoggoth.class, DataSerializers.BOOLEAN);
    private int monolithTimer;

    public EntityActiveShoggoth(World world) {
        super(world);
        setSize(1.9F, 2.35F);
        isImmuneToFire = true;
        enablePersistence();
        experienceValue = 20;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(TYPE, 0);
        dataManager.register(FOOD, 0);
        dataManager.register(CLIMBING, false);
    }

    @Override
    protected void initEntityAI() {
        aiSit = new EntityAISit(this);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, aiSit);
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, true));
        tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 12.0F, 4.0F));
        tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(6, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, EntityMob.class, 10, true, false,
                mob -> !isOnSameTeam(mob) && !(mob instanceof EntityMixtureShoggoth.MixtureShoggothEntity)));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(ACConfig.hardcoreMode ? 200.0D : 100.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(ACConfig.hardcoreMode ? 16.0D : 8.0D);
    }

    @Override
    protected PathNavigate createNavigator(World world) { return new PathNavigateClimber(this, world); }

    @Override
    public boolean isOnLadder() { return dataManager.get(CLIMBING); }

    @Override
    protected boolean canDespawn() { return false; }

    public int getShoggothType() { return dataManager.get(TYPE); }
    public void setShoggothType(int type) { dataManager.set(TYPE, type); }
    public int getFoodLevel() { return dataManager.get(FOOD); }
    public void setFoodLevel(int food) { dataManager.set(FOOD, food); }

    public void feed() {
        setFoodLevel(getFoodLevel() + 1);
        if (isChild()) setGrowingAge(Math.min(0, getGrowingAge() + 4000));
        heal(5.0F);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        setSize(isChild() ? 0.95F : 1.9F, isChild() ? 1.175F : 2.35F);
        if (world.isRemote) return;
        if (ticksExisted % 20 == 0) heal(1.0F);
        dataManager.set(CLIMBING, collidedHorizontally);
        if (++monolithTimer >= 200 && !isInvisible()) {
            monolithTimer = 0;
            if (!isChild() && world.getEntitiesWithinAABB(EntityActiveShoggoth.class,
                    getEntityBoundingBox().grow(32.0D)).size() > 5
                    && ForgeEventFactory.getMobGriefingEvent(world, this)) {
                for (EntityActiveShoggoth shoggoth : world.getEntitiesWithinAABB(EntityActiveShoggoth.class,
                        getEntityBoundingBox().grow(16.0D))) shoggoth.monolithTimer = Math.max(0, shoggoth.monolithTimer - 100);
                new WorldGenShoggothMonolith().generate(world, rand, getPosition().add(3, 0, 3));
            }
        }
        // 每进食三次繁殖一个幼体。
        if (!isChild() && getFoodLevel() >= 3) {
            EntityActiveShoggoth child = new EntityActiveShoggoth(world);
            child.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
            child.setOwnerId(getOwnerId());
            child.setTamed(isTamed());
            child.setGrowingAge(-24000);
            child.setShoggothType(getShoggothType());
            if (world.spawnEntity(child)) {
                setFoodLevel(getFoodLevel() - 3);
                playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
            }
        }
        if (ACConfig.shoggothOoze && !isInvisible() && !isSitting()
                && ForgeEventFactory.getMobGriefingEvent(world, this)) {
            BlockPos pos = getPosition();
            spawnOoze(pos);
            if (!isChild()) {
                spawnOoze(pos.west());
                spawnOoze(pos.north());
                spawnOoze(pos.west().north());
            }
        }
    }

    private void spawnOoze(BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if ((state.getBlock().isAir(state, world, pos) || state.getBlock().isReplaceable(world, pos))
                && state.getBlock() != ACBlocks.shoggoth_ooze && !state.getMaterial().isLiquid()
                && ACBlocks.shoggoth_ooze.canPlaceBlockAt(world, pos)) {
            world.setBlockState(pos, ACBlocks.shoggoth_ooze.getDefaultState());
        } else if (state.getBlock() == ACBlocks.shoggoth_ooze && state.getValue(BlockShoggothOoze.LAYERS) < 8
                && ticksExisted % 10 == 0 && rand.nextInt(5) == 0) {
            world.setBlockState(pos, state.withProperty(BlockShoggothOoze.LAYERS,
                    state.getValue(BlockShoggothOoze.LAYERS) + 1));
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if (isOnSameTeam(target)) return false;
        boolean hit = target.attackEntityFrom(DamageSource.causeMobDamage(this),
                (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
        if (hit && target instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) target;
            switch (getShoggothType()) {
                case 1:
                    if (!EntityUtil.isEntityCoralium(living)) living.addPotionEffect(new PotionEffect(AbyssalCraftAPI.coralium_plague, 100));
                    break;
                case 2:
                    if (!EntityUtil.isEntityDread(living)) living.addPotionEffect(new PotionEffect(AbyssalCraftAPI.dread_plague, 100));
                    break;
                case 3: living.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100)); break;
                case 4: living.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100)); break;
            }
        }
        return hit;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return !source.isProjectile() && source != DamageSource.DROWN
                && (source.getTrueSource() == null || !isOnSameTeam(source.getTrueSource()))
                && super.attackEntityFrom(source, amount);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }

    @Override
    public boolean isPotionApplicable(PotionEffect effect) {
        if (getShoggothType() == 1 && effect.getPotion() == AbyssalCraftAPI.coralium_plague) return false;
        if (getShoggothType() == 2 && effect.getPotion() == AbyssalCraftAPI.dread_plague) return false;
        return super.isPotionApplicable(effect);
    }

    @Override
    protected ResourceLocation getLootTable() {
        switch (getShoggothType()) {
            case 1: return ACLoot.ENTITY_LESSER_ABYSSAL_SHOGGOTH;
            case 2: return ACLoot.ENTITY_LESSER_DREADED_SHOGGOTH;
            case 3: return ACLoot.ENTITY_LESSER_OMOTHOL_SHOGGOTH;
            case 4: return ACLoot.ENTITY_LESSER_SHADOW_SHOGGOTH;
            default: return ACLoot.ENTITY_LESSER_SHOGGOTH;
        }
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (getOwnerId() != null && !isOwner(player)) return false;
        if (stack.getItem() == ACItems.shoggoth_flesh) {
            if (!world.isRemote) {
                if (getShoggothType() != stack.getMetadata()) {
                    entityDropItem(new ItemStack(ACItems.shoggoth_flesh, 1, getShoggothType()), 1.0F);
                    setShoggothType(stack.getMetadata());
                } else {
                    feed();
                }
                if (!player.capabilities.isCreativeMode) stack.shrink(1);
            }
            return true;
        }
        if (stack.isEmpty()) {
            if (!world.isRemote) {
                if (isChild()) {
                    if (isRiding()) dismountRidingEntity(); else startRiding(player, true);
                } else {
                    aiSit.setSitting(!isSitting());
                    getNavigator().clearPath();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) { return false; }

    @Override
    public EntityAgeable createChild(EntityAgeable other) { return new EntityActiveShoggoth(world); }

    @Override
    public void onKillEntity(net.minecraft.entity.EntityLivingBase target) {
        super.onKillEntity(target);
        if (target instanceof EntityAnimal) feed();
    }

    @Override
    public void fall(float distance, float multiplier) {}

    @Override
    protected SoundEvent getAmbientSound() { return sound("ambient"); }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return sound("hurt"); }
    @Override
    protected SoundEvent getDeathSound() { return sound("death"); }
    private SoundEvent sound(String name) { return SoundEvent.REGISTRY.getObject(new ResourceLocation("gct_additions", "shoggoth_" + name)); }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setShoggothType(tag.getInteger("ShoggothType"));
        setFoodLevel(tag.getInteger("FoodLevel"));
        monolithTimer = tag.getInteger("MonolithTimer");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("ShoggothType", getShoggothType());
        tag.setInteger("FoodLevel", getFoodLevel());
        tag.setInteger("MonolithTimer", monolithTimer);
    }
}
