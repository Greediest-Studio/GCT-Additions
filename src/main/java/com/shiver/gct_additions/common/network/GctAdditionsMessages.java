package com.shiver.gct_additions.common.network;

import com.shiver.gct_additions.common.data.GctAdditionsVariables;
import com.shiver.gct_additions.network.GctAdditionsNetwork;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAdditionsMessages {
    private GctAdditionsMessages() {
    }

    public static void register() {
        GctAdditionsNetwork.register(GctAdditionsVariables.WorldSavedDataSyncMessageHandler.class,
                GctAdditionsVariables.WorldSavedDataSyncMessage.class, Side.SERVER, Side.CLIENT);
    }
}
