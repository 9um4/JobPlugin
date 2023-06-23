package io.github.gum4.professions.enums;

import io.github.gum4.professions.professions.skills.AbstractSkill;
import io.github.gum4.professions.professions.skills.IronWill;
import io.github.gum4.professions.professions.skills.TempestBlade;

public enum Skill {
    TEMPEST_BLADE(new TempestBlade(), "������ �˱�"),
    IRON_WILL(new IronWill(), "�߰��� ����");

    public final AbstractSkill skill;

    public final String name;

    Skill(AbstractSkill skill, String name) {
        this.skill = skill;
        this.name = name;
    }
}
