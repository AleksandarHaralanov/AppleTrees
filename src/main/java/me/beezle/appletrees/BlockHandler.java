package me.beezle.appletrees;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockHandler implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onLeavesDecay(final LeavesDecayEvent event) {
        handleDrop(event, "dropChance.Apple", 0.75, Material.APPLE);
        handleDrop(event, "dropChance.goldenApple", 0.02, Material.GOLDEN_APPLE);
    }

    private void handleDrop(LeavesDecayEvent event, String configKey, double defaultChance, Material dropMaterial) {
        double dropChance = AppleTrees.getInstance().getConfig().getDoubleConfigOption(configKey, defaultChance);
        if (dropChance > 0) {
            double randomDouble = random.nextDouble() * 100;
            if (randomDouble >= 0.01 && randomDouble <= dropChance) {
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(dropMaterial, 1));
            }
        }
    }
}
