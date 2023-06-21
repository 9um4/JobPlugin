package io.github.gum4.jobplugin.jobs;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Warrior {
    public static void powerfulSlash(Player player){
    }
    public static void firmWill(Player player){
        // todo: float the shield around the player
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1, false, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 1));
    }
}
