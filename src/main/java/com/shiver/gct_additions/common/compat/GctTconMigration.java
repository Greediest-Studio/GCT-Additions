package com.shiver.gct_additions.common.compat;

import com.shiver.gct_additions.Tags;
import com.shiver.gct_additions.misc.registry.GctAdditionsAddonItems;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistry;

/** 保留移除 Gct_tcon 后的旧存档映射、药水类型和效果移除行为。 */
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class GctTconMigration {
    private static final String LEGACY_MOD_ID = "gct_tcon";
    private static final ResourceLocation LEGACY_DUST = new ResourceLocation(LEGACY_MOD_ID, "tinyplasmariumdust");
    private static final ResourceLocation TRAPPED = new ResourceLocation("contenttweaker", "trapped");
    private static final Set<String> EFFECTS = new HashSet<>(Arrays.asList(
            "acidity", "alkalinity", "anger", "anger_accumulation", "angry", "angry_accumulation",
            "contract", "cooperation_1", "cooperation_2", "excited_state", "ground_state", "shock",
            "spirit_possession", "superposition", "trapped"));
    private static final Set<String> POTION_TYPES = new HashSet<>(Arrays.asList("acidity", "alkalinity"));

    private GctTconMigration() {
    }

    @SubscribeEvent
    public static void registerPotionTypes(RegistryEvent.Register<PotionType> event) {
        // Potion 注册事件先于 PotionType，此时 ContentTweaker 的效果已经注册。
        for (String name : POTION_TYPES) {
            ResourceLocation id = new ResourceLocation("contenttweaker", name);
            Potion effect = ForgeRegistries.POTIONS.getValue(id);
            if (effect != null && !event.getRegistry().containsKey(id)) {
                event.getRegistry().register(new PotionType("contenttweaker." + name,
                        new PotionEffect(effect, 3600)).setRegistryName(id));
            }
        }
    }

    @SubscribeEvent
    public static void remapItems(RegistryEvent.MissingMappings<Item> event) {
        for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
            if (LEGACY_DUST.equals(mapping.key)) {
                mapping.remap(GctAdditionsAddonItems.TINY_PLASMARIUM_DUST);
            }
        }
    }

    @SubscribeEvent
    public static void remapEffects(RegistryEvent.MissingMappings<Potion> event) {
        remapContentTweakerEntries(event, EFFECTS, ForgeRegistries.POTIONS);
    }

    @SubscribeEvent
    public static void remapPotionTypes(RegistryEvent.MissingMappings<PotionType> event) {
        remapContentTweakerEntries(event, POTION_TYPES, ForgeRegistries.POTION_TYPES);
    }

    static <T extends IForgeRegistryEntry<T>> void remapContentTweakerEntries(
            RegistryEvent.MissingMappings<T> event, Set<String> names, IForgeRegistry<T> registeredEntries) {
        for (RegistryEvent.MissingMappings.Mapping<T> mapping : event.getAllMappings()) {
            if (!LEGACY_MOD_ID.equals(mapping.key.getNamespace()) || !names.contains(mapping.key.getPath())) {
                continue;
            }
            // 事件里的 registry 是旧存档的暂存表，新 ID 必须从当前注册表查找。
            T target = registeredEntries.getValue(new ResourceLocation("contenttweaker", mapping.key.getPath()));
            if (target != null) {
                mapping.remap(target);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPotionExpiry(PotionEvent.PotionExpiryEvent event) {
        damageTrapped(event);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPotionRemove(PotionEvent.PotionRemoveEvent event) {
        damageTrapped(event);
    }

    private static void damageTrapped(PotionEvent event) {
        PotionEffect effect = event.getPotionEffect();
        EntityLivingBase entity = event.getEntityLiving();
        if (entity.world.isRemote || effect == null || !TRAPPED.equals(effect.getPotion().getRegistryName())) {
            return;
        }
        entity.attackEntityFrom(DamageSource.MAGIC, entity.getHealth() * 0.2f);
    }
}
