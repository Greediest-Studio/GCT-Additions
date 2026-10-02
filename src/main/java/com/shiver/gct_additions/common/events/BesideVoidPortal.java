package com.shiver.gct_additions.common.events;

import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal1;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal3;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class BesideVoidPortal {
  private BesideVoidPortal() {
  }

  public static void run(World world, int x, int y, int z) {
    if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      world.setBlockState(new BlockPos(x, y + 1, z), BlockBesideVoidPortal1.block.getDefaultState(), 3);
    if (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock())
      world.setBlockState(new BlockPos(x, y - 1, z), BlockBesideVoidPortal3.block.getDefaultState(), 3);
  }
}

