package io.github.gum4.jobplugin.JobHandlers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MajorJobHandler {
    private static final Component selectMajorJobUIName = Component.text("[", NamedTextColor.WHITE)
            .append(Component.text("LIN", NamedTextColor.AQUA))
            .append(Component.text("] 메인 직업을 선택해 주세요.", NamedTextColor.WHITE))
            .decoration(TextDecoration.ITALIC, false);
    private static final Inventory selectMajorJobUI = Bukkit.createInventory(null, 27, selectMajorJobUIName);
    public MajorJobHandler(){
        // initialize selectMajorJobUI
        if (selectMajorJobUI.isEmpty()){
            for (int i = 0; i < 27; i++) {
                ItemStack selectMajorJobIcon = new ItemStack(Material.PAPER, 1);
                // todo: set the custom model data, lore and display name of items
                selectMajorJobUI.setItem(i, selectMajorJobIcon);
            }
        }
    }
    // open major job selection UI
    public static void openSelectMajorJobUI(Player player){
        player.openInventory(selectMajorJobUI);
    }
}
