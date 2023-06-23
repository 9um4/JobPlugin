package io.github.gum4.professions.listeners;

import io.github.gum4.professions.events.SelectMajorProfessionUIOpenEvent;
import io.github.gum4.professions.handlers.MajorProfessionHandler;
import io.github.gum4.professions.handlers.UIHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!MajorProfessionHandler.hasMajorProfession(uuid)){
            player.openInventory(UIHandler.selectMajorProfessionUI);
            Bukkit.getServer().getPluginManager().callEvent(new SelectMajorProfessionUIOpenEvent(player));
        }
        return;
    }
}
