package com.shiver.gct_additions.common.potions;

import com.shiver.gct_additions.Tags;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionCorrecting extends Potion {
    public static final PotionCorrecting potion = new PotionCorrecting();

    private PotionCorrecting() {
        super(false, 0xFFFFFF);
        setRegistryName(new ResourceLocation(Tags.MOD_ID, "correcting"));
        setPotionName("effect.correcting");
    }

    @Override
    public boolean shouldRenderInvText(PotionEffect effect) {
        return false;
    }

    @Override
    public boolean shouldRenderHUD(PotionEffect effect) {
        return false;
    }
}
