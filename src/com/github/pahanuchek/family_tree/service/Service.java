package com.github.pahanuchek.family_tree.service;

import com.github.pahanuchek.family_tree.family_tree.FamilyTree;
import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;
import com.github.pahanuchek.family_tree.builder.HumanBuilder;
import com.github.pahanuchek.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        this.humanBuilder = new HumanBuilder();
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }

    public Human createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, LocalDate deadDay,
                                        Human father, Human mother) {
        Human human = humanBuilder.build(name, gender, birthDay, deadDay, father, mother);
        familyTree.addHuman(human);
        return human;
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

    public Human createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, Human parent) {
        Human human = humanBuilder.build(name, gender, birthDay, parent);
        familyTree.addHuman(human);
        return human;
    }

    public Human createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, Human father, Human mother) {
        Human human = humanBuilder.build(name, gender, birthDay, father, mother);
        familyTree.addHuman(human);
        return human;
    }

    public Human searchHumanInTree(int id) {
        return familyTree.searchHuman(id);
    }


    public void writeTreeInTheFile() {
        fileHandler.writeDoc(familyTree);
    }

    public void readTreeFromFile() {
        familyTree = (FamilyTree) fileHandler.readDoc();
    }

    public void printTree() {
        System.out.println(familyTree);
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
}