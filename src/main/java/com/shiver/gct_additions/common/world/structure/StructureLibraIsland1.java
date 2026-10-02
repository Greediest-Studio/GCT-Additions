package com.shiver.gct_additions.common.world.structure;

import com.shiver.gct_additions.common.world.biome.BiomeLibraIsland;
import com.shiver.gct_additions.common.world.dimension.WorldStarland;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureLibraIsland1 extends AirborneTemplateStructure {
    public StructureLibraIsland1() {
        super(WorldStarland.DIMID, 250000, GctAdditionsStructureTemplates.ASTRAL_ISLAND_1, 17, 50, 0);
    }

    @Override
    protected boolean canGenerateAt(World world, BlockPos origin) {
        return hasBiome(world, origin, BiomeLibraIsland.biome);
    }
}
