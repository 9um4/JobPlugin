package io.github.gum4.professions.handlers;

import org.bukkit.entity.Player;

import java.util.HashSet;

public class MoveHandler {
    private static final HashSet<Player> unmovables = new HashSet<>();
    public static boolean isMovable(Player player) {
        return unmovables.contains(player);
    }
    public static void setUnmovable(Player player) {
        unmovables.add(player);
    }
    public static void setMovable(Player player) {
        unmovables.remove(player);
    }
}
