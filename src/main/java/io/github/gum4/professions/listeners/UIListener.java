package io.github.gum4.professions.listeners;

import io.github.gum4.professions.enums.MajorProfession;
import io.github.gum4.professions.enums.UI;
import io.github.gum4.professions.events.uis.SelectMajorProfessionUIOpenEvent;
import io.github.gum4.professions.handlers.MajorProfessionHandler;
import io.github.gum4.professions.handlers.UIHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.gum4.professions.enums.UI.*;

public class UIListener implements Listener {
    private static JavaPlugin plugin;
    public UIListener(JavaPlugin plugin){
        UIListener.plugin = plugin;
    }
    @EventHandler
    public void onSelectMajorProfessionUIOpenEvent(SelectMajorProfessionUIOpenEvent event){
        Player player = event.player;
        if (UIHandler.getCurrentUI(player) == SELECT_MAJOR_PROFESSION) return;
        UIHandler.setCurrentUI(player, SELECT_MAJOR_PROFESSION);
        return;
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        switch (UIHandler.getCurrentUI(player)) {
            case SELECT_MAJOR_PROFESSION:
                if (!MajorProfessionHandler.hasMajorProfession(player)) {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        if (player.isOnline()) {
                            player.openInventory(UIHandler.selectMajorProfessionUI);
                        }
                    }, 1L); // Reopen the inventory 1 tick later
                    break;
                }
                UIHandler.setCurrentUI(player, UI.NULL);
        }
    }
    @EventHandler
    public void onMajorProfessionSelectionUIClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        int clickedSlot = event.getSlot();
        Component name = event.getView().title();

        // check if player clicked UI is valid
        if (!(UIHandler.getCurrentUI(player) == SELECT_MAJOR_PROFESSION)) return;

        if ((event.getClickedInventory() instanceof PlayerInventory)) return;

        // on warrior selection
        if ( (clickedSlot % 9) <= 2 ){
            MajorProfessionHandler.setMajorProfession(player, MajorProfession.WARRIOR);
            // todo: give player basic weapons for warrior
        }
        // on archer selection
        else if ( (clickedSlot % 9) <= 5 ) {
            MajorProfessionHandler.setMajorProfession(player, MajorProfession.ARCHER);
            // todo: give player basic weapons for archer
        }
        // on magician selection
        else {
            MajorProfessionHandler.setMajorProfession(player, MajorProfession.MAGICIAN);
            // todo: give player basic weapons for magician
        }
        event.setCancelled(true);
        event.getInventory().close();
        Title title = Title.title(Component.text("환영합니다!"), Component.empty());
        player.showTitle(title);
    }
}
