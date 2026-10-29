package com.shiver.gct_additions.client;

import com.brandon3055.draconicevolution.client.render.entity.RenderChaosGuardian;
import com.shiver.gct_additions.client.render.RenderActiveShoggoth;
import com.shiver.gct_additions.common.entity.EntityActiveShoggoth;
import com.shiver.gct_additions.common.entity.EntityOrderGuardian;
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
            RenderingRegistry.registerEntityRenderingHandler(EntityActiveShoggoth.class, RenderActiveShoggoth::new);
        }
    }
}
