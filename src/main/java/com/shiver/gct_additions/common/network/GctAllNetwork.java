package com.shiver.gct_additions.common.network;

import com.shiver.gct_additions.network.GctAdditionsNetwork;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAllNetwork {
    public static final SimpleNetworkWrapper CHANNEL = GctAdditionsNetwork.CHANNEL;

    private GctAllNetwork() {
    }

    public static <T extends IMessage, V extends IMessage> void register(
            Class<? extends IMessageHandler<T, V>> handler,
            Class<T> message,
            Side... sides
    ) {
        for (Side side : sides) {
            GctAdditionsNetwork.registerMessage(handler, message, side);
        }
    }
}
