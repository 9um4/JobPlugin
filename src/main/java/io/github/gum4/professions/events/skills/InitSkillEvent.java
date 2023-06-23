package io.github.gum4.professions.events.skills;

import io.github.gum4.professions.professions.skills.AbstractSkill;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class InitSkillEvent extends Event {
    public static final HandlerList handlers = new HandlerList();
    public final Player player;
    public final AbstractSkill skill;
    public InitSkillEvent(Player player, AbstractSkill skill){
        this.player = player;
        this.skill = skill;
    }
    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
