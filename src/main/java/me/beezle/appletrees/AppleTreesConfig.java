package me.beezle.appletrees;

import org.bukkit.util.config.Configuration;

import java.io.File;

public class AppleTreesConfig extends Configuration {

    public AppleTreesConfig(File file) {
        super(file);
        write();
    }

    public void write()
    {
        generateConfigOption("dropChance.Apple", 0.75);
        generateConfigOption("dropChance.goldenApple", 0.02);
    }

    private void generateConfigOption(String key, Object defaultValue)
    {
        if (this.getProperty(key) == null) {
            this.setProperty(key, defaultValue);
        }
        final Object value = this.getProperty(key);
        this.removeProperty(key);
        this.setProperty(key, value);
    }

    public double getDoubleConfigOption(String key, double defaultValue) {
        Object value = this.getProperty(key);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return defaultValue;
    }
}
