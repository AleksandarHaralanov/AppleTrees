package me.beezle.appletrees;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

import java.util.Random;

public class BlockHandler implements Listener {
    @EventHandler
    public void onLeavesDecay(final LeavesDecayEvent event) {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance <= 1) {
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.APPLE, 1));
        }
    }
}

