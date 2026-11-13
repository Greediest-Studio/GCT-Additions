package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.biome.BiomeReversedForest;
import com.shiver.gct_additions.common.world.dimension.WorldAlfheim;

public class StructureReversedDungeon extends DeterministicRegionStructure {
    public static final int SPACING = 14;
    public static final int SEPARATION = 3;
    public static final long SALT = 42001L;
    public static final int ORIGIN_RANGE_X = 14;
    public static final int ORIGIN_RANGE_Z = 15;
    public static final int Y_OFFSET = -50;

    public StructureReversedDungeon() {
        super(
                WorldAlfheim.DIMID,
                GctAdditionsStructureTemplates.REVERSED_DUNGEON,
                Y_OFFSET,
                SPACING,
                SEPARATION,
                SALT,
                ORIGIN_RANGE_X,
                ORIGIN_RANGE_Z,
                BiomeReversedForest.biome);
    }
}
