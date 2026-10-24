package com.shiver.gct_additions.client;

import com.brandon3055.draconicevolution.client.render.entity.RenderChaosGuardian;
import com.shiver.gct_additions.common.entity.EntityActiveShoggoth;
import com.shiver.gct_additions.common.entity.EntityMixtureShoggoth;
import com.shiver.gct_additions.common.entity.EntityOrderGuardian;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ReplacementEntityRenderers {
    private ReplacementEntityRenderers() {}

    public static void register() {
        if (Loader.isModLoaded("draconicevolution")) {
            RenderingRegistry.registerEntityRenderingHandler(EntityOrderGuardian.class, RenderChaosGuardian::new);
        }
        if (Loader.isModLoaded("abyssalcraft")) {
            RenderingRegistry.registerEntityRenderingHandler(EntityActiveShoggoth.class, manager ->
                    new RenderLiving<EntityActiveShoggoth>(manager, new EntityMixtureShoggoth.ModelShoggoth(), 1.0F) {
                        @Override
                        protected ResourceLocation getEntityTexture(EntityActiveShoggoth entity) {
                            String[] textures = {"lessershoggoth", "abyssalshoggoth", "dreadedshoggoth", "omotholshoggoth", "shadowshoggoth"};
                            return new ResourceLocation("abyssalcraft:textures/model/shoggoth/"
                                    + textures[entity.getShoggothType()] + ".png");
                        }

                        @Override
                        protected void preRenderCallback(EntityActiveShoggoth entity, float partialTicks) {
                            float scale = entity.isChild() ? 0.38F : 0.76F;
                            GlStateManager.scale(scale, scale, scale);
                        }
                    });
        }
    }
}
