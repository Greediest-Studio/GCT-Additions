package com.shiver.gct_additions.common.blocks;

import net.minecraft.block.Block;

public class BlockSenterianCase4 extends BlockSenterianCase {
    public static final Block block = new BlockSenterianCase4();

    public BlockSenterianCase4() {
        super("senterian_case_4");
    }

    @Override
    protected String getDroppedItemId() {
        return "journey:lament_deconstructor_depths";
    }
}
