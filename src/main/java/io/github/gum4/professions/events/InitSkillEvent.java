package io.github.gum4.professions.events;

import io.github.gum4.professions.enums.Skill;
import io.github.gum4.professions.professions.skills.AbstractSkill;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when the skill is initialized
 */
public class InitSkillEvent extends Event {
    public static final HandlerList handlers = new HandlerList();
    // a player who use skill
    public final Player player;
    // a skill which is used by player
    public final Skill skill;
    public InitSkillEvent(Player player, Skill skill){
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
