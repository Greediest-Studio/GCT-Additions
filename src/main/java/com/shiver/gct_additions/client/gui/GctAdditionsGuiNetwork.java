package com.shiver.gct_additions.client.gui;

import com.shiver.gct_additions.network.GctAdditionsNetwork;
import net.minecraftforge.fml.relauncher.Side;

public final class GctAdditionsGuiNetwork {
    private GctAdditionsGuiNetwork() {
    }

    public static void registerMessages() {
        GctAdditionsNetwork.register(GuiEarthbound.GUIButtonPressedMessageHandler.class,
                GuiEarthbound.GUIButtonPressedMessage.class, Side.SERVER);
        GctAdditionsNetwork.register(GuiEarthbound.GUISlotChangedMessageHandler.class,
                GuiEarthbound.GUISlotChangedMessage.class, Side.SERVER);

        GctAdditionsNetwork.register(GuiGUISanityAltar.GUIButtonPressedMessageHandler.class,
                GuiGUISanityAltar.GUIButtonPressedMessage.class, Side.SERVER);
        GctAdditionsNetwork.register(GuiGUISanityAltar.GUISlotChangedMessageHandler.class,
                GuiGUISanityAltar.GUISlotChangedMessage.class, Side.SERVER);
    }
}
