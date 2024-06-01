package me.beezle.appletrees;

import org.bukkit.plugin.java.JavaPlugin;

public class AppleTrees extends JavaPlugin {
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.print("[AppleTrees] Enabled.");
    }

    public void onDisable() {
        System.out.print("[AppleTrees] Disabled.");
    }
}
