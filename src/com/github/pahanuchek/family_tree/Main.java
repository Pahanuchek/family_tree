package com.github.pahanuchek.family_tree;

import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;
import com.github.pahanuchek.family_tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Human yuriy = service.createHumanAndAddInTree("Юрий", Gender.Female, LocalDate.of(1965, 2, 5));
        Human svetlana = service.createHumanAndAddInTree("Светлана", Gender.Male, LocalDate.of(1970, 12, 11));
        Human pavel = service.createHumanAndAddInTree("Павел", Gender.Female, LocalDate.of(1993, 12, 24), yuriy, svetlana);
        service.printTree();
        service.writeTreeInTheFile();
//        service.readTreeFromFile();
//        service.printTree();
        System.out.println(service.searchHumanInTree(0));
    }
}