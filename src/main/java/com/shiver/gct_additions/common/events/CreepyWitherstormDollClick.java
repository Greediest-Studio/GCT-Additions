package com.shiver.gct_additions.common.events;

import com.shiver.gct_additions.common.world.dimension.WorldTheVoid;
import com.wdcftgg.witherstormmod.common.entity.WitherStormEntity;
import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public final class CreepyWitherstormDollClick {
    private CreepyWitherstormDollClick() {}

    public static boolean summon(EntityPlayer player, World world, ItemStack doll) {
        if (world.isRemote) return true;
        if (world.provider.getDimension() != WorldTheVoid.DIMID) {
            player.sendMessage(new TextComponentString("恐怖的风暴凋灵玩偶：我貌似不能在这个维度施展能力……"));
            return false;
        }
        if (!GameStageHelper.hasStage(player, "chaotic")) {
            return false;
        }
        WitherStormEntity storm = new WitherStormEntity(world);
        storm.setLocationAndAngles(player.posX, player.posY + 5.0D, player.posZ, player.rotationYaw, 0.0F);
        storm.makeInvulnerable();
        if (!world.spawnEntity(storm)) {
            return false;
        }
        if (!player.capabilities.isCreativeMode) doll.shrink(1);
        player.sendMessage(new TextComponentString("小心，它来了！"));
        return true;
    }
}


