package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.client.GctAdditionsModels;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import com.shiver.gct_additions.common.items.InfoItem;
import com.shiver.gct_additions.common.items.ItemCommandDismantler;
import com.shiver.gct_additions.common.items.ItemCreepyWitherDoll;
import com.shiver.gct_additions.common.items.ItemCreepyWitherstormDoll;
import com.shiver.gct_additions.common.items.ItemDoorKeyOfOrderland;
import com.shiver.gct_additions.common.items.ItemEarthOrb;
import com.shiver.gct_additions.common.items.ItemFruitOfMind;
import com.shiver.gct_additions.common.items.ItemFruitOfMindEnchanted;
import com.shiver.gct_additions.common.items.ItemGreedycraftModChanger;
import com.shiver.gct_additions.common.items.ItemKeyOfDark;
import com.shiver.gct_additions.common.items.ItemKeyOfWarpedActive;
import com.shiver.gct_additions.common.items.ItemMuddyFlesh;
import com.shiver.gct_additions.common.items.ItemRNGRelinquisher;
import com.shiver.gct_additions.common.items.ItemRemnantCookie;
import com.shiver.gct_additions.common.items.ItemSenterianWrench;
import com.shiver.gct_additions.common.items.ItemShoggothTancale;
import com.shiver.gct_additions.common.items.ItemShoggothTancaleSoup;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAdditionsItems {
    private GctAdditionsItems() {
    }

    public static final Item ESSENCE_OF_DARKERREALM = simple("essenceofdarkerrealm");
    public static final Item SHOGGOTH_TOOTH = simple("shoggothtooth");

    public static final Item APOCALYPSIUM_SCRAP = simple("apocalypsium_scrap");
    public static final Item GRAVITY_SCRAP = simple("gravity_scrap");
    public static final Item RESONATED_SCRAP = simple("resonated_scrap");

    public static final Item EARTH_INGOT = simple("earth_ingot");
    public static final Item HOLYSTEEL_INGOT = simple("holysteel_ingot");

    public static final Item STORM_BLIGTZ_DUST = simple("bligtz_dust");
    public static final Item STORM_BLIGTZ_ROD = simple("bligtz_rod");
    public static final Item STORM_BNATUZ_DUST = simple("bnatuz_dust");
    public static final Item STORM_BNATUZ_ROD = simple("bnatuz_rod");
    public static final Item STORM_BNINZ_DUST = simple("bninz_dust");
    public static final Item STORM_BNINZ_ROD = simple("bninz_rod");
    public static final Item STORM_BTHDZ_DUST = simple("bthdz_dust");
    public static final Item STORM_BTHDZ_ROD = simple("bthdz_rod");

    public static final Item RAINBOQUARTZ = simple("rainboquartz");
    public static final Item SHALLOITE = simple("shalloite");
    public static final Item WITHERIUM_DUST = simple("witherium_dust");

    public static final Item WARPED_SOUL = info("warped_soul", 64, 0, "§f扭曲遗址内不屈的冤魂", false);
    public static final Item FURTHER_SOUL = info("further_soul", 64, 0, "§b来自遥远的记忆。", true);
    public static final Item SOUL_STEALER_SCROLL = info("soul_stealer_scroll", 64, 0, "§c似乎是某位神明留下的遗物？", false);
    public static final Item ANCIENT_MUD = info("ancientmud", 64, 0, "§e在灵神台座上右击以召唤远古修格斯", false);
    public static final Item ANCIENT_SHOGGOTH_MUD = info("ancient_shoggoth_mud", 64, 0,
            "§f在一只§c血红修格斯融合体§f面前击杀一只§c远古修格斯§f获得", true);
    public static final Item SHOGGOTH_CLUMP = info("shoggoth_clump", 64, 0,
            "§c命令一只修格斯融合体击杀一只远古修格斯……？", true);
    public static final Item KEY_OF_WARPED = info("key_of_warped", 1, 0, "§2似乎不能正常使用", false);

    public static final Item APOCALYPSE_RUIN = info("apocalypse_ruin", 64, 0, "§e右键天启祭坛以召唤天启骑士", true);
    public static final Item SHADOW_NUCLEAR = info("shadownuclear", 64, 0, "§4似乎是阴影怪物产生的源泉？", false);
    public static final Item NATURALLINE_SCRAP = info("naturalline_scrap", 64, 0, null, true);

    public static final Item ELF_PASSES = info("elf_passes", 64, 0, "§e右键精灵可以得到自然结晶碎片", true);

    public static final Item ORDER_CRYSTAL = info("order_crystal", 64, 0, "秩序，蕴含于这一方小小水晶中", true);
    public static final Item ORDERED_CORE = info("ordered_core", 64, 0, null, true);
    public static final Item DOOR_KEY_EMPTY = info("door_key_empty", 1, 0, "可以在深渊仪式上绑定对应门钥匙！", false);

    public static final Item SENTERIAN_KEY = info("senterian_key", 64, 0, "用于打开黑岩之锁", false);

    public static final Item SANITE_SIPHON = info("sanite_siphon", 1, 100, "§c用于采集修格斯软泥", false);
    public static final Item SANITY_OBSERVER = info("sanity_observer", 1, 0, "探测当前San值", false);

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ESSENCE_OF_DARKERREALM,
                WARPED_SOUL,
                FURTHER_SOUL,
                SOUL_STEALER_SCROLL,
                ANCIENT_MUD,
                ANCIENT_SHOGGOTH_MUD,
                ItemMuddyFlesh.block,
                SHOGGOTH_CLUMP,
                ItemShoggothTancale.block,
                ItemShoggothTancaleSoup.block,
                SHOGGOTH_TOOTH,
                ItemKeyOfDark.block,
                KEY_OF_WARPED,
                ItemKeyOfWarpedActive.block,

                APOCALYPSE_RUIN,
                APOCALYPSIUM_SCRAP,
                SHADOW_NUCLEAR,
                GRAVITY_SCRAP,
                RESONATED_SCRAP,
                NATURALLINE_SCRAP,

                EARTH_INGOT,
                ItemEarthOrb.block,
                ELF_PASSES,
                HOLYSTEEL_INGOT,

                ORDER_CRYSTAL,
                ORDERED_CORE,
                ItemCommandDismantler.block,
                DOOR_KEY_EMPTY,
                ItemDoorKeyOfOrderland.block,

                SENTERIAN_KEY,
                ItemSenterianWrench.block,

                STORM_BLIGTZ_DUST,
                STORM_BLIGTZ_ROD,
                STORM_BNATUZ_DUST,
                STORM_BNATUZ_ROD,
                STORM_BNINZ_DUST,
                STORM_BNINZ_ROD,
                STORM_BTHDZ_DUST,
                STORM_BTHDZ_ROD,

                ItemFruitOfMind.block,
                ItemFruitOfMindEnchanted.block,
                ItemRemnantCookie.block,
                SANITE_SIPHON,
                SANITY_OBSERVER,

                ItemCreepyWitherDoll.block,
                ItemCreepyWitherstormDoll.block,
                ItemGreedycraftModChanger.block,
                RAINBOQUARTZ,
                ItemRNGRelinquisher.block,
                SHALLOITE,
                WITHERIUM_DUST
        );
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        GctAdditionsModels.item(ESSENCE_OF_DARKERREALM, "essenceofdarkerrealm");
        GctAdditionsModels.item(WARPED_SOUL, "warped_soul");
        GctAdditionsModels.item(FURTHER_SOUL, "further_soul");
        GctAdditionsModels.item(SOUL_STEALER_SCROLL, "soul_stealer_scroll");
        GctAdditionsModels.item(ANCIENT_MUD, "ancientmud");
        GctAdditionsModels.item(ANCIENT_SHOGGOTH_MUD, "ancient_shoggoth_mud");
        GctAdditionsModels.item(ItemMuddyFlesh.block, "muddy_flesh");
        GctAdditionsModels.item(SHOGGOTH_CLUMP, "shoggoth_clump");
        GctAdditionsModels.item(ItemShoggothTancale.block, "shoggothtancale");
        GctAdditionsModels.item(ItemShoggothTancaleSoup.block, "shoggoth_tancale_soup");
        GctAdditionsModels.item(SHOGGOTH_TOOTH, "shoggothtooth");
        GctAdditionsModels.item(ItemKeyOfDark.block, "keyofdark");
        GctAdditionsModels.item(KEY_OF_WARPED, "key_of_warped");
        GctAdditionsModels.item(ItemKeyOfWarpedActive.block, "key_of_warped_active");

        GctAdditionsModels.item(APOCALYPSE_RUIN, "apocalypse_ruin");
        GctAdditionsModels.item(APOCALYPSIUM_SCRAP, "apocalypsium_scrap");
        GctAdditionsModels.item(SHADOW_NUCLEAR, "shadownuclear");
        GctAdditionsModels.item(GRAVITY_SCRAP, "gravity_scrap");
        GctAdditionsModels.item(RESONATED_SCRAP, "resonated_scrap");
        GctAdditionsModels.item(NATURALLINE_SCRAP, "naturalline_scrap");

        GctAdditionsModels.item(EARTH_INGOT, "earth_ingot");
        GctAdditionsModels.item(ItemEarthOrb.block, "earth_orb");
        GctAdditionsModels.item(ELF_PASSES, "elf_passes");
        GctAdditionsModels.item(HOLYSTEEL_INGOT, "holysteel_ingot");

        GctAdditionsModels.item(ORDER_CRYSTAL, "order_crystal");
        GctAdditionsModels.item(ORDERED_CORE, "ordered_core");
        GctAdditionsModels.item(ItemCommandDismantler.block, "command_dismantler");
        GctAdditionsModels.item(DOOR_KEY_EMPTY, "door_key_empty");
        GctAdditionsModels.item(ItemDoorKeyOfOrderland.block, "door_key_of_orderland");

        GctAdditionsModels.item(SENTERIAN_KEY, "senterian_key");
        GctAdditionsModels.item(ItemSenterianWrench.block, "senterian_wrench");

        GctAdditionsModels.item(STORM_BLIGTZ_DUST, "bligtz_dust");
        GctAdditionsModels.item(STORM_BLIGTZ_ROD, "bligtz_rod");
        GctAdditionsModels.item(STORM_BNATUZ_DUST, "bnatuz_dust");
        GctAdditionsModels.item(STORM_BNATUZ_ROD, "bnatuz_rod");
        GctAdditionsModels.item(STORM_BNINZ_DUST, "bninz_dust");
        GctAdditionsModels.item(STORM_BNINZ_ROD, "bninz_rod");
        GctAdditionsModels.item(STORM_BTHDZ_DUST, "bthdz_dust");
        GctAdditionsModels.item(STORM_BTHDZ_ROD, "bthdz_rod");

        GctAdditionsModels.item(ItemFruitOfMind.block, "fruit_of_mind");
        GctAdditionsModels.item(ItemFruitOfMindEnchanted.block, "fruit_of_mind_enchanted");
        GctAdditionsModels.item(ItemRemnantCookie.block, "remnant_cookie");
        GctAdditionsModels.item(SANITE_SIPHON, "sanite_siphon");
        GctAdditionsModels.item(SANITY_OBSERVER, "sanity_observer");

        GctAdditionsModels.item(ItemCreepyWitherDoll.block, "creepy_wither_doll");
        GctAdditionsModels.item(ItemCreepyWitherstormDoll.block, "creepy_witherstorm_doll");
        GctAdditionsModels.item(ItemGreedycraftModChanger.block, "greedycraft_mod_changer");
        GctAdditionsModels.item(RAINBOQUARTZ, "rainboquartz");
        GctAdditionsModels.item(ItemRNGRelinquisher.block, "rng_relinquisher");
        GctAdditionsModels.item(SHALLOITE, "shalloite");
        GctAdditionsModels.item(WITHERIUM_DUST, "witherium_dust");
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

    private static Item info(String name, int maxStackSize, int maxDamage, String tooltip, boolean glowing) {
        return new InfoItem(name, maxStackSize, maxDamage, tooltip, glowing);
    }
}
