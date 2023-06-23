package io.github.gum4.professions.enums;

import io.github.gum4.professions.professions.AbstractMajorProfession;
import io.github.gum4.professions.professions.Archer;
import io.github.gum4.professions.professions.Magician;
import io.github.gum4.professions.professions.Warrior;

public enum MajorProfession {
    WARRIOR(new Warrior(), "����"),
    ARCHER(new Archer(), "�ü�"),
    MAGICIAN(new Magician(), "������");

    public final AbstractMajorProfession profession;
    public final String name;

    MajorProfession(AbstractMajorProfession profession, String name){
        this.profession = profession;
        this.name = name;
    }
}