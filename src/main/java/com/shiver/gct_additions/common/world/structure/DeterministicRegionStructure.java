package com.shiver.gct_additions.common.world.structure;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

abstract class DeterministicRegionStructure implements StructureFeature {
    private static final long REGION_PRIME_X = 341873128712L;
    private static final long REGION_PRIME_Z = 132897987541L;

    private final int dimensionId;
    private final StructureTemplateId templateId;
    private final int yOffset;
    private final int spacing;
    private final int separation;
    private final long salt;
    private final int originRangeX;
    private final int originRangeZ;
    @Nullable
    private final Biome requiredBiome;

    protected DeterministicRegionStructure(
            int dimensionId,
            StructureTemplateId templateId,
            int yOffset,
            int spacing,
            int separation,
            long salt,
            int originRangeX,
            int originRangeZ,
            @Nullable Biome requiredBiome) {
        if (spacing <= separation || separation < 0 || originRangeX < 1 || originRangeZ < 1) {
            throw new IllegalArgumentException("Invalid region parameters for " + templateId.getResourceLocation());
        }
        this.dimensionId = dimensionId;
        this.templateId = templateId;
        this.yOffset = yOffset;
        this.spacing = spacing;
        this.separation = separation;
        this.salt = salt;
        this.originRangeX = originRangeX;
        this.originRangeZ = originRangeZ;
        this.requiredBiome = requiredBiome;
    }

    @Override
    public void generateWorld(Random random, int blockX, int blockZ, World world, int worldDimensionId,
            IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.isRemote || worldDimensionId != dimensionId) {
            return;
        }

        int chunkX = Math.floorDiv(blockX, 16);
        int chunkZ = Math.floorDiv(blockZ, 16);
        int regionX = Math.floorDiv(chunkX, spacing);
        int regionZ = Math.floorDiv(chunkZ, spacing);
        RegionCandidate candidate = computeRegionCandidate(
                world.getSeed(), regionX, regionZ, spacing, separation, salt, originRangeX, originRangeZ);
        if (candidate.chunkX != chunkX || candidate.chunkZ != chunkZ) {
            return;
        }

        BlockPos biomePos = new BlockPos(candidate.originX, 0, candidate.originZ);
        if (requiredBiome != null && world.getBiome(biomePos) != requiredBiome) {
            return;
        }

        int surfaceY = findDeterministicSurfaceY(world, chunkGenerator, candidate.originX, candidate.originZ);
        if (surfaceY < 0) {
            return;
        }

        BlockPos origin = new BlockPos(candidate.originX, surfaceY + yOffset, candidate.originZ);
        StructureGenerationHelper.placeTemplateDeterministic(world, templateId, origin);
    }

    static RegionCandidate computeRegionCandidate(
            long seed,
            int regionX,
            int regionZ,
            int spacing,
            int separation,
            long salt,
            int originRangeX,
            int originRangeZ) {
        long regionSeed = (long) regionX * REGION_PRIME_X + (long) regionZ * REGION_PRIME_Z + seed + salt;
        Random rng = new Random(regionSeed);
        int bound = spacing - separation;
        int candChunkX = regionX * spacing + rng.nextInt(bound);
        int candChunkZ = regionZ * spacing + rng.nextInt(bound);
        int localX = 1 + (originRangeX > 1 ? rng.nextInt(originRangeX) : 0);
        int localZ = 1 + (originRangeZ > 1 ? rng.nextInt(originRangeZ) : 0);
        return new RegionCandidate(candChunkX, candChunkZ, candChunkX * 16 + localX, candChunkZ * 16 + localZ);
    }

    static int findDeterministicSurfaceY(World world, @Nullable IChunkGenerator chunkGenerator, int worldX, int worldZ) {
        if (chunkGenerator != null) {
            Chunk rawChunk = chunkGenerator.generateChunk(worldX >> 4, worldZ >> 4);
            return findChunkSurfaceY(rawChunk, worldX, worldZ);
        }
        return StructureGenerationHelper.findSurfaceY(world, worldX, worldZ, false);
    }

    static int findChunkSurfaceY(Chunk chunk, int worldX, int worldZ) {
        int localX = worldX & 15;
        int localZ = worldZ & 15;
        int topY = chunk.getHeightValue(localX, localZ);
        if (topY <= 0) {
            return -1;
        }
        int y = Math.min(topY, 255);
        while (y > 0 && !isSolidState(chunk.getBlockState(localX, y, localZ))) {
            y--;
        }
        return isSolidState(chunk.getBlockState(localX, y, localZ)) ? y - 1 : -1;
    }

    private static boolean isSolidState(IBlockState state) {
        return state.getBlock() != Blocks.AIR && state.getMaterial().blocksMovement();
    }

    static final class RegionCandidate {
        final int chunkX;
        final int chunkZ;
        final int originX;
        final int originZ;

        RegionCandidate(int chunkX, int chunkZ, int originX, int originZ) {
            this.chunkX = chunkX;
            this.chunkZ = chunkZ;
            this.originX = originX;
            this.originZ = originZ;
        }
    }
}
