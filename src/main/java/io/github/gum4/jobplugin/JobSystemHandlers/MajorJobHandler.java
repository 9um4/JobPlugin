package io.github.gum4.jobplugin.JobSystemHandlers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
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
    // major job selection UI click handling
    @EventHandler
    public void onMajorJobSelectionUIClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        int clickedSlot = event.getSlot();
        Component name = event.getView().title();

        // check if player clicked UI is valid
        if (!(name.equals(selectMajorJobUIName))) return;

        // on warrior selection
        if ( (clickedSlot % 9) <= 2 ){
            // todo: set player's job to warrior
            // todo: give player basic weapons for warrior
        }
        // on archer selection
        else if ( (clickedSlot % 9) <= 5 ) {
            // todo: set player's job to archer
            // todo: give player basic weapons for archer
        }
        // on magician selection
        else {
            // todo: set player's job to magician
            // todo: give player basic weapons for magician
        }
        event.getInventory().close();
        event.setCancelled(true);
    }

}
