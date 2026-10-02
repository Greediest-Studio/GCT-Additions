package com.shiver.gct_additions.common.blocks;

import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

  public class BlockPolarisiteDarkBrick extends Block {
  public static final Block block = new BlockPolarisiteDarkBrick();

  public BlockPolarisiteDarkBrick() {
    super(Material.ROCK);
    setTranslationKey("polarisite_dark_brick");
    setSoundType(SoundType.STONE);
    setHarvestLevel("pickaxe", 8);
    setHardness(15.0F);
    setResistance(4000.0F);
    setLightLevel(0.0F);
    setLightOpacity(255);
    setCreativeTab(GctAdditionsCreativeTab.TAB);
  }
}
