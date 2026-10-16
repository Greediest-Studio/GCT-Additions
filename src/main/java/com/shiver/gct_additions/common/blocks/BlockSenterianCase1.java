package com.shiver.gct_additions.common.blocks;

import net.minecraft.block.Block;

public class BlockSenterianCase1 extends BlockSenterianCase {
    public static final Block block = new BlockSenterianCase1();

    public BlockSenterianCase1() {
        super("senterian_case_1");
    }

    @Override
    protected String getDroppedItemId() {
        return "journey:lament_deconstructor_nether";
    }
}
