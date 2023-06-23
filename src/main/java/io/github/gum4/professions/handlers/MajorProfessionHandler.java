package io.github.gum4.professions.handlers;

import io.github.gum4.professions.enums.MajorProfession;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class MajorProfessionHandler{
    private static final HashMap<UUID, MajorProfession> majorProfessionMap = new HashMap<>();
    private static final HashMap<UUID, boolean[]> skillAvailabilityMap = new HashMap<>();
    private static final HashMap<UUID, Integer> levelMap = new HashMap<>();
    private static final HashMap<UUID, Integer> expMap = new HashMap<>();
    private static final HashMap<UUID, Integer> mpMap = new HashMap<>();

    public static boolean hasMajorProfession(UUID uuid){
        return majorProfessionMap.containsKey(uuid);
    }
    public static boolean hasMajorProfession(Player player) {
        return hasMajorProfession(player.getUniqueId());
    }
    public static MajorProfession getMajorProfession(UUID uuid){
        return majorProfessionMap.get(uuid);
    }
    public static MajorProfession getMajorProfession(Player player){
        return getMajorProfession(player.getUniqueId());
    }
    public static void setMajorProfession(UUID uuid, MajorProfession majorProfession) {
        majorProfessionMap.put(uuid, majorProfession);
    }
    public static void setMajorProfession(Player player, MajorProfession majorProfession) {
        setMajorProfession(player.getUniqueId(), majorProfession);
    }
}
