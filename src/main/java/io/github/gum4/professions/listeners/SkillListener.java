package io.github.gum4.professions.listeners;

import io.github.gum4.professions.enums.Skill;
import io.github.gum4.professions.events.InitSkillEvent;
import io.github.gum4.professions.handlers.MoveHandler;
import io.github.gum4.professions.professions.skills.AbstractSkill;
import io.github.gum4.professions.professions.skills.TempestBlade;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.gum4.professions.enums.Skill.TEMPEST_BLADE;

public class SkillListener implements Listener {
    @EventHandler
    public void onInitSkill(InitSkillEvent event) {
        Player player = event.player;
        Skill skill = event.skill;
        switch (skill) {
            case TEMPEST_BLADE:
                MoveHandler.setUnmovable(player);
                Bukkit.getScheduler().runTaskLater(
                        plugin,
                        () -> {
                            MoveHandler.setMovable(player);
                        },
                        TempestBlade.unmovableTick
                );
                break;
        }
    }

    private final JavaPlugin plugin;

    public SkillListener(JavaPlugin plugin){
        this.plugin = plugin;
    }
}
