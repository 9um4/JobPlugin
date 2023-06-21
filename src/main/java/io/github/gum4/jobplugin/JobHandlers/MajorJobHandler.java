package io.github.gum4.jobplugin.JobHandlers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class MajorJobHandler {
    private static final Component selectMajorJobUIName = Component.text("[", NamedTextColor.WHITE)
            .append(Component.text("LIN", NamedTextColor.AQUA))
            .append(Component.text("] 메인 직업을 선택해 주세요.", NamedTextColor.WHITE))
            .decoration(TextDecoration.ITALIC, false);
    private static Inventory selectMajorJobUI = Bukkit.createInventory(null, 27, selectMajorJobUIName);
    public MajorJobHandler(){
        // initialize selectMajorJobUI
        if (selectMajorJobUI.isEmpty()){

        }
    }
}
