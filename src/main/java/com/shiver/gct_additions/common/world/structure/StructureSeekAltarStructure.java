package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.dimension.WorldWarpedRuin;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class StructureSeekAltarStructure extends DeterministicRegionStructure {
    public static final int SPACING = 18;
    public static final int SEPARATION = 4;
    public static final long SALT = 55001L;
    public static final int ORIGIN_RANGE_X = 1;
    public static final int ORIGIN_RANGE_Z = 1;
    public static final int SIZE_X = 29;
    public static final int SIZE_Z = 29;

    public StructureSeekAltarStructure() {
        super(
                WorldWarpedRuin.DIMID,
                GctAdditionsStructureTemplates.SEEK_ALTAR,
                0,
                SPACING,
                SEPARATION,
                SALT,
                ORIGIN_RANGE_X,
                ORIGIN_RANGE_Z,
                null);
    }

    static boolean reservesBounds(World world, StructureBoundingBox bounds) {
        if (world.provider == null || world.provider.getDimension() != WorldWarpedRuin.DIMID) {
            return false;
        }
        return reservesBounds(world.getSeed(), bounds);
    }

    static boolean reservesBounds(long seed, StructureBoundingBox bounds) {
        int minChunkX = Math.floorDiv(bounds.minX - (ORIGIN_RANGE_X + SIZE_X - 1), 16);
        int maxChunkX = Math.floorDiv(bounds.maxX - 1, 16);
        int minChunkZ = Math.floorDiv(bounds.minZ - (ORIGIN_RANGE_Z + SIZE_Z - 1), 16);
        int maxChunkZ = Math.floorDiv(bounds.maxZ - 1, 16);

        int minRegionX = Math.floorDiv(minChunkX, SPACING);
        int maxRegionX = Math.floorDiv(maxChunkX, SPACING);
        int minRegionZ = Math.floorDiv(minChunkZ, SPACING);
        int maxRegionZ = Math.floorDiv(maxChunkZ, SPACING);

        for (int rx = minRegionX; rx <= maxRegionX; rx++) {
            for (int rz = minRegionZ; rz <= maxRegionZ; rz++) {
                RegionCandidate candidate = computeRegionCandidate(
                        seed, rx, rz, SPACING, SEPARATION, SALT, ORIGIN_RANGE_X, ORIGIN_RANGE_Z);
                int maxX = candidate.originX + SIZE_X - 1;
                int maxZ = candidate.originZ + SIZE_Z - 1;
                if (maxX >= bounds.minX && candidate.originX <= bounds.maxX
                        && maxZ >= bounds.minZ && candidate.originZ <= bounds.maxZ) {
                    return true;
                }
            }
        }
        return false;
    }
}
