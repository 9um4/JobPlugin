package io.github.gum4.professions.professions.skills;

import io.github.gum4.professions.handlers.MoveHandler;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Knockback attacking entity
 */
public class TempestBlade implements AbstractSkill{
    public static int unmovableTick = 60;

    public static boolean initSkill(JavaPlugin plugin, Player player) {
        // todo: check if player can use it
        MoveHandler.setUnmovable(player);
        Bukkit.getScheduler().runTaskLater(
                plugin,
                () -> {
                    MoveHandler.setMovable(player);
                },
                activateDelayTick
        );
        initEffect(plugin, player);
    }

    public static boolean initEffect(JavaPlugin plugin, Player player){
        Location centerLocation = player.getLocation().add(0, -1, 0);
        new BukkitRunnable() {
            int tick = 0;
            float radius = 1.5f;
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 1);
            public void run(){
                double t0 = tick * Math.PI / 10;

                for (int i = 0; i < 8; i++) {
                    player.getWorld().spawnParticle(
                            Particle.REDSTONE,
                            centerLocation.clone().add(radius * Math.cos(t0 + ((i / 4) * Math.PI)), 0, radius * Math.sin(t0 + ((i / 4) * Math.PI))),
                            1,
                            dustOptions
                    );
                }
                tick += 1;
            }
        }.runTaskTimer(plugin, 0, activateDelayTick);

        return true;
    }

    @Override
    public void useSkill(Player player) {

    }

    @Override
    public void termSkill(Player player) {

    }
}
