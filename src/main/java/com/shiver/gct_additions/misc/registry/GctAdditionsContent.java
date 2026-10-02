package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.common.blocks.GctAdditionsAddonBlocks;
import com.shiver.gct_additions.common.blocks.GctAdditionsBlocks;
import com.shiver.gct_additions.common.blocks.MachineBlock;
import com.shiver.gct_additions.client.GctAdditionsModels;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import com.shiver.gct_additions.common.world.dimension.GctAdditionsDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAdditionsContent {
    private static final Block ATOMIC_VIBRATOR = machine("model_atomic_viberator",
            "§7将中子注入矿物。");
    private static final Block ATOMIC_DECAYER = machine("model_atomic_decayer",
            "§7加速放射物的衰变。");
    private static final Block ATOMIC_ACIDOR = machine("model_atomic_acidor",
            "§7使用氟王水溶解金属。");
    private static final Block ENDER_FORGE = new MachineBlock("model_ender_forge", SoundType.GROUND, 1.0F, 10.0F,
            GctAdditionsCreativeTab.TAB, null);

    private GctAdditionsContent() {
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GctAdditionsBlocks.preInit(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GctAdditionsBlocks.registerBlocks(event);
        GctAdditionsAddonBlocks.registerBlocks(event);
        GctAdditionsDimensions.registerBlocks(event);
        event.getRegistry().registerAll(
                ATOMIC_VIBRATOR,
                ATOMIC_DECAYER,
                ATOMIC_ACIDOR,
                ENDER_FORGE);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        GctAdditionsBlocks.registerItems(event);
        GctAdditionsAddonBlocks.registerItems(event);
        GctAdditionsItems.registerItems(event);
        GctAdditionsAddonItems.registerItems(event);
        GctAdditionsDimensions.registerItems(event);
        event.getRegistry().registerAll(
                itemBlock(ATOMIC_VIBRATOR),
                itemBlock(ATOMIC_DECAYER),
                itemBlock(ATOMIC_ACIDOR),
                itemBlock(ENDER_FORGE));
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAdditionsBlocks.registerModels(event);
        GctAdditionsAddonBlocks.registerModels(event);
        GctAdditionsItems.registerModels();
        GctAdditionsAddonItems.registerModels();
        GctAdditionsDimensions.registerModels(event);

        GctAdditionsModels.block(ATOMIC_VIBRATOR);
        GctAdditionsModels.block(ATOMIC_DECAYER);
        GctAdditionsModels.block(ATOMIC_ACIDOR);
        GctAdditionsModels.block(ENDER_FORGE);
    }

    private static ItemBlock itemBlock(Block block) {
        return (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
    }

    private static Block machine(String name, String tooltip) {
        Block block = new MachineBlock(name, SoundType.STONE, 5.0F, 10.0F, GctAdditionsCreativeTab.TAB, tooltip);
        block.setHarvestLevel("pickaxe", 1);
        return block;
    }
}
