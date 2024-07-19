package com.github.pahanuchek.family_tree.model.builder;

import com.github.pahanuchek.family_tree.model.human.Gender;
import com.github.pahanuchek.family_tree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int checkId;

    public Human build(String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        return new Human(checkId++, name, gender, birthDay, deadDay);
    }

    public Human build(String name, Gender gender, LocalDate birthDay) {
        return new Human(checkId++, name, gender, birthDay);
    }
}
