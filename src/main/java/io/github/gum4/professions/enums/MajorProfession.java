package io.github.gum4.professions.enums;

import io.github.gum4.professions.professions.AbstractMajorProfession;
import io.github.gum4.professions.professions.Archer;
import io.github.gum4.professions.professions.Magician;
import io.github.gum4.professions.professions.Warrior;

public enum MajorProfession {
    WARRIOR(new Warrior()),
    ARCHER(new Archer()),
    MAGICIAN(new Magician());

    private final AbstractMajorProfession profession;

    MajorProfession(AbstractMajorProfession profession){
        this.profession = profession;
    }

    public AbstractMajorProfession getProfession(){
        return this.profession;
    }
}