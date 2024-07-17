package com.github.pahanuchek.family_tree.family_tree;

import com.github.pahanuchek.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private List<Human> listHumans;
    private int currentId;

    public HumanIterator(List<Human> listHumans) {
        this.listHumans = listHumans;
    }

    @Override
    public boolean hasNext() {
        if (listHumans.size() > currentId) {
            return true;
        }
        return false;
    }

    @Override
    public Human next() {
        return listHumans.get(currentId++);
    }
}
