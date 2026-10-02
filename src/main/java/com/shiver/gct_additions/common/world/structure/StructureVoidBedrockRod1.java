package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.dimension.WorldTheVoid;
import com.shiver.gct_additions.common.world.biome.BiomeVoidHill;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class StructureVoidBedrockRod1 extends BlockFilteredSurfaceTemplateStructure {
    public StructureVoidBedrockRod1() {
        super(WorldTheVoid.DIMID, 300000, GctAdditionsStructureTemplates.VOID_BEDROCK_ROD_1, Blocks.BEDROCK, BlockPos.ORIGIN.up(),
                BiomeVoidHill.biome);
    }
}
