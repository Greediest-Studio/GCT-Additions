package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.dimension.WorldTheVoid;
import com.shiver.gct_additions.common.world.biome.BiomeVoidHill;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class StructureVoidBedrockRodTreasure extends BlockFilteredSurfaceTemplateStructure {
    public StructureVoidBedrockRodTreasure() {
        super(WorldTheVoid.DIMID, 10000, GctAdditionsStructureTemplates.VOID_BEDROCK_ROD_TREASURE, Blocks.BEDROCK, BlockPos.ORIGIN.up(),
                BiomeVoidHill.biome);
    }
}
