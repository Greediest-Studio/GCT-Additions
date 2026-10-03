package com.shiver.gct_additions.misc.registry;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/** Handles fluid name collisions without allowing a null fluid into a block. */
public final class GctAdditionsFluidRegistry {
    private GctAdditionsFluidRegistry() {
    }

    public static Fluid register(Fluid fluid) {
        if (FluidRegistry.registerFluid(fluid)) {
            return fluid;
        }

        Fluid registeredFluid = FluidRegistry.getFluid(fluid.getName());
        return registeredFluid != null ? registeredFluid : fluid;
    }
}
