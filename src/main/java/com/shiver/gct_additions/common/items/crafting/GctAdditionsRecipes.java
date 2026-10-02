package com.shiver.gct_additions.common.items.crafting;

import com.shiver.gct_additions.common.blocks.BlockManaCobbleStone;
import com.shiver.gct_additions.common.blocks.BlockManaStone;
import com.shiver.gct_additions.common.blocks.BlockOrderCobblestone;
import com.shiver.gct_additions.common.blocks.BlockOrderStone;
import com.shiver.gct_additions.common.blocks.BlockOrderStoneBrick;
import com.shiver.gct_additions.common.blocks.BlockOrderStoneBrickCrashed;
import com.shiver.gct_additions.misc.registry.GctAdditionsAddonItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class GctAdditionsRecipes {
    private GctAdditionsRecipes() {
    }

    public static void registerSmelting() {
        GameRegistry.addSmelting(new ItemStack(BlockManaCobbleStone.block), new ItemStack(BlockManaStone.block), 0.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderCobblestone.block), new ItemStack(BlockOrderStone.block), 1.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderStoneBrick.block), new ItemStack(BlockOrderStoneBrickCrashed.block), 1.0F);

        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.APOCALYPSIUM_DUST), new ItemStack(GctAdditionsAddonItems.APOCALYPSIUM_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.CHAOTIC_DRACONIUM_DUST), new ItemStack(GctAdditionsAddonItems.CHAOTIC_DRACONIUM_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.DENSITE_DUST), new ItemStack(GctAdditionsAddonItems.DENSITE_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.EQUIPMENT_WITHERIUM_DUST), new ItemStack(GctAdditionsAddonItems.EQUIPMENT_WITHERIUM_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.EVERITE_DUST), new ItemStack(GctAdditionsAddonItems.EVERITE_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.FALLEN_METAL_DUST), new ItemStack(GctAdditionsAddonItems.FALLEN_METAL_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.FIRE_ALLOY_DUST), new ItemStack(GctAdditionsAddonItems.FIRE_ALLOY_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.GENITE_DUST), new ItemStack(GctAdditionsAddonItems.GENITE_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.ICE_ALLOY_DUST), new ItemStack(GctAdditionsAddonItems.ICE_ALLOY_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.ORDERED_METAL_DUST), new ItemStack(GctAdditionsAddonItems.ORDERED_METAL_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.REDITRITE_DUST), new ItemStack(GctAdditionsAddonItems.REDITRITE_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.RELIFED_METAL_DUST), new ItemStack(GctAdditionsAddonItems.RELIFED_METAL_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.RELIFED_WITHERIUM_DUST), new ItemStack(GctAdditionsAddonItems.RELIFED_WITHERIUM_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.RULED_DRACONIUM_DUST), new ItemStack(GctAdditionsAddonItems.RULED_DRACONIUM_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.SKY_ALLOY_DUST), new ItemStack(GctAdditionsAddonItems.SKY_ALLOY_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.STORMY_METAL_DUST), new ItemStack(GctAdditionsAddonItems.STORMY_METAL_INGOT), 0.7F);
        GameRegistry.addSmelting(new ItemStack(GctAdditionsAddonItems.STORMY_WITHERIUM_DUST), new ItemStack(GctAdditionsAddonItems.STORMY_WITHERIUM_INGOT), 0.7F);
    }
}
