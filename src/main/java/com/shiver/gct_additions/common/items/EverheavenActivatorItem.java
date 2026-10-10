package com.shiver.gct_additions.common.items;

import com.shiver.gct_additions.common.blocks.BlockHeavite;
import com.shiver.gct_additions.common.world.dimension.WorldEverheaven;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** Activates an Everheaven portal frame made from Heavite blocks. */
public class EverheavenActivatorItem extends Item {
    public EverheavenActivatorItem() {
        setMaxStackSize(1);
        setTranslationKey("everheaven");
        setRegistryName("everheaven");
        setCreativeTab(GctAdditionsCreativeTab.TAB);
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing facing,
            float hitX, float hitY, float hitZ, EnumHand hand) {
        return activate(player, world, pos, hand);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        return activate(player, world, pos, hand);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    private EnumActionResult activate(EntityPlayer player, World world, BlockPos clickedPos, EnumHand hand) {
        if (world.getBlockState(clickedPos).getBlock() != BlockHeavite.block) {
            return EnumActionResult.PASS;
        }
        if (!player.canPlayerEdit(clickedPos, EnumFacing.UP, player.getHeldItem(hand))) {
            return EnumActionResult.FAIL;
        }
        if (world.isRemote) {
            return EnumActionResult.SUCCESS;
        }

        for (EnumFacing direction : EnumFacing.values()) {
            WorldEverheaven.portal.portalSpawn(world, clickedPos.offset(direction));
        }
        return hasPortalNear(world, clickedPos) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    private boolean hasPortalNear(World world, BlockPos center) {
        Block portal = WorldEverheaven.portal;
        for (BlockPos pos : BlockPos.getAllInBox(center.add(-24, -2, -24), center.add(24, 22, 24))) {
            if (world.getBlockState(pos).getBlock() == portal) {
                return true;
            }
        }
        return false;
    }
}
