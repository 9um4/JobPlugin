package io.github.gum4.professions.listeners;

import io.github.gum4.professions.handlers.MoveHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!MoveHandler.isMovable(player)) event.setCancelled(true);
        player.sendActionBar(
                Component.text("기를 모으는 동안에는 움직일 수 없습니다!")
        );
    }
}
