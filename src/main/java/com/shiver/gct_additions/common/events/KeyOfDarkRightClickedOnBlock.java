package com.shiver.gct_additions.common.events;

import com.shiver.gct_additions.common.world.structure.GctAllStructureTemplates;
import com.shiver.gct_additions.common.world.structure.PortalTemplateHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class KeyOfDarkRightClickedOnBlock {
  private KeyOfDarkRightClickedOnBlock() {
  }

  public static boolean run(Entity entity, World world, int x, int y, int z) {
    BlockPos pos = new BlockPos(x, y, z);
    return PortalTemplateHelper.placeFacingPortal(world, entity, pos, GctAllStructureTemplates.DIM_54_PORTAL_1, GctAllStructureTemplates.DIM_54_PORTAL_2);
  }
}

