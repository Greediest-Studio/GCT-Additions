package com.shiver.gct_additions.proxy;

import com.shiver.gct_additions.misc.registry.GctAdditionsLifecycle;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {
    static {
        FluidRegistry.enableUniversalBucket();
    }

    public void preInit(FMLPreInitializationEvent event) {
        GctAdditionsLifecycle.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        GctAdditionsLifecycle.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void serverLoad(FMLServerStartingEvent event) {
        GctAdditionsLifecycle.serverLoad(event);
    }
}
