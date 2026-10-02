package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.GctAdditionsGuiHandler;
import com.shiver.gct_additions.GctAdditions;
import com.shiver.gct_additions.common.commands.GctAdditionsCommands;
import com.shiver.gct_additions.common.data.GctAdditionsVariableEvents;
import com.shiver.gct_additions.common.entity.GctAdditionsEntities;
import com.shiver.gct_additions.common.events.SanityEvents;
import com.shiver.gct_additions.common.events.StarlandDaylightKick;
import com.shiver.gct_additions.client.gui.GctAdditionsGuiNetwork;
import com.shiver.gct_additions.common.items.crafting.GctAdditionsRecipes;
import com.shiver.gct_additions.common.network.GctAdditionsMessages;
import com.shiver.gct_additions.common.world.biome.GctAdditionsBiomes;
import com.shiver.gct_additions.common.world.dimension.GctAdditionsDimensions;
import com.shiver.gct_additions.common.world.structure.GctAdditionsStructureGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class GctAdditionsLifecycle {
    private GctAdditionsLifecycle() {
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new GctAdditionsStructureGenerator(), 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(GctAdditions.INSTANCE, new GctAdditionsGuiHandler());

        GctAdditionsContent.preInit(event);
        GctAdditionsTileEntities.register();
        GctAdditionsDimensions.registerDimensions();
        GctAdditionsMessages.register();
        GctAdditionsGuiNetwork.registerMessages();
        MinecraftForge.EVENT_BUS.register(new GctAdditionsVariableEvents());
        MinecraftForge.EVENT_BUS.register(new SanityEvents());
        MinecraftForge.EVENT_BUS.register(new StarlandDaylightKick());
    }

    public static void init(FMLInitializationEvent event) {
        GctAdditionsBiomes.init();
        GctAdditionsOreDictionary.register();
        GctAdditionsRecipes.registerSmelting();
        GctAdditionsEntities.init(event);
    }

    public static void serverLoad(FMLServerStartingEvent event) {
        GctAdditionsCommands.register(event);
    }
}
