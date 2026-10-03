package com.shiver.gct_additions.common.blocks;

import com.shiver.gct_additions.client.GctAdditionsFluidModels;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockReditrite extends BlockFluidClassic {
    private static final Fluid FLUID = registerFluid();

    public static final Block block = new BlockReditrite();
    public static final Item item = new ItemBlock(block);

    public BlockReditrite() {
        super(FLUID, Material.LAVA);
        setTranslationKey("reditrite");
    }

    public static void preInit(FMLPreInitializationEvent event) {
        FluidRegistry.addBucketForFluid(FLUID);
    }

    private static Fluid registerFluid() {
        Fluid fluid = new Fluid("reditrite",
                new ResourceLocation("gct_additions:blocks/reditrite_still"),
                new ResourceLocation("gct_additions:blocks/reditrite_flow"))
                .setLuminosity(0)
                .setDensity(1000)
                .setViscosity(4000)
                .setGaseous(false);
        return com.shiver.gct_additions.misc.registry.GctAdditionsFluidRegistry.register(fluid);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        GctAdditionsFluidModels.register(block, item, "reditrite");
    }
}
