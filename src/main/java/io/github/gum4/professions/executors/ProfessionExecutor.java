package io.github.gum4.professions.executors;

import io.github.gum4.professions.events.SelectMajorProfessionUIOpenEvent;
import io.github.gum4.professions.handlers.MajorProfessionHandler;
import io.github.gum4.professions.handlers.UIHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProfessionExecutor implements @Nullable CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1){
                if (args[0].equals("get")){
                    if (MajorProfessionHandler.hasMajorProfession(player)){
                        player.sendMessage(
                                Component.text("현재 당신의 직업은 ")
                                        .color(NamedTextColor.WHITE)
                                        .append(
                                                Component.text(MajorProfessionHandler.getMajorProfession(player).name)
                                                        .color(NamedTextColor.RED)
                                        )
                                        .append(
                                                Component.text("입니다.")
                                                        .color(NamedTextColor.WHITE)
                                        )
                        );
                        return true;
                    }
                    player.sendMessage(
                            Component.text("현재 당신의 직업은 없습니다.")
                    );
                    return true;
                }
                else if (args[0].equals("set")) {
                    Bukkit.getServer().getPluginManager().callEvent(new SelectMajorProfessionUIOpenEvent(player));
                    player.openInventory(UIHandler.selectMajorProfessionUI);
                }
            }
            return false;
        }
        else {
            sender.sendMessage(
                    Component.text("플레이어만 사용할 수 있는 명령어입니다.")
            );
            return true;
        }
    }
}
