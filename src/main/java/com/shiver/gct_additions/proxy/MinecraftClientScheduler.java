package com.shiver.gct_additions.proxy;

import com.shiver.gct_additions.common.network.ClientTasks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class MinecraftClientScheduler implements ClientTasks.Scheduler {
    @Override
    public void schedule(Runnable task) {
        Minecraft.getMinecraft().addScheduledTask(task);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getMinecraft().player.world;
    }
}
