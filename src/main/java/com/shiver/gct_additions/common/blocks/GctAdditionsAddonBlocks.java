package com.shiver.gct_additions.common.blocks;

import com.shiver.gct_additions.client.GctAdditionsModels;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAdditionsAddonBlocks {
    private GctAdditionsAddonBlocks() {
    }

    public static final Block APOCALYPSIUM_BLOCK = new GctAdditionsSimpleBlock("apocalypsium_block", Material.IRON, SoundType.METAL, 20.0F, 2000.0F, "pickaxe", 5, 0.0F, 255, false, false, null);
    public static final Block AZATHOTHIUM_BLOCK = new GctAdditionsSimpleBlock("azathothium_block", Material.IRON, SoundType.METAL, 15.0F, 2000.0F, "pickaxe", 11, 0.0F, 255, false, false, null);
    public static final Block BALANCED_MATRIX_BLOCK = new GctAdditionsSimpleBlock("balanced_matrix_block", Material.IRON, SoundType.METAL, 30.0F, 4000.0F, "pickaxe", 12, 1.0F, 255, false, false, null);
    public static final Block CHAOS_SHARD_BLOCK = new GctAdditionsSimpleBlock("chaos_shard_block", Material.ROCK, SoundType.GLASS, 10.0F, 4000.0F, "pickaxe", 10, 0.0F, 255, false, false, null);
    public static final Block CHAOTIC_DRACONIUM_BLOCK = new GctAdditionsSimpleBlock("chaotic_draconium_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block CTHULHURITE_BLOCK = new GctAdditionsSimpleBlock("cthulhurite_block", Material.IRON, SoundType.METAL, 4.0F, 30.0F, "pickaxe", 8, 0.0F, 255, false, false, null);
    public static final Block DENSITE_BLOCK = new GctAdditionsSimpleBlock("densite_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block ELEMETIUMSTEEL_MACHINE_FRAME = new GctAdditionsSimpleBlock("elemetiumsteel_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block END_CHROMIUM_ORE = new GctAdditionsSimpleBlock("end_chromium_ore", Material.ROCK, SoundType.STONE, 3.5F, 15.0F, "pickaxe", 3, 0.0F, 255, false, false, null);
    public static final Block END_MANGANESE_ORE = new GctAdditionsSimpleBlock("end_manganese_ore", Material.ROCK, SoundType.STONE, 4.5F, 200.0F, "pickaxe", 3, 0.0F, 255, false, false, null);
    public static final Block EQUIPMENT_WITHERIUM_BLOCK = new GctAdditionsSimpleBlock("equipment_witherium_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block EVERITE_BLOCK = new GctAdditionsSimpleBlock("everite_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block EVERITE_MACHINE_FRAME = new GctAdditionsSimpleBlock("everite_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block FALLEN_METAL_BLOCK = new GctAdditionsSimpleBlock("fallen_metal_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block FIRE_ALLOY_BLOCK = new GctAdditionsSimpleBlock("fire_alloy_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block GAIA_SPIRIT_MACHINE_FRAME = new GctAdditionsSimpleBlock("gaia_spirit_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block GAIA_STEEL_MACHINE_FRAME = new GctAdditionsSimpleBlock("gaia_steel_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block GENITE_BLOCK = new GctAdditionsSimpleBlock("genite_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block GENITE_MACHINE_FRAME = new GctAdditionsSimpleBlock("genite_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block HALF_LAVA_GLASS = new GctAdditionsSimpleBlock("half_lava_glass", Material.GLASS, SoundType.GLASS, 1.0F, 10.0F, null, 0, 1.0F, 0, true, true, null);
    public static final Block ICE_ALLOY_BLOCK = new GctAdditionsSimpleBlock("ice_alloy_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block MANA_BLOCK = new GctAdditionsSimpleBlock("mana_block", Material.ROCK, SoundType.STONE, 1.0F, 10.0F, null, 0, 0.33333334F, 255, false, false, null);
    public static final Block MANASTEEL_MACHINE_FRAME = new GctAdditionsSimpleBlock("manasteel_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block NETHER_CHROMIUM_ORE = new GctAdditionsSimpleBlock("nether_chromium_ore", Material.ROCK, SoundType.STONE, 3.5F, 15.0F, "pickaxe", 3, 0.0F, 255, false, false, null);
    public static final Block NETHER_MANGANESE_ORE = new GctAdditionsSimpleBlock("nether_manganese_ore", Material.ROCK, SoundType.STONE, 4.5F, 200.0F, "pickaxe", 3, 0.0F, 255, false, false, null);
    public static final Block NYARLATHOTEPIUM_BLOCK = new GctAdditionsSimpleBlock("nyarlathotepium_block", Material.IRON, SoundType.METAL, 15.0F, 2000.0F, "pickaxe", 11, 0.0F, 255, false, false, null);
    public static final Block ORDERED_FUSION_CORE = new GctAdditionsSimpleBlock("ordered_fusion_core", Material.ROCK, SoundType.STONE, 50.0F, 200000.0F, "pickaxe", 13, 1.0F, 0, true, false, "用它来聚合秩序之物！");
    public static final Block ORDERED_METAL_BLOCK = new GctAdditionsSimpleBlock("ordered_metal_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block ORICHALCOS_MACHINE_FRAME = new GctAdditionsSimpleBlock("orichalcos_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block REDITRITE_BLOCK = new GctAdditionsSimpleBlock("reditrite_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block RELIFED_METAL_BLOCK = new GctAdditionsSimpleBlock("relifed_metal_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block RELIFED_WITHERIUM_BLOCK = new GctAdditionsSimpleBlock("relifed_witherium_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block RULED_DRACONIUM_BLOCK = new GctAdditionsSimpleBlock("ruled_draconium_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block SANITE_BLOCK = new GctAdditionsSimpleBlock("sanite_block", Material.IRON, SoundType.METAL, 5.0F, 30.0F, "pickaxe", 8, 0.0F, 255, false, false, null);
    public static final Block SHUBNIGGURATHIUM_BLOCK = new GctAdditionsSimpleBlock("shubniggurathium_block", Material.IRON, SoundType.METAL, 15.0F, 2000.0F, "pickaxe", 11, 0.0F, 255, false, false, null);
    public static final Block SKY_ALLOY_BLOCK = new GctAdditionsSimpleBlock("sky_alloy_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block STORMY_METAL_BLOCK = new GctAdditionsSimpleBlock("stormy_metal_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block STORMY_SHARD_BLOCK = new GctAdditionsSimpleBlock("stormy_shard_block", Material.ROCK, SoundType.GLASS, 10.0F, 4000.0F, "pickaxe", 10, 0.0F, 255, false, false, null);
    public static final Block STORMY_WITHERIUM_BLOCK = new GctAdditionsSimpleBlock("stormy_witherium_block", Material.IRON, SoundType.METAL, 15.0F, 10.0F, "pickaxe", 4, 0.0F, 255, false, false, null);
    public static final Block TERRASTEEL_MACHINE_FRAME = new GctAdditionsSimpleBlock("terrasteel_machine_frame", Material.IRON, SoundType.METAL, 1.5F, 20.0F, "pickaxe", 2, 0.0F, 0, true, false, null);
    public static final Block YOGSOTHOTHIUM_BLOCK = new GctAdditionsSimpleBlock("yogsothothium_block", Material.IRON, SoundType.METAL, 15.0F, 2000.0F, "pickaxe", 11, 0.0F, 255, false, false, null);

    public static final Block[] ALL_BLOCKS = {
            APOCALYPSIUM_BLOCK,
            AZATHOTHIUM_BLOCK,
            BALANCED_MATRIX_BLOCK,
            CHAOS_SHARD_BLOCK,
            CHAOTIC_DRACONIUM_BLOCK,
            CTHULHURITE_BLOCK,
            DENSITE_BLOCK,
            ELEMETIUMSTEEL_MACHINE_FRAME,
            END_CHROMIUM_ORE,
            END_MANGANESE_ORE,
            EQUIPMENT_WITHERIUM_BLOCK,
            EVERITE_BLOCK,
            EVERITE_MACHINE_FRAME,
            FALLEN_METAL_BLOCK,
            FIRE_ALLOY_BLOCK,
            GAIA_SPIRIT_MACHINE_FRAME,
            GAIA_STEEL_MACHINE_FRAME,
            GENITE_BLOCK,
            GENITE_MACHINE_FRAME,
            HALF_LAVA_GLASS,
            ICE_ALLOY_BLOCK,
            MANA_BLOCK,
            MANASTEEL_MACHINE_FRAME,
            NETHER_CHROMIUM_ORE,
            NETHER_MANGANESE_ORE,
            NYARLATHOTEPIUM_BLOCK,
            ORDERED_FUSION_CORE,
            ORDERED_METAL_BLOCK,
            ORICHALCOS_MACHINE_FRAME,
            REDITRITE_BLOCK,
            RELIFED_METAL_BLOCK,
            RELIFED_WITHERIUM_BLOCK,
            RULED_DRACONIUM_BLOCK,
            SANITE_BLOCK,
            SHUBNIGGURATHIUM_BLOCK,
            SKY_ALLOY_BLOCK,
            STORMY_METAL_BLOCK,
            STORMY_SHARD_BLOCK,
            STORMY_WITHERIUM_BLOCK,
            TERRASTEEL_MACHINE_FRAME,
            YOGSOTHOTHIUM_BLOCK
    };

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ALL_BLOCKS);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block block : ALL_BLOCKS) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        for (Block block : ALL_BLOCKS) {
            GctAdditionsModels.block(block);
        }
    }
}
