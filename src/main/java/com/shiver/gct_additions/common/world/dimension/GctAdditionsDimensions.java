package com.shiver.gct_additions.common.world.dimension;

import com.shiver.gct_additions.client.GctAdditionsModels;
import com.shiver.gct_additions.common.blocks.BlockAstralPortalCore;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal1;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal2;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal3;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import com.shiver.gct_additions.common.items.PortalActivatorItem;
import com.shiver.gct_additions.common.world.structure.GctAdditionsStructureTemplates;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class GctAdditionsDimensions {
    private static final Block[] PORTALS = {
            WorldDarkerRealm.portal,
            WorldWarpedRuin.portal,
            WorldEverheaven.portal,
            WorldAlfheim.portal,
            WorldAtlantis.portal,
            WorldTheVoid.portal,
            WorldTheNowhere.portal,
            WorldOrderland.portal
    };

    public static final Item DIM_DARKER_REALM = new PortalActivatorItem("dimdarkerrealm", GctAdditionsCreativeTab.TAB,
            WorldDarkerRealm.portal, () -> WorldDarkerRealm.DIMID,
            GctAdditionsStructureTemplates.DIM_54_PORTAL_1, GctAdditionsStructureTemplates.DIM_54_PORTAL_2);
    public static final Item WARPED_RUIN = new PortalActivatorItem("warped_ruin", GctAdditionsCreativeTab.TAB,
            WorldWarpedRuin.portal, () -> WorldWarpedRuin.DIMID,
            GctAdditionsStructureTemplates.DIM_55_PORTAL_1, GctAdditionsStructureTemplates.DIM_55_PORTAL_2);
    public static final Item BESIDE_VOID = new PortalActivatorItem("beside_void", GctAdditionsCreativeTab.TAB,
            BlockBesideVoidPortal2.block, () -> WorldBesideVoid.DIMID, 3, (world, origin, widthDir) -> {
                world.setBlockState(origin, BlockBesideVoidPortal3.block.getDefaultState(), 3);
                world.setBlockState(origin.up(), BlockBesideVoidPortal2.block.getDefaultState(), 3);
                world.setBlockState(origin.up(2), BlockBesideVoidPortal1.block.getDefaultState(), 3);
            });
    public static final Item EVERHEAVEN = new PortalActivatorItem("everheaven", GctAdditionsCreativeTab.TAB,
            WorldEverheaven.portal, () -> WorldEverheaven.DIMID,
            GctAdditionsStructureTemplates.HEAVEN_PORTAL, GctAdditionsStructureTemplates.HEAVEN_PORTAL);
    public static final Item ALFHEIM = new PortalActivatorItem("alfheim", GctAdditionsCreativeTab.TAB,
            WorldAlfheim.portal, () -> WorldAlfheim.DIMID);
    public static final Item ATLANTIS = new PortalActivatorItem("atlantis", GctAdditionsCreativeTab.TAB,
            WorldAtlantis.portal, () -> WorldAtlantis.DIMID);
    public static final Item STARLAND = new PortalActivatorItem("starland", GctAdditionsCreativeTab.TAB,
            BlockAstralPortalCore.block, () -> WorldStarland.DIMID, 1,
            (world, origin, widthDir) -> world.setBlockState(origin, BlockAstralPortalCore.block.getDefaultState(), 3));
    public static final Item THE_VOID = new PortalActivatorItem("the_void", GctAdditionsCreativeTab.TAB,
            WorldTheVoid.portal, () -> WorldTheVoid.DIMID);
    public static final Item THE_NOWHERE = new PortalActivatorItem("the_nowhere", GctAdditionsCreativeTab.TAB,
            WorldTheNowhere.portal, () -> WorldTheNowhere.DIMID);
    public static final Item ORDERLAND = new PortalActivatorItem("orderland", GctAdditionsCreativeTab.TAB,
            WorldOrderland.portal, () -> WorldOrderland.DIMID,
            GctAdditionsStructureTemplates.ORDER_PORTAL, GctAdditionsStructureTemplates.ORDER_PORTAL_2);

    private GctAdditionsDimensions() {
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(PORTALS);
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block portal : PORTALS) {
            event.getRegistry().register(new ItemBlock(portal).setRegistryName(portal.getRegistryName()));
        }

        event.getRegistry().registerAll(
                DIM_DARKER_REALM,
                WARPED_RUIN,
                BESIDE_VOID,
                EVERHEAVEN,
                ALFHEIM,
                ATLANTIS,
                STARLAND,
                THE_VOID,
                THE_NOWHERE,
                ORDERLAND
        );
    }

    public static void registerDimensions() {
        WorldDarkerRealm.registerDimension();
        WorldWarpedRuin.registerDimension();
        WorldBesideVoid.registerDimension();
        WorldEverheaven.registerDimension();
        WorldAlfheim.registerDimension();
        WorldAtlantis.registerDimension();
        WorldStarland.registerDimension();
        WorldTheVoid.registerDimension();
        WorldTheNowhere.registerDimension();
        WorldOrderland.registerDimension();
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        for (Block portal : PORTALS) {
            GctAdditionsModels.block(portal);
        }

        GctAdditionsModels.item(DIM_DARKER_REALM, "dimdarkerrealm");
        GctAdditionsModels.item(WARPED_RUIN, "warped_ruin");
        GctAdditionsModels.item(BESIDE_VOID, "beside_void");
        GctAdditionsModels.item(EVERHEAVEN, "everheaven");
        GctAdditionsModels.item(ALFHEIM, "alfheim");
        GctAdditionsModels.item(ATLANTIS, "atlantis");
        GctAdditionsModels.item(STARLAND, "starland");
        GctAdditionsModels.item(THE_VOID, "the_void");
        GctAdditionsModels.item(THE_NOWHERE, "the_nowhere");
        GctAdditionsModels.item(ORDERLAND, "orderland");
    }
}
