package io.github.gum4.professions.professions.skills;

import org.bukkit.entity.Player;

public interface AbstractSkill {
    int maxCoolTick = 100;
    int currentCoolTick = 0;
    int mpCost = 0;
    int activateDelayTick = 60;

    void initSkill(Player player);
    void useSkill(Player player);
    void termSkill(Player player);
}
