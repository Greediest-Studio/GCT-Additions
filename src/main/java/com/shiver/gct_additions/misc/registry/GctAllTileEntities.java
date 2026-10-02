package com.shiver.gct_additions.misc.registry;

import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal1;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal2;
import com.shiver.gct_additions.common.blocks.BlockBesideVoidPortal3;
import com.shiver.gct_additions.common.blocks.BlockFinalliumContainer;
import com.shiver.gct_additions.common.blocks.BlockFinalliumContainerActive;
import com.shiver.gct_additions.common.blocks.BlockSenterianSummoner;
import com.shiver.gct_additions.common.tile.TileEntityBesideVoidPortal1;
import com.shiver.gct_additions.common.tile.TileEntityBesideVoidPortal2;
import com.shiver.gct_additions.common.tile.TileEntityBesideVoidPortal3;
import com.shiver.gct_additions.common.tile.TileEntityEarthboundAltar;
import com.shiver.gct_additions.common.tile.TileEntityEarthboundReceiver;
import com.shiver.gct_additions.common.tile.TileEntityPrimordialPortalHolder;
import com.shiver.gct_additions.common.tile.TileEntitySanityAltar;
import com.shiver.gct_additions.common.tile.TileEntitySeekAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.shiver.gct_additions.Tags;

public final class GctAllTileEntities {
    private GctAllTileEntities() {
    }

    public static void register() {
        register(TileEntityBesideVoidPortal1.class, "tileentitybeside_void_portal_1");
        register(TileEntityBesideVoidPortal2.class, "tileentitybeside_void_portal_2");
        register(TileEntityBesideVoidPortal3.class, "tileentitybeside_void_portal_3");
        register(TileEntityEarthboundAltar.class, "tileentityearthbound_altar");
        register(TileEntityEarthboundReceiver.class, "tileentityearthbound_receiver");
        register(BlockFinalliumContainer.FinalliumContainerTileEntity.class, "tileentityfinallium_container");
        register(BlockFinalliumContainerActive.ActiveFinalliumContainerTileEntity.class, "tileentityfinallium_container_active");
        register(TileEntityPrimordialPortalHolder.class, "tileentityprimordial_portal_holder_up");
        register(TileEntitySanityAltar.class, "tileentitysanity_altar");
        register(TileEntitySeekAltar.class, "tileentityseek_altar");
        register(BlockSenterianSummoner.SenterianSummonerTileEntity.class, "tileentitysenterian_summoner");
    }

    private static void register(Class<? extends TileEntity> tileEntityClass, String name) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(Tags.MOD_ID, name));
    }
}
