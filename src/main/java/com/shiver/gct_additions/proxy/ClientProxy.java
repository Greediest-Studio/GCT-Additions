package com.shiver.gct_additions.proxy;

import com.shiver.gct_additions.Tags;
import com.shiver.gct_additions.misc.registry.GctAdditionsClientLifecycle;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(Tags.MOD_ID);
        GctAdditionsClientLifecycle.preInit(event, Tags.MOD_ID);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        GctAdditionsClientLifecycle.init(event);
    }
}
