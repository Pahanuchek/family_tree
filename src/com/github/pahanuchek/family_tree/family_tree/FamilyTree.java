package com.github.pahanuchek.family_tree.family_tree;

import com.github.pahanuchek.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Long> checkHumanId;
    private List<Human> listHumans;

    public FamilyTree() {
        this.listHumans = new ArrayList<>();
        this.checkHumanId = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!checkHumanId.contains(human.getId())) {
            checkHumanId.add(human.getId());
            listHumans.add(human);
            searchAndAddChildrenFather(human);
            searchAndAddChildrenMother(human);
            searchAndAddParentChildren(human);
        }
    }

    public void searchAndAddChildrenFather(Human human) {
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }

    public void searchAndAddChildrenMother(Human human) {
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
    }

    public void searchAndAddParentChildren(Human human) {
        if (human.getChildren() != null && human.getChildren().isEmpty()) {
            for (Human child: human.getChildren()) {
                child.addParents(human);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("There are " + listHumans.size() + " people in this family tree:\n");
        for (Human human: listHumans) {
            result.append(human + "\n");
        }
        return result.toString();
    }
}
