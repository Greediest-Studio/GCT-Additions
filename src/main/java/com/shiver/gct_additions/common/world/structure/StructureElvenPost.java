package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.biome.BiomeAlfheimPlain;
import com.shiver.gct_additions.common.world.dimension.WorldAlfheim;

public class StructureElvenPost extends DeterministicRegionStructure {
    public static final int SPACING = 10;
    public static final int SEPARATION = 2;
    public static final long SALT = 42002L;
    public static final int ORIGIN_RANGE_X = 18;
    public static final int ORIGIN_RANGE_Z = 17;

    public StructureElvenPost() {
        super(
                WorldAlfheim.DIMID,
                GctAdditionsStructureTemplates.ELVEN_POST,
                0,
                SPACING,
                SEPARATION,
                SALT,
                ORIGIN_RANGE_X,
                ORIGIN_RANGE_Z,
                BiomeAlfheimPlain.biome);
    }
}
