package com.shiver.gct_additions.network;

import com.shiver.gct_additions.Tags;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAdditionsNetwork {
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(Tags.MOD_ID);
    private static int packetId = 0;

    private GctAdditionsNetwork() {
    }

    public static <T extends IMessage, V extends IMessage> void registerMessage(
            Class<? extends IMessageHandler<T, V>> handler,
            Class<T> message,
            Side side
    ) {
        CHANNEL.registerMessage(handler, message, packetId++, side);
    }
}
