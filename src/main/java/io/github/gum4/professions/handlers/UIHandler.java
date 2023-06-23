package io.github.gum4.professions.handlers;

import io.github.gum4.professions.enums.UI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;

public class UIHandler {

    private static final Component selectMajorProfessionUIName = Component.text("[", NamedTextColor.WHITE)
            .append(Component.text("LIN", NamedTextColor.AQUA))
            .append(Component.text("] 메인 직업을 선택.", NamedTextColor.WHITE))
            .decoration(TextDecoration.ITALIC, false);
    public static final Inventory selectMajorProfessionUI = Bukkit.createInventory(null, 27, selectMajorProfessionUIName);
    private static final HashMap<Player, UI> currentUIMap = new HashMap<>();
    public static void setCurrentUI(Player player, UI ui){
        if (ui != UI.NULL){
            currentUIMap.put(player, ui);
            return;
        }
        currentUIMap.remove(player);
    }
    public static UI getCurrentUI(Player player){
        return currentUIMap.getOrDefault(player, UI.NULL);
    }
}
