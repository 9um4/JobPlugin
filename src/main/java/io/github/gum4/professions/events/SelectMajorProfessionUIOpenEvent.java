package io.github.gum4.professions.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
/**
 * Called when the Select Major Profession UI is opened
 */
public class SelectMajorProfessionUIOpenEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    public final Player player;

    public SelectMajorProfessionUIOpenEvent(Player player) {
        this.player = player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
