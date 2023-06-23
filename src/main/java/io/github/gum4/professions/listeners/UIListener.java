package io.github.gum4.professions.listeners;

import io.github.gum4.professions.enums.MajorProfession;
import io.github.gum4.professions.enums.UI;
import io.github.gum4.professions.events.SelectMajorProfessionUIOpenEvent;
import io.github.gum4.professions.handlers.MajorProfessionHandler;
import io.github.gum4.professions.handlers.UIHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class UIListener implements Listener {
    @EventHandler
    public void onSelectMajorProfessionUIOpen(SelectMajorProfessionUIOpenEvent event) {
        Player player = event.player;
        if (!(UIHandler.getCurrentUI(player) == UI.SELECT_MAJOR_PROFESSION)) {
            UIHandler.setCurrentUI(player, UI.SELECT_MAJOR_PROFESSION);
        }
    }
    @EventHandler
    public void onSelectMajorProfessionUIClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if ((UIHandler.getCurrentUI(player) == UI.SELECT_MAJOR_PROFESSION)){
            if (!MajorProfessionHandler.hasMajorProfession(player)){
                player.openInventory(UIHandler.selectMajorProfessionUI);
                return;
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
        if (!(UIHandler.getCurrentUI(player) == UI.SELECT_MAJOR_PROFESSION)) return;

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
        event.getInventory().close();
        event.setCancelled(true);
        Title title = Title.title(Component.text("환영합니다!"), Component.empty());
        player.showTitle(title);
    }
}
