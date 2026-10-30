package com.shiver.gct_additions.common.events;

import com.shiver.gct_additions.Tags;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.shiver.gct_additions.common.world.dimension.GctAdditionsDimensions.ATLANTIS;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class MobDropHandler {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntityLiving() instanceof EntityElderGuardian) {
            EntityItem drop = new EntityItem(
                    event.getEntityLiving().world,
                    event.getEntityLiving().posX,
                    event.getEntityLiving().posY,
                    event.getEntityLiving().posZ,
                    new ItemStack(ATLANTIS)
            );
            event.getDrops().add(drop);
        }
    }
}
