package com.github.pahanuchek.family_tree.model.family_tree;

import com.github.pahanuchek.family_tree.model.human.comparators.HumanComparatorByAge;
import com.github.pahanuchek.family_tree.model.human.comparators.HumanComparatorById;
import com.github.pahanuchek.family_tree.model.human.comparators.HumanComparatorByName;

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

    public boolean addFather(E e1, E e2) {
        boolean result = e1.addFather(e2);
        return result;
    }

    public boolean addMother(E e1, E e2) {
        boolean result = e1.addMother(e2);
        return result;
    }

    public boolean addChildren(E e1, E e2) {
        boolean result = e1.addChildren(e2);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("В данном семейном дереве " + listHumans.size() + " человек(а):\n");
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

    public int getSize() {
        return listHumans.size();
    }

}
