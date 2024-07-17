package com.github.pahanuchek.family_tree.human.comparators;

import com.github.pahanuchek.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
