package com.github.pahanuchek.family_tree.builder;

import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int checkId;

    public Human build(String name, Gender gender, LocalDate birthDay, LocalDate deadDay,
                       Human father, Human mother) {
        return new Human(checkId++, name, gender, birthDay, deadDay, father, mother);
    }

    public Human build(String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        return new Human(checkId++, name, gender, birthDay, deadDay);
    }

    public Human build(String name, Gender gender, LocalDate birthDay) {
        return new Human(checkId++, name, gender, birthDay);
    }

    public Human build(String name, Gender gender, LocalDate birthDay, Human parent) {
        return new Human(checkId++, name, gender, birthDay, parent);
    }

    public Human build(String name, Gender gender, LocalDate birthDay, Human father, Human mother) {
        return new Human(checkId++, name, gender, birthDay, father, mother);
    }
}
