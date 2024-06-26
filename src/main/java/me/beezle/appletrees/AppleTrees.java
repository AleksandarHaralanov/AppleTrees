package me.beezle.appletrees;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class AppleTrees extends JavaPlugin {

    private static AppleTrees instance;
    private AppleTreesConfig config;

    @Override
    public void onEnable() {
        instance = this;
        config = new AppleTreesConfig(new File(getDataFolder(), "config.yml"));
        getServer().getPluginManager().registerEvents(new BlockHandler(), this);
        System.out.print("[AppleTrees v2.0.0] Enabled.");
    }

    @Override
    public void onDisable() {
        System.out.print("[AppleTrees v2.0.0] Disabled.");
    }

    public AppleTreesConfig getConfig() {
        return config;
    }

    public static AppleTrees getInstance() {
        return instance;
    }
}
