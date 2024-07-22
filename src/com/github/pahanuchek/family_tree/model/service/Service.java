package com.github.pahanuchek.family_tree.model.service;

import com.github.pahanuchek.family_tree.model.family_tree.FamilyTree;
import com.github.pahanuchek.family_tree.model.human.Gender;
import com.github.pahanuchek.family_tree.model.human.Human;
import com.github.pahanuchek.family_tree.model.builder.HumanBuilder;
import com.github.pahanuchek.family_tree.model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        this.humanBuilder = new HumanBuilder();
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public Human createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        Human human = humanBuilder.build(name, gender, birthDay, deadDay);
        familyTree.addHuman(human);
        return human;
    }

    public Human createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay) {
        Human human = humanBuilder.build(name, gender, birthDay);
        familyTree.addHuman(human);
        return human;
    }

    public String searchHumanInTree(int id) {
        return familyTree.searchHuman(id).toString();
    }


    public boolean writeTreeInTheFile() {
        return fileHandler.writeDoc(familyTree);
    }

    public boolean readTreeFromFile() {
        familyTree = (FamilyTree) fileHandler.readDoc();
        if (familyTree != null) {
            humanBuilder = new HumanBuilder(familyTree.getSize());
            return true;
        }
        return false;
    }

    public String printTree() {
        return familyTree.toString();
    }

    public void sortTreeByName() {
        familyTree.sortByName();
    }

    public void sortTreeByAge() {
        familyTree.sortByAge();
    }

    public void sortTreeById() {
        familyTree.sortById();
    }

    public boolean addFather(int idHuman, int idFather) {
        Human human = familyTree.searchHuman(idHuman);
        Human parent = familyTree.searchHuman(idFather);
        boolean result = familyTree.addFather(human, parent);
        return  result;
    }

    public boolean addMother(int idHuman, int idMother) {
        Human human = familyTree.searchHuman(idHuman);
        Human parent = familyTree.searchHuman(idMother);
        boolean result = familyTree.addFather(human, parent);
        return  result;
    }

    public void printHuman(int idHuman) {
        System.out.println(searchHumanInTree(idHuman));
    }

    public boolean addChildren(int idHuman, int idChildren) {
        Human human = familyTree.searchHuman(idHuman);
        Human parent = familyTree.searchHuman(idChildren);
        boolean result = familyTree.addChildren(human, parent);
        return result;
    }

    public void addHuman(List<String> dataHuman) {
        String name = dataHuman.get(0);
        Gender gender;
        if (dataHuman.get(1).equals("Мужской")) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        LocalDate dateBirth = LocalDate.parse(dataHuman.get(2));
        if (dataHuman.get(3).isEmpty()) {
            printHuman(createHumanAndAddInTree(name, gender, dateBirth).getId());
        }
        else {
            LocalDate dateDead = LocalDate.parse(dataHuman.get(3));
            printHuman(createHumanAndAddInTree(name, gender, dateBirth, dateDead).getId());
        }
    }
}