package com.shiver.gct_additions.common.data;

import com.shiver.gct_additions.network.GctAdditionsNetwork;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class GctAdditionsVariableEvents {
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.world.isRemote && event.player instanceof EntityPlayerMP) {
            WorldSavedData mapData = GctAdditionsVariables.MapVariables.get(event.player.world);
            WorldSavedData worldData = GctAdditionsVariables.WorldVariables.get(event.player.world);
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            GctAdditionsNetwork.CHANNEL.sendTo(new GctAdditionsVariables.WorldSavedDataSyncMessage(0, mapData), player);
            GctAdditionsNetwork.CHANNEL.sendTo(new GctAdditionsVariables.WorldSavedDataSyncMessage(1, worldData), player);
        }
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.world.isRemote && event.player instanceof EntityPlayerMP) {
            WorldSavedData worldData = GctAdditionsVariables.WorldVariables.get(event.player.world);
            GctAdditionsNetwork.CHANNEL.sendTo(new GctAdditionsVariables.WorldSavedDataSyncMessage(1, worldData),
                    (EntityPlayerMP) event.player);
        }
    }
}
