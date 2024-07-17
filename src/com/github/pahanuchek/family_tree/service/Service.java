package com.github.pahanuchek.family_tree.service;

import com.github.pahanuchek.family_tree.family_tree.FamilyTree;
import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;
import com.github.pahanuchek.family_tree.human.HumanBuilder;
import com.github.pahanuchek.family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public Service() {
        this.humanBuilder = new HumanBuilder();
        this.familyTree = new FamilyTree();
        this.fileHandler = new FileHandler();
    }

    public void createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, LocalDate deadDay,
                                        Human father, Human mother) {
        familyTree.addHuman(humanBuilder.build(name, gender, birthDay, deadDay, father, mother));
    }

    public void createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        familyTree.addHuman(humanBuilder.build(name, gender, birthDay, deadDay));
    }

    public void createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay) {
        familyTree.addHuman(humanBuilder.build(name, gender, birthDay));
    }

    public void createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, Human parent) {
        familyTree.addHuman(humanBuilder.build(name, gender, birthDay, parent));
    }

    public void createHumanAndAddInTree(String name, Gender gender, LocalDate birthDay, Human father, Human mother) {
        familyTree.addHuman(humanBuilder.build(name, gender, birthDay, father, mother));
    }

    public Human searchHumanInTree(int id) {
        return familyTree.searchHuman(id);
    }


    public void writeTreeInTheFile() {
        fileHandler.writeDoc(familyTree);
    }

    public Object readTreeFromFile() {
        return fileHandler.readDoc();
    }
}