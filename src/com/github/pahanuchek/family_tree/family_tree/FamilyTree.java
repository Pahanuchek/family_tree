package com.github.pahanuchek.family_tree.family_tree;

import com.github.pahanuchek.family_tree.human.Human;
import com.github.pahanuchek.family_tree.human.comparators.HumanComparatorByAge;
import com.github.pahanuchek.family_tree.human.comparators.HumanComparatorById;
import com.github.pahanuchek.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemUser<E>> implements Serializable, Iterable<E> {
    private List<Integer> checkHumanId;
    private List<E> listHumans;

    public FamilyTree() {
        this.listHumans = new ArrayList<>();
        this.checkHumanId = new ArrayList<>();
    }

    public void addHuman(E e) {
        if (!checkHumanId.contains(e.getId())) {
            checkHumanId.add(e.getId());
            listHumans.add(e);
            searchAndAddChildrenFather(e);
            searchAndAddChildrenMother(e);
            searchAndAddParentChildren(e);
        }
    }

    public E searchHuman(int id) {
        if (checkHumanId.contains(id)) {
            for (E e: listHumans) {
                if (e.getId() == id) {
                    return  e;
                }
            }
        }
        return null;
    }

    private void searchAndAddChildrenFather(E e) {
        if (e.getFather() != null) {
            e.getFather().addChildren(e);
        }
    }

    private void searchAndAddChildrenMother(E e) {
        if (e.getMother() != null) {
            e.getMother().addChildren(e);
        }
    }

    private void searchAndAddParentChildren(E e) {
        if (e.getChildren() != null && e.getChildren().isEmpty()) {
            for (E child: e.getChildren()) {
                child.addParents(e);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("There are " + listHumans.size() + " people in this family tree:\n");
        for (E e: listHumans) {
            result.append(e + "\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(listHumans);
    }

    public void sortByName() {
        listHumans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        listHumans.sort(new HumanComparatorByAge<>());
    }

    public void sortById() {
        listHumans.sort(new HumanComparatorById<>());
    }
}
