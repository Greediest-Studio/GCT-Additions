package com.shiver.gct_additions.common.blocks;

import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class GctAdditionsSimpleBlock extends Block {
    @Nullable
    private final String tooltip;
    private final boolean semiTransparent;
    private final boolean isGlass;

    public GctAdditionsSimpleBlock(String name, Material material, SoundType soundType,
                                   float hardness, float resistance,
                                   @Nullable String harvestTool, int harvestLevel,
                                   float lightLevel, int lightOpacity,
                                   boolean semiTransparent, boolean isGlass,
                                   @Nullable String tooltip) {
        super(material);
        this.tooltip = tooltip;
        this.semiTransparent = semiTransparent;
        this.isGlass = isGlass;

        setRegistryName(name);
        setTranslationKey(name);
        setSoundType(soundType);
        setHardness(hardness);
        setResistance(resistance);
        if (harvestTool != null) {
            setHarvestLevel(harvestTool, harvestLevel);
        }
        setLightLevel(lightLevel);
        setLightOpacity(lightOpacity);
        setCreativeTab(GctAdditionsCreativeTab.TAB);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return !semiTransparent && !isGlass;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return !semiTransparent && !isGlass;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer() {
        return isGlass ? BlockRenderLayer.TRANSLUCENT : (semiTransparent ? BlockRenderLayer.CUTOUT : BlockRenderLayer.SOLID);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if (isGlass) {
            IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
            if (iblockstate.getBlock() == this) {
                return false;
            }
        }
        return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (this.tooltip != null && !this.tooltip.isEmpty()) {
            tooltip.add(this.tooltip);
        }
    }
}

