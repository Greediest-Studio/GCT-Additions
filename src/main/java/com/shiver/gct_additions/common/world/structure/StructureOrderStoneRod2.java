package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.dimension.WorldOrderland;
import com.shiver.gct_additions.common.world.biome.BiomeOrderBasin;
import com.shiver.gct_additions.common.world.biome.BiomeOrderPlain;

public class StructureOrderStoneRod2 extends BiomeSurfaceTemplateStructure {
    public StructureOrderStoneRod2() {
        super(WorldOrderland.DIMID, 50000, GctAllStructureTemplates.ORDER_ROD_2, 0, BiomeOrderBasin.biome, BiomeOrderPlain.biome);
    }
}
