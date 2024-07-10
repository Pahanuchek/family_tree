package com.github.pahanuchek.family_tree;

import com.github.pahanuchek.family_tree.family_tree.FamilyTree;
import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Human yulia = new Human("Yulia", Gender.Female, LocalDate.of(1995, 11, 20));
        Human pavel = new Human("Pavel", Gender.Male,
                LocalDate.of(1993, 12, 24));
        Human maya = new Human("Maya", Gender.Female,
                LocalDate.of(2020, 6, 25), pavel);
        Human sofia = new Human("Sofia", Gender.Female,
                LocalDate.of(2016, 11, 13), yulia);

        FamilyTree family = new FamilyTree();

        family.addHuman(yulia);
        family.addHuman(pavel);
        family.addHuman(maya);
        family.addHuman(sofia);


        System.out.println(family);

        pavel.addChildren(sofia);

        System.out.println(family);

        Human yuriy = new Human("Yuriy", Gender.Male,
                LocalDate.of(1965, 2, 5));
        Human svetlana = new Human("Svetlana", Gender.Female,
                LocalDate.of(1970, 12, 11));
        Human anastasiya = new Human("Anastasiya", Gender.Female,
                LocalDate.of(1990, 5, 22), yuriy, svetlana);

        family.addHuman(yuriy);
        family.addHuman(svetlana);
        yuriy.addChildren(pavel);
        svetlana.addChildren(pavel);
        family.addHuman(anastasiya);

        System.out.println(family);


    }
}