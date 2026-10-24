
package com.shiver.gct_additions.common.items;

import java.util.List;

import com.shiver.gct_additions.common.events.CreepyWitherstormDollClick;
import com.shiver.gct_additions.misc.GctAdditionsCreativeTab;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class ItemCreepyWitherstormDoll extends Item {
    public static final Item block = new ItemCreepyWitherstormDoll();

    public ItemCreepyWitherstormDoll() {
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setTranslationKey("creepy_witherstorm_doll");
        this.setRegistryName("creepy_witherstorm_doll");
        this.setCreativeTab(GctAdditionsCreativeTab.TAB);

    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add("§f也挺可爱的……");
        tooltip.add("§e它失去了传送的能力，不过可以召唤凋灵风暴！");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack doll = player.getHeldItem(hand);
        if (!Loader.isModLoaded("witherstormmod")) return new ActionResult<>(EnumActionResult.FAIL, doll);
        boolean summoned = CreepyWitherstormDollClick.summon(player, world, doll);
        return new ActionResult<>(summoned ? EnumActionResult.SUCCESS : EnumActionResult.FAIL, doll);
    }

}
