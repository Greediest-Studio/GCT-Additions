package com.shiver.gct_additions.client.render;

import com.shinoow.abyssalcraft.client.model.entity.ModelLesserShoggoth;
import com.shinoow.abyssalcraft.lib.ACConfig;
import com.shiver.gct_additions.common.entity.EntityActiveShoggoth;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderActiveShoggoth extends RenderLiving<EntityActiveShoggoth> {

    private static final ResourceLocation[] TEXTURES = new ResourceLocation[] {
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/lessershoggoth.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/abyssalshoggoth.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/dreadedshoggoth.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/omotholshoggoth.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/shadowshoggoth.png")
    };

    private static final ResourceLocation[] EYE_TEXTURES = new ResourceLocation[] {
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/lessershoggoth_eyes.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/abyssalshoggoth_eyes.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/dreadedshoggoth_eyes.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/omotholshoggoth_eyes.png"),
            new ResourceLocation("abyssalcraft:textures/model/shoggoth/shadowshoggoth_eyes.png")
    };

    public RenderActiveShoggoth(RenderManager renderManager) {
        super(renderManager, new ModelLesserShoggoth(), 1.6F);
        addLayer(new LayerActiveShoggothEyes(this));
    }

    @Override
    protected void renderModel(EntityActiveShoggoth entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if (entity.getShoggothType() < 4) {
            super.renderModel(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
            return;
        }
        GlStateManager.color(1.0F, 1.0F, 1.0F, entity.getBrightness());
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        super.renderModel(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        GlStateManager.disableBlend();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityActiveShoggoth entity) {
        int type = Math.max(0, Math.min(entity.getShoggothType(), TEXTURES.length - 1));
        return TEXTURES[type];
    }

    public static class LayerActiveShoggothEyes implements LayerRenderer<EntityActiveShoggoth> {
        private final RenderActiveShoggoth renderer;

        public LayerActiveShoggothEyes(RenderActiveShoggoth renderer) {
            this.renderer = renderer;
        }

        @Override
        public void doRenderLayer(EntityActiveShoggoth entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            if (!ACConfig.shoggothGlowingEyes) return;
            int type = Math.max(0, Math.min(entity.getShoggothType(), EYE_TEXTURES.length - 1));
            this.renderer.bindTexture(EYE_TEXTURES[type]);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            if (entity.isInvisible()) {
                GlStateManager.depthMask(false);
            } else {
                GlStateManager.depthMask(true);
            }
            int i = 61680;
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            if (entity.getShoggothType() == 4) {
                GlStateManager.color(1.0F, 1.0F, 1.0F, entity.getBrightness());
            } else {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            }
            this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            i = entity.getBrightnessForRender();
            j = i % 65536;
            k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            this.renderer.setLightmap(entity);
            GlStateManager.disableBlend();
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}
