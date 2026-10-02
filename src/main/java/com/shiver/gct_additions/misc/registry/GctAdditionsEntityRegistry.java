package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.Tags;
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
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public final class GctAdditionsEntityRegistry {
    private static int nextEntityId = 1;

    private GctAdditionsEntityRegistry() {
    }

    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        register(event, EntityDarkerLesserShoggoth.DarkerLesserShoggothEntity.class,
                "darkerlessershoggoth", nextEntityId++, 128, 3, true, -16777216, -1);
        registerProjectile(event, EntityDarkerLesserShoggoth.DarkerLesserShoggothProjectileEntity.class,
                "entitybulletdarkerlessershoggoth", nextEntityId++, 64, 1, true);
        register(event, EntityAncientShoggoth.AncientShoggothEntity.class,
                "ancientshoggoth", nextEntityId++, 256, 3, true, -16777216, -16777216);
        register(event, EntityShadowBase.ShadowBaseEntity.class,
                "shadow_base", nextEntityId++, 64, 3, true, -16777216, -6750208);
        register(event, EntityRemnantWandering.RemnantWanderingEntity.class,
                "remnant_wandering", nextEntityId++, 256, 3, true, -13421773, -1);

        register(event, EntityApocalypseCube.ApocalypseCubeEntity.class,
                "apocalypse_cube", nextEntityId++, 64, 3, true, -6750208, -3407872);
        register(event, EntityBlueFlameBeholder.BlueFlameBeholderEntity.class,
                "blue_flame_beholder", nextEntityId++, 64, 3, true, -16777216, -16750951);
        register(event, EntityBligtz.BligtzEntity.class,
                "bligtz", nextEntityId++, 64, 3, true, -3355648, -205);
        registerProjectile(event, EntityBligtz.BligtzProjectileEntity.class,
                "entitybulletbligtz", nextEntityId++, 64, 1, true);
        register(event, EntityZjarugoth.ZjarugothEntity.class,
                "zjarugoth", nextEntityId++, 512, 3, true, -16777216, -16711681);

        register(event, EntityBninz.BninzEntity.class,
                "bninz", nextEntityId++, 64, 3, true, -16777216, -10066330);
        registerProjectile(event, EntityBninz.BninzProjectileEntity.class,
                "entitybulletbninz", nextEntityId++, 64, 1, true);
        register(event, EntityMixtureShoggoth.MixtureShoggothEntity.class,
                "mixture_shoggoth", nextEntityId++, 64, 3, true, -16777216, -16711681);
        register(event, EntityBthdz.BthdzEntity.class,
                "bthdz", nextEntityId++, 64, 3, true, -16776961, -13395457);
        registerProjectile(event, EntityBthdz.BthdzProjectileEntity.class,
                "entitybulletbthdz", nextEntityId++, 64, 1, true);
        register(event, EntityBloodyShoggoth.BloodyShoggothEntity.class,
                "bloody_shoggoth", nextEntityId++, 64, 3, true, -16777216, -16711681);
        register(event, EntityBnatuz.BnatuzEntity.class,
                "bnatuz", nextEntityId++, 64, 3, true, -16738048, -16751002);
        registerProjectile(event, EntityBnatuz.BnatuzProjectileEntity.class,
                "entitybulletbnatuz", nextEntityId++, 64, 1, true);

        register(event, EntityApocalypseKnight.ApocalypseKnightEntity.class,
                "apocalypse_knight", nextEntityId++, 128, 3, true, -16777216, -3407770);
        register(event, EntityRottened.RottenedEntity.class,
                "rottened", nextEntityId++, 64, 3, true, -6750004, -13434727);
        register(event, EntityZethur.ZethurEntity.class,
                "zethur", nextEntityId++, 256, 3, true, -16777216, -10066330);
        register(event, EntityWeatherEyevil.WeatherEyevilEntity.class,
                "weather_eyevil", nextEntityId++, 256, 3, true, -16763905, -16711681);
        register(event, EntityWeatherWaterRod.WeatherWaterRodEntity.class,
                "weather_water_rod", nextEntityId++, 64, 3, true, -16776961, -13369345);
        register(event, EntityApocalypseHolder.ApocalypseHolderEntity.class,
                "apocalypse_holder", nextEntityId++, 64, 3, true, -1, -1);
        register(event, EntityElf.ElfEntity.class,
                "elf", nextEntityId++, 64, 3, true, -1, -1);
        register(event, EntityReversedElf.ReversedElfEntity.class,
                "reversed_elf", nextEntityId++, 64, 3, true, -11534229, -5273345);
    }

    private static void register(RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass,
            String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates,
            int eggPrimary, int eggSecondary) {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entityClass)
                .id(id(name), id)
                .name(name)
                .tracker(trackingRange, updateFrequency, sendsVelocityUpdates)
                .egg(eggPrimary, eggSecondary)
                .build());
    }

    private static void registerProjectile(RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass,
            String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entityClass)
                .id(id(name), id)
                .name(name)
                .tracker(trackingRange, updateFrequency, sendsVelocityUpdates)
                .build());
    }

    private static ResourceLocation id(String name) {
        return new ResourceLocation(Tags.MOD_ID, name);
    }
}
