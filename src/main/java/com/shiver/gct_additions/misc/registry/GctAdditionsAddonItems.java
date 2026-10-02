package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.client.GctAdditionsModels;
import com.shiver.gct_additions.common.items.InfoItem;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAdditionsAddonItems {
    private GctAdditionsAddonItems() {
    }

    public static final Item ABYSS_WAND = new InfoItem("abyss_wand", 64, 0, "§b带着一点扭曲的感觉", true);
    public static final Item ADENINITE_NUGGET = simple("adeninite_nugget");
    public static final Item AETHERIUM_NUGGET = simple("aetherium_nugget");
    public static final Item APOCALYPSIUM_DUST = simple("apocalypsium_dust");
    public static final Item APOCALYPSIUM_GEAR = simple("apocalypsium_gear");
    public static final Item APOCALYPSIUM_INGOT = simple("apocalypsium_ingot");
    public static final Item APOCALYPSIUM_NUGGET = simple("apocalypsium_nugget");
    public static final Item APOCALYPSIUM_PLATE = simple("apocalypsium_plate");
    public static final Item AWAKENED_DRACONIUM_DUST = simple("awakened_draconium_dust");
    public static final Item AZATHOTHIUM_INGOT = simple("azathothium_ingot");
    public static final Item BALANCED_MATRIX_INGOT = simple("balanced_matrix_ingot");
    public static final Item BEGONIUM_INGOT = simple("begonium_ingot");
    public static final Item BLUE_PRINT_EMPTY = new InfoItem("blue_print_empty", 64, 0, "用于合成模块化蓝图！", false);
    public static final Item BLUE_PRINT_FORGE = new InfoItem("blue_print_forge", 64, 0, "用于合成金属熔炉的蓝图", false);
    public static final Item BNIGHTIUM_NUGGET = simple("bnightium_nugget");
    public static final Item BOTANICAL_INGOT = simple("botanical_ingot");
    public static final Item BOTANICAL_INGOT_AWAKENED = simple("botanical_ingot_awakened");
    public static final Item BOTANICAL_SOUL = simple("botanical_soul");
    public static final Item CANOPIUM_NUGGET = simple("canopium_nugget");
    public static final Item CARNATIONIUM_INGOT = simple("carnationium_ingot");
    public static final Item CHAOTIC_DRACONIUM_DUST = simple("chaotic_draconium_dust");
    public static final Item CHAOTIC_DRACONIUM_GEAR = simple("chaotic_draconium_gear");
    public static final Item CHAOTIC_DRACONIUM_INGOT = simple("chaotic_draconium_ingot");
    public static final Item CHAOTIC_DRACONIUM_NUGGET = simple("chaotic_draconium_nugget");
    public static final Item CHAOTIC_DRACONIUM_PLATE = simple("chaotic_draconium_plate");
    public static final Item CHRYSANTHEMIUM_INGOT = simple("chrysanthemium_ingot");
    public static final Item COMMAND_CORE = new InfoItem("command_core", 64, 0, false, new String[] { "太棒了，这个东西有着至高无上的命令权限！", "用于合成命令方块" });
    public static final Item COSMILITE_NUGGET = simple("cosmilite_nugget");
    public static final Item CTHULHURITE_INGOT = simple("cthulhurite_ingot");
    public static final Item DANDELIONIUM_INGOT = simple("dandelionium_ingot");
    public static final Item DENSITE_DUST = simple("densite_dust");
    public static final Item DENSITE_GEAR = simple("densite_gear");
    public static final Item DENSITE_INGOT = simple("densite_ingot");
    public static final Item DENSITE_NUGGET = simple("densite_nugget");
    public static final Item DENSITE_PLATE = simple("densite_plate");
    public static final Item ELEMENTINE_INGOT = simple("elementine_ingot");
    public static final Item ELEMENTIUM_FUSIONPLATE = simple("elementium_fusionplate");
    public static final Item EQUIPMENT_WITHERIUM_DUST = simple("equipment_witherium_dust");
    public static final Item EQUIPMENT_WITHERIUM_GEAR = simple("equipment_witherium_gear");
    public static final Item EQUIPMENT_WITHERIUM_INGOT = simple("equipment_witherium_ingot");
    public static final Item EQUIPMENT_WITHERIUM_NUGGET = simple("equipment_witherium_nugget");
    public static final Item EQUIPMENT_WITHERIUM_PLATE = simple("equipment_witherium_plate");
    public static final Item ESSENCE_OF_WARPED_RUIN = simple("essence_of_warped_ruin");
    public static final Item ESSENCEOFDARKREALM = simple("essenceofdarkrealm");
    public static final Item EVERITE_DUST = simple("everite_dust");
    public static final Item EVERITE_GEAR = simple("everite_gear");
    public static final Item EVERITE_INGOT = simple("everite_ingot");
    public static final Item EVERITE_NUGGET = simple("everite_nugget");
    public static final Item EVERITE_PLATE = simple("everite_plate");
    public static final Item EYE_OF_ABYSS = new InfoItem("eye_of_abyss", 64, 0, "当你在凝视深渊的时候，深渊也在凝视着你。", false);
    public static final Item FALLEN_CORE = simple("fallen_core");
    public static final Item FALLEN_METAL_DUST = simple("fallen_metal_dust");
    public static final Item FALLEN_METAL_GEAR = simple("fallen_metal_gear");
    public static final Item FALLEN_METAL_INGOT = simple("fallen_metal_ingot");
    public static final Item FALLEN_METAL_NUGGET = simple("fallen_metal_nugget");
    public static final Item FALLEN_METAL_PLATE = simple("fallen_metal_plate");
    public static final Item FINALLIUM_INGOT = new InfoItem("finallium_ingot", 64, 0, "终末的开始……", false);
    public static final Item FIRE_ALLOY_DUST = simple("fire_alloy_dust");
    public static final Item FIRE_ALLOY_GEAR = simple("fire_alloy_gear");
    public static final Item FIRE_ALLOY_INGOT = simple("fire_alloy_ingot");
    public static final Item FIRE_ALLOY_NUGGET = simple("fire_alloy_nugget");
    public static final Item FIRE_ALLOY_PLATE = simple("fire_alloy_plate");
    public static final Item FREEZITE_NUGGET = simple("freezite_nugget");
    public static final Item GAIA_HEART = new InfoItem("gaia_heart", 64, 0, "§b在2000难度以上击杀盖亚守护者III掉落", true);
    public static final Item GENITE_DUST = simple("genite_dust");
    public static final Item GENITE_GEAR = simple("genite_gear");
    public static final Item GENITE_INGOT = simple("genite_ingot");
    public static final Item GENITE_NUGGET = simple("genite_nugget");
    public static final Item GENITE_PLATE = simple("genite_plate");
    public static final Item GREED_INGOT = simple("greed_ingot");
    public static final Item GUANINITE_NUGGET = simple("guaninite_nugget");
    public static final Item HERMAPHRODITIC_ARTIFACT = simple("hermaphroditic_artifact");
    public static final Item ICE_ALLOY_DUST = simple("ice_alloy_dust");
    public static final Item ICE_ALLOY_GEAR = simple("ice_alloy_gear");
    public static final Item ICE_ALLOY_INGOT = simple("ice_alloy_ingot");
    public static final Item ICE_ALLOY_NUGGET = simple("ice_alloy_nugget");
    public static final Item ICE_ALLOY_PLATE = simple("ice_alloy_plate");
    public static final Item KABALAH_RING_AIN = simple("kabalah_ring_ain");
    public static final Item KABALAH_RING_AUR = simple("kabalah_ring_aur");
    public static final Item KABALAH_RING_SOPH = simple("kabalah_ring_soph");
    public static final Item LAVARITE_NUGGET = simple("lavarite_nugget");
    public static final Item LUMIXEIUM_DUST = simple("lumixeium_dust");
    public static final Item MANASTEEL_FUSIONPLATE = simple("manasteel_fusionplate");
    public static final Item MISTIUM_NUGGET = simple("mistium_nugget");
    public static final Item MYOSOTISIUM_INGOT = simple("myosotisium_ingot");
    public static final Item NATURAEUM_DUST = simple("naturaeum_dust");
    public static final Item NATURALLINE = simple("naturalline");
    public static final Item NOXEXEUM_DUST = simple("noxexeum_dust");
    public static final Item NYARLATHOTEPIUM_INGOT = simple("nyarlathotepium_ingot");
    public static final Item OCEANIUM_NUGGET = simple("oceanium_nugget");
    public static final Item ORDERED_METAL_DUST = simple("ordered_metal_dust");
    public static final Item ORDERED_METAL_GEAR = simple("ordered_metal_gear");
    public static final Item ORDERED_METAL_INGOT = simple("ordered_metal_ingot");
    public static final Item ORDERED_METAL_NUGGET = simple("ordered_metal_nugget");
    public static final Item ORDERED_METAL_PLATE = simple("ordered_metal_plate");
    public static final Item ORICHALCOS_FUSIONPLATE = simple("orichalcos_fusionplate");
    public static final Item PHOTOVOLTAIC_CELL_IX = simple("photovoltaic_cell_ix");
    public static final Item PHOTOVOLTAIC_CELL_VII = simple("photovoltaic_cell_vii");
    public static final Item PHOTOVOLTAIC_CELL_VIII = simple("photovoltaic_cell_viii");
    public static final Item PHOTOVOLTAIC_CELL_X = simple("photovoltaic_cell_x");
    public static final Item PHOTOVOLTAIC_CELL_XI = simple("photovoltaic_cell_xi");
    public static final Item PHOTOVOLTAIC_CELL_XII = simple("photovoltaic_cell_xii");
    public static final Item PLASMARITE_NUGGET = simple("plasmarite_nugget");
    public static final Item REDITRITE_DUST = simple("reditrite_dust");
    public static final Item REDITRITE_GEAR = simple("reditrite_gear");
    public static final Item REDITRITE_INGOT = simple("reditrite_ingot");
    public static final Item REDITRITE_NUGGET = simple("reditrite_nugget");
    public static final Item REDITRITE_PLATE = simple("reditrite_plate");
    public static final Item RELIFED_CORE = simple("relifed_core");
    public static final Item RELIFED_METAL_DUST = simple("relifed_metal_dust");
    public static final Item RELIFED_METAL_GEAR = simple("relifed_metal_gear");
    public static final Item RELIFED_METAL_INGOT = simple("relifed_metal_ingot");
    public static final Item RELIFED_METAL_NUGGET = simple("relifed_metal_nugget");
    public static final Item RELIFED_METAL_PLATE = simple("relifed_metal_plate");
    public static final Item RELIFED_WITHERIUM_DUST = simple("relifed_witherium_dust");
    public static final Item RELIFED_WITHERIUM_GEAR = simple("relifed_witherium_gear");
    public static final Item RELIFED_WITHERIUM_INGOT = simple("relifed_witherium_ingot");
    public static final Item RELIFED_WITHERIUM_NUGGET = simple("relifed_witherium_nugget");
    public static final Item RELIFED_WITHERIUM_PLATE = simple("relifed_witherium_plate");
    public static final Item ROSIUM_INGOT = simple("rosium_ingot");
    public static final Item RULED_DRACONIUM_DUST = simple("ruled_draconium_dust");
    public static final Item RULED_DRACONIUM_GEAR = simple("ruled_draconium_gear");
    public static final Item RULED_DRACONIUM_INGOT = simple("ruled_draconium_ingot");
    public static final Item RULED_DRACONIUM_NUGGET = simple("ruled_draconium_nugget");
    public static final Item RULED_DRACONIUM_PLATE = simple("ruled_draconium_plate");
    public static final Item RUNE_ACTIVE_1 = simple("rune_active_1");
    public static final Item RUNE_ACTIVE_10 = simple("rune_active_10");
    public static final Item RUNE_ACTIVE_2 = simple("rune_active_2");
    public static final Item RUNE_ACTIVE_3 = simple("rune_active_3");
    public static final Item RUNE_ACTIVE_4 = simple("rune_active_4");
    public static final Item RUNE_ACTIVE_5 = simple("rune_active_5");
    public static final Item RUNE_ACTIVE_6 = simple("rune_active_6");
    public static final Item RUNE_ACTIVE_7 = simple("rune_active_7");
    public static final Item RUNE_ACTIVE_8 = simple("rune_active_8");
    public static final Item RUNE_ACTIVE_9 = simple("rune_active_9");
    public static final Item SANITE_INGOT = simple("sanite_ingot");
    public static final Item SHOGGOTH_COMPLEX_CRYSTAL = simple("shoggoth_complex_crystal");
    public static final Item SHOGGOTH_SLIMEBALL = new InfoItem("shoggoth_slimeball", 64, 0, "§f哕，真恶心。", false);
    public static final Item SHOGGY_SLIME = simple("shoggy_slime");
    public static final Item SHOGGY_SLIME_PURIFIED = simple("shoggy_slime_purified");
    public static final Item SHUBNIGGURATHIUM_INGOT = simple("shubniggurathium_ingot");
    public static final Item SKY_ALLOY_DUST = simple("sky_alloy_dust");
    public static final Item SKY_ALLOY_GEAR = simple("sky_alloy_gear");
    public static final Item SKY_ALLOY_INGOT = simple("sky_alloy_ingot");
    public static final Item SKY_ALLOY_NUGGET = simple("sky_alloy_nugget");
    public static final Item SKY_ALLOY_PLATE = simple("sky_alloy_plate");
    public static final Item SNOWINGIUM_NUGGET = simple("snowingium_nugget");
    public static final Item STORMY_CORE = new InfoItem("stormy_core", 64, 0, (String) null, true);
    public static final Item STORMY_FRAGMENT_LARGE = new InfoItem("stormy_fragment_large", 64, 0, (String) null, true);
    public static final Item STORMY_FRAGMENT_SMALL = new InfoItem("stormy_fragment_small", 64, 0, (String) null, true);
    public static final Item STORMY_FRAGMENT_TINY = new InfoItem("stormy_fragment_tiny", 64, 0, (String) null, true);
    public static final Item STORMY_METAL_DUST = simple("stormy_metal_dust");
    public static final Item STORMY_METAL_GEAR = simple("stormy_metal_gear");
    public static final Item STORMY_METAL_INGOT = simple("stormy_metal_ingot");
    public static final Item STORMY_METAL_NUGGET = simple("stormy_metal_nugget");
    public static final Item STORMY_METAL_PLATE = simple("stormy_metal_plate");
    public static final Item STORMY_SHARD = new InfoItem("stormy_shard", 64, 0, (String) null, true);
    public static final Item STORMY_WITHERIUM_DUST = simple("stormy_witherium_dust");
    public static final Item STORMY_WITHERIUM_GEAR = simple("stormy_witherium_gear");
    public static final Item STORMY_WITHERIUM_INGOT = simple("stormy_witherium_ingot");
    public static final Item STORMY_WITHERIUM_NUGGET = simple("stormy_witherium_nugget");
    public static final Item STORMY_WITHERIUM_PLATE = simple("stormy_witherium_plate");
    public static final Item THYMINITE_NUGGET = simple("thyminite_nugget");
    public static final Item TONITRUIUM_DUST = simple("tonitruium_dust");
    public static final Item WAVITE_INGOT = simple("wavite_ingot");
    public static final Item WITHERIC_CORE = simple("witheric_core");
    public static final Item YOGSOTHOTHIUM_INGOT = simple("yogsothothium_ingot");

    public static final Item[] ALL_ITEMS = {
            ABYSS_WAND,
            ADENINITE_NUGGET,
            AETHERIUM_NUGGET,
            APOCALYPSIUM_DUST,
            APOCALYPSIUM_GEAR,
            APOCALYPSIUM_INGOT,
            APOCALYPSIUM_NUGGET,
            APOCALYPSIUM_PLATE,
            AWAKENED_DRACONIUM_DUST,
            AZATHOTHIUM_INGOT,
            BALANCED_MATRIX_INGOT,
            BEGONIUM_INGOT,
            BLUE_PRINT_EMPTY,
            BLUE_PRINT_FORGE,
            BNIGHTIUM_NUGGET,
            BOTANICAL_INGOT,
            BOTANICAL_INGOT_AWAKENED,
            BOTANICAL_SOUL,
            CANOPIUM_NUGGET,
            CARNATIONIUM_INGOT,
            CHAOTIC_DRACONIUM_DUST,
            CHAOTIC_DRACONIUM_GEAR,
            CHAOTIC_DRACONIUM_INGOT,
            CHAOTIC_DRACONIUM_NUGGET,
            CHAOTIC_DRACONIUM_PLATE,
            CHRYSANTHEMIUM_INGOT,
            COMMAND_CORE,
            COSMILITE_NUGGET,
            CTHULHURITE_INGOT,
            DANDELIONIUM_INGOT,
            DENSITE_DUST,
            DENSITE_GEAR,
            DENSITE_INGOT,
            DENSITE_NUGGET,
            DENSITE_PLATE,
            ELEMENTINE_INGOT,
            ELEMENTIUM_FUSIONPLATE,
            EQUIPMENT_WITHERIUM_DUST,
            EQUIPMENT_WITHERIUM_GEAR,
            EQUIPMENT_WITHERIUM_INGOT,
            EQUIPMENT_WITHERIUM_NUGGET,
            EQUIPMENT_WITHERIUM_PLATE,
            ESSENCE_OF_WARPED_RUIN,
            ESSENCEOFDARKREALM,
            EVERITE_DUST,
            EVERITE_GEAR,
            EVERITE_INGOT,
            EVERITE_NUGGET,
            EVERITE_PLATE,
            EYE_OF_ABYSS,
            FALLEN_CORE,
            FALLEN_METAL_DUST,
            FALLEN_METAL_GEAR,
            FALLEN_METAL_INGOT,
            FALLEN_METAL_NUGGET,
            FALLEN_METAL_PLATE,
            FINALLIUM_INGOT,
            FIRE_ALLOY_DUST,
            FIRE_ALLOY_GEAR,
            FIRE_ALLOY_INGOT,
            FIRE_ALLOY_NUGGET,
            FIRE_ALLOY_PLATE,
            FREEZITE_NUGGET,
            GAIA_HEART,
            GENITE_DUST,
            GENITE_GEAR,
            GENITE_INGOT,
            GENITE_NUGGET,
            GENITE_PLATE,
            GREED_INGOT,
            GUANINITE_NUGGET,
            HERMAPHRODITIC_ARTIFACT,
            ICE_ALLOY_DUST,
            ICE_ALLOY_GEAR,
            ICE_ALLOY_INGOT,
            ICE_ALLOY_NUGGET,
            ICE_ALLOY_PLATE,
            KABALAH_RING_AIN,
            KABALAH_RING_AUR,
            KABALAH_RING_SOPH,
            LAVARITE_NUGGET,
            LUMIXEIUM_DUST,
            MANASTEEL_FUSIONPLATE,
            MISTIUM_NUGGET,
            MYOSOTISIUM_INGOT,
            NATURAEUM_DUST,
            NATURALLINE,
            NOXEXEUM_DUST,
            NYARLATHOTEPIUM_INGOT,
            OCEANIUM_NUGGET,
            ORDERED_METAL_DUST,
            ORDERED_METAL_GEAR,
            ORDERED_METAL_INGOT,
            ORDERED_METAL_NUGGET,
            ORDERED_METAL_PLATE,
            ORICHALCOS_FUSIONPLATE,
            PHOTOVOLTAIC_CELL_IX,
            PHOTOVOLTAIC_CELL_VII,
            PHOTOVOLTAIC_CELL_VIII,
            PHOTOVOLTAIC_CELL_X,
            PHOTOVOLTAIC_CELL_XI,
            PHOTOVOLTAIC_CELL_XII,
            PLASMARITE_NUGGET,
            REDITRITE_DUST,
            REDITRITE_GEAR,
            REDITRITE_INGOT,
            REDITRITE_NUGGET,
            REDITRITE_PLATE,
            RELIFED_CORE,
            RELIFED_METAL_DUST,
            RELIFED_METAL_GEAR,
            RELIFED_METAL_INGOT,
            RELIFED_METAL_NUGGET,
            RELIFED_METAL_PLATE,
            RELIFED_WITHERIUM_DUST,
            RELIFED_WITHERIUM_GEAR,
            RELIFED_WITHERIUM_INGOT,
            RELIFED_WITHERIUM_NUGGET,
            RELIFED_WITHERIUM_PLATE,
            ROSIUM_INGOT,
            RULED_DRACONIUM_DUST,
            RULED_DRACONIUM_GEAR,
            RULED_DRACONIUM_INGOT,
            RULED_DRACONIUM_NUGGET,
            RULED_DRACONIUM_PLATE,
            RUNE_ACTIVE_1,
            RUNE_ACTIVE_10,
            RUNE_ACTIVE_2,
            RUNE_ACTIVE_3,
            RUNE_ACTIVE_4,
            RUNE_ACTIVE_5,
            RUNE_ACTIVE_6,
            RUNE_ACTIVE_7,
            RUNE_ACTIVE_8,
            RUNE_ACTIVE_9,
            SANITE_INGOT,
            SHOGGOTH_COMPLEX_CRYSTAL,
            SHOGGOTH_SLIMEBALL,
            SHOGGY_SLIME,
            SHOGGY_SLIME_PURIFIED,
            SHUBNIGGURATHIUM_INGOT,
            SKY_ALLOY_DUST,
            SKY_ALLOY_GEAR,
            SKY_ALLOY_INGOT,
            SKY_ALLOY_NUGGET,
            SKY_ALLOY_PLATE,
            SNOWINGIUM_NUGGET,
            STORMY_CORE,
            STORMY_FRAGMENT_LARGE,
            STORMY_FRAGMENT_SMALL,
            STORMY_FRAGMENT_TINY,
            STORMY_METAL_DUST,
            STORMY_METAL_GEAR,
            STORMY_METAL_INGOT,
            STORMY_METAL_NUGGET,
            STORMY_METAL_PLATE,
            STORMY_SHARD,
            STORMY_WITHERIUM_DUST,
            STORMY_WITHERIUM_GEAR,
            STORMY_WITHERIUM_INGOT,
            STORMY_WITHERIUM_NUGGET,
            STORMY_WITHERIUM_PLATE,
            THYMINITE_NUGGET,
            TONITRUIUM_DUST,
            WAVITE_INGOT,
            WITHERIC_CORE,
            YOGSOTHOTHIUM_INGOT
    };

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ALL_ITEMS);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        for (Item item : ALL_ITEMS) {
            GctAdditionsModels.item(item, item.getRegistryName().getPath());
        }
    }

    private static Item simple(String name) {
        Item item = new Item();
        item.setMaxDamage(0);
        item.setMaxStackSize(64);
        item.setTranslationKey(name);
        item.setRegistryName(name);
        item.setCreativeTab(GctAdditionsCreativeTab.TAB);
        return item;
    }
}
