package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.dimension.WorldOrderland;
import com.shiver.gct_additions.common.world.biome.BiomeOrderBasin;
import com.shiver.gct_additions.common.world.biome.BiomeOrderPlain;

public class StructureOrderStoneRod extends BiomeSurfaceTemplateStructure {
    public StructureOrderStoneRod() {
        super(WorldOrderland.DIMID, 100000, GctAllStructureTemplates.ORDER_ROD_1, 0, BiomeOrderBasin.biome, BiomeOrderPlain.biome);
    }
}
