package io.github.gum4.professions.enums;

import io.github.gum4.professions.professions.skills.AbstractSkill;
import io.github.gum4.professions.professions.skills.IronWill;
import io.github.gum4.professions.professions.skills.TempestBlade;

public enum Skill {
    TEMPEST_BLADE(new TempestBlade(), "강력한 검기"),
    IRON_WILL(new IronWill(), "견고한 의지");

    public final AbstractSkill skill;

    public final String name;

    Skill(AbstractSkill skill, String name) {
        this.skill = skill;
        this.name = name;
    }
}
