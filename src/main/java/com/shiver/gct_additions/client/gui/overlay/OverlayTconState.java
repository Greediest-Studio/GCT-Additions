package com.shiver.gct_additions.client.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 显示 ContentTweaker 注册的匠魂基态、激发态，保留原中心图标。 */
@SideOnly(Side.CLIENT)
public final class OverlayTconState {
    private static final ResourceLocation GROUND_STATE = new ResourceLocation("contenttweaker", "ground_state");
    private static final ResourceLocation EXCITED_STATE = new ResourceLocation("contenttweaker", "excited_state");
    private static final ResourceLocation GROUND_TEXTURE = new ResourceLocation("contenttweaker", "textures/gui/tcon_states/ground_state.png");
    private static final ResourceLocation EXCITED_TEXTURE = new ResourceLocation("contenttweaker", "textures/gui/tcon_states/excited_state.png");

    @SubscribeEvent
    public void render(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.HELMET || mc.player == null) {
            return;
        }

        Potion excited = ForgeRegistries.POTIONS.getValue(EXCITED_STATE);
        Potion ground = ForgeRegistries.POTIONS.getValue(GROUND_STATE);
        ResourceLocation texture;
        if (excited != null && mc.player.isPotionActive(excited)) {
            texture = EXCITED_TEXTURE;
        } else if (ground != null && mc.player.isPotionActive(ground)) {
            texture = GROUND_TEXTURE;
        } else {
            return;
        }

        int x = event.getResolution().getScaledWidth() / 2 - 8;
        int y = event.getResolution().getScaledHeight() / 2 - 8;
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
                GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(texture);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 16, 16, 16, 16);
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
    }
}
