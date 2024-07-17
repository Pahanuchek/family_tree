package com.github.pahanuchek.family_tree.family_tree;

import com.github.pahanuchek.family_tree.human.Human;
import com.github.pahanuchek.family_tree.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
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

    public Human searchHuman(int id) {
        if (!checkHumanId.contains(id)) {
            for (Human human: listHumans) {
                if (human.getId() == id) {
                    return  human;
                }
            }
        }
        return null;
    }

    private void searchAndAddChildrenFather(Human human) {
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }

    private void searchAndAddChildrenMother(Human human) {
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
    }

    private void searchAndAddParentChildren(Human human) {
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

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(listHumans);
    }
}
