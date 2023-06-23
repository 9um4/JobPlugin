package io.github.gum4.professions.professions;

import org.bukkit.entity.Player;

public interface AbstractProfession {
    abstract void initSkill(Player player, int index);
    abstract void useSkill(Player player, int index);
    abstract void terminateSkill(Player player, int index);
}
