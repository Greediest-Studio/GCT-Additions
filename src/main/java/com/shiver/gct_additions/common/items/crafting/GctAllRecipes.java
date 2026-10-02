package com.shiver.gct_additions.common.items.crafting;

import com.shiver.gct_additions.common.blocks.BlockManaCobbleStone;
import com.shiver.gct_additions.common.blocks.BlockManaStone;
import com.shiver.gct_additions.common.blocks.BlockOrderCobblestone;
import com.shiver.gct_additions.common.blocks.BlockOrderStone;
import com.shiver.gct_additions.common.blocks.BlockOrderStoneBrick;
import com.shiver.gct_additions.common.blocks.BlockOrderStoneBrickCrashed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class GctAllRecipes {
    private GctAllRecipes() {
    }

    public static void registerSmelting() {
        GameRegistry.addSmelting(new ItemStack(BlockManaCobbleStone.block), new ItemStack(BlockManaStone.block), 0.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderCobblestone.block), new ItemStack(BlockOrderStone.block), 1.0F);
        GameRegistry.addSmelting(new ItemStack(BlockOrderStoneBrick.block), new ItemStack(BlockOrderStoneBrickCrashed.block), 1.0F);
    }
}
