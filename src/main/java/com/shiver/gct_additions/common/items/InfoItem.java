package com.shiver.gct_additions.common.items;

import java.util.List;

import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InfoItem extends Item {
    private final String[] tooltips;
    private final boolean glowing;

    public InfoItem(String name) {
        this(name, 64, 0, false);
    }

    public InfoItem(String name, int maxStackSize, int maxDamage, String tooltip, boolean glowing) {
        this(name, maxStackSize, maxDamage, glowing, tooltip == null ? new String[0] : new String[] { tooltip });
    }

    public InfoItem(String name, int maxStackSize, int maxDamage, boolean glowing, String... tooltips) {
        this.tooltips = tooltips;
        this.glowing = glowing;
        setMaxDamage(maxDamage);
        setMaxStackSize(maxStackSize);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(GctAdditionsCreativeTab.TAB);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (this.tooltips != null) {
            for (String line : this.tooltips) {
                if (line != null && !line.isEmpty()) {
                    tooltip.add(line);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return glowing;
    }
}
