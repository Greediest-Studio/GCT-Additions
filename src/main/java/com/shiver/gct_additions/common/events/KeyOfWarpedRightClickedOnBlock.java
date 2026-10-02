package com.shiver.gct_additions.common.events;

import com.shiver.gct_additions.common.world.structure.GctAdditionsStructureTemplates;
import com.shiver.gct_additions.common.world.structure.PortalTemplateHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class KeyOfWarpedRightClickedOnBlock {
  private KeyOfWarpedRightClickedOnBlock() {
  }

  public static boolean run(Entity entity, World world, int x, int y, int z) {
    BlockPos pos = new BlockPos(x, y, z);
    return PortalTemplateHelper.placeFacingPortal(world, entity, pos, GctAdditionsStructureTemplates.DIM_55_PORTAL_1, GctAdditionsStructureTemplates.DIM_55_PORTAL_2);
  }
}

