package com.shiver.gct_additions.common.entity;

import com.shiver.gct_additions.common.entity.EntityAncientShoggoth;
import com.shiver.gct_additions.common.entity.EntityApocalypseCube;
import com.shiver.gct_additions.common.entity.EntityApocalypseHolder;
import com.shiver.gct_additions.common.entity.EntityApocalypseKnight;
import com.shiver.gct_additions.common.entity.EntityBligtz;
import com.shiver.gct_additions.common.entity.EntityBloodyShoggoth;
import com.shiver.gct_additions.common.entity.EntityBlueFlameBeholder;
import com.shiver.gct_additions.common.entity.EntityBnatuz;
import com.shiver.gct_additions.common.entity.EntityBninz;
import com.shiver.gct_additions.common.entity.EntityBthdz;
import com.shiver.gct_additions.common.entity.EntityDarkerLesserShoggoth;
import com.shiver.gct_additions.common.entity.EntityElf;
import com.shiver.gct_additions.common.entity.EntityMixtureShoggoth;
import com.shiver.gct_additions.common.entity.EntityRemnantWandering;
import com.shiver.gct_additions.common.entity.EntityReversedElf;
import com.shiver.gct_additions.common.entity.EntityRottened;
import com.shiver.gct_additions.common.entity.EntityShadowBase;
import com.shiver.gct_additions.common.entity.EntityWeatherEyevil;
import com.shiver.gct_additions.common.entity.EntityWeatherWaterRod;
import com.shiver.gct_additions.common.entity.EntityZethur;
import com.shiver.gct_additions.common.entity.EntityZjarugoth;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAllEntities {
    private GctAllEntities() {
    }

    public static void init(FMLInitializationEvent event) {
        EntityBlueFlameBeholder.init(event);
        EntityDarkerLesserShoggoth.init(event);
        EntityReversedElf.init(event);
        EntityRottened.init(event);
        EntityShadowBase.init(event);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenderers(FMLPreInitializationEvent event) {
        EntityAncientShoggoth.registerRenderers(event);
        EntityApocalypseCube.registerRenderers(event);
        EntityApocalypseHolder.registerRenderers(event);
        EntityApocalypseKnight.registerRenderers(event);
        EntityBligtz.registerRenderers(event);
        EntityBloodyShoggoth.registerRenderers(event);
        EntityBlueFlameBeholder.registerRenderers(event);
        EntityBnatuz.registerRenderers(event);
        EntityBninz.registerRenderers(event);
        EntityBthdz.registerRenderers(event);
        EntityDarkerLesserShoggoth.registerRenderers(event);
        EntityElf.registerRenderers(event);
        EntityMixtureShoggoth.registerRenderers(event);
        EntityRemnantWandering.registerRenderers(event);
        EntityReversedElf.registerRenderers(event);
        EntityRottened.registerRenderers(event);
        EntityShadowBase.registerRenderers(event);
        EntityWeatherEyevil.registerRenderers(event);
        EntityWeatherWaterRod.registerRenderers(event);
        EntityZethur.registerRenderers(event);
        EntityZjarugoth.registerRenderers(event);
    }
}
