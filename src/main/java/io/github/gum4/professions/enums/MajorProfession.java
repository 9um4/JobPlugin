package io.github.gum4.professions.enums;

import io.github.gum4.professions.professions.AbstractMajorProfession;
import io.github.gum4.professions.professions.Archer;
import io.github.gum4.professions.professions.Magician;
import io.github.gum4.professions.professions.Warrior;

public enum MajorProfession {
    WARRIOR(new Warrior(), "전사"),
    ARCHER(new Archer(), "궁수"),
    MAGICIAN(new Magician(), "마법사");

    public final AbstractMajorProfession profession;
    public final String name;

    MajorProfession(AbstractMajorProfession profession, String name){
        this.profession = profession;
        this.name = name;
    }
}