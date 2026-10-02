package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.biome.BiomeAlfheimPlain;
import com.shiver.gct_additions.common.world.dimension.WorldAlfheim;

public class StructureElvenPost extends BiomeSurfaceTemplateStructure {
    public StructureElvenPost() {
        super(WorldAlfheim.DIMID, 10000, GctAdditionsStructureTemplates.ELVEN_POST, 0, BiomeAlfheimPlain.biome);
    }
}
