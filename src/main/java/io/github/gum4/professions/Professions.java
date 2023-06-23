package io.github.gum4.professions;

import io.github.gum4.professions.listeners.JoinListener;
import io.github.gum4.professions.listeners.UIListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Professions extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new UIListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
