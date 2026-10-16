package com.shiver.gct_additions.common.blocks;

import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;

import java.util.Random;

public class BlockSenterianCase extends Block {
    public BlockSenterianCase(String name) {
        super(Material.ROCK);
        setTranslationKey(name);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 8);
        setHardness(50.0F);
        setResistance(4000.0F);
        setLightOpacity(15);
        setCreativeTab(GctAdditionsCreativeTab.TAB);
    }

    /** The external item id dropped by this case, in {@code modid:itemid} format. */
    protected String getDroppedItemId() {
        return null;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        String itemId = getDroppedItemId();
        Item item = itemId == null || itemId.isEmpty() ? null : Item.getByNameOrId(itemId);
        return item == null ? Items.AIR : item;
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
}
