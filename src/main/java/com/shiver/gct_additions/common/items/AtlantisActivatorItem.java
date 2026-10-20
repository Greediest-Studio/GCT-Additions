package com.shiver.gct_additions.common.items;

import com.shiver.gct_additions.common.world.dimension.WorldAtlantis;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** Activates an Atlantis portal frame made from vanilla prismarine. */
public class AtlantisActivatorItem extends Item {
    public AtlantisActivatorItem() {
        setMaxStackSize(1);
        setTranslationKey("atlantis");
        setRegistryName("atlantis");
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
        // The core is an activator only; it has no standalone ignition or teleport action.
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    private EnumActionResult activate(EntityPlayer player, World world, BlockPos clickedPos, EnumHand hand) {
        if (world.getBlockState(clickedPos).getBlock() != Blocks.PRISMARINE) {
            return EnumActionResult.PASS;
        }
        if (!player.canPlayerEdit(clickedPos, EnumFacing.UP, player.getHeldItem(hand))) {
            return EnumActionResult.FAIL;
        }
        if (world.isRemote) {
            return EnumActionResult.SUCCESS;
        }

        // Try both portal axes around the clicked frame block. WorldAtlantis.Size
        // validates the complete prismarine frame before placing any portal blocks.
        for (EnumFacing direction : EnumFacing.values()) {
            WorldAtlantis.portal.portalSpawn(world, clickedPos.offset(direction));
        }
        return hasPortalNear(world, clickedPos) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    private boolean hasPortalNear(World world, BlockPos center) {
        Block portal = WorldAtlantis.portal;
        for (BlockPos pos : BlockPos.getAllInBox(center.add(-24, -2, -24), center.add(24, 22, 24))) {
            if (world.getBlockState(pos).getBlock() == portal) {
                return true;
            }
        }
        return false;
    }
}
