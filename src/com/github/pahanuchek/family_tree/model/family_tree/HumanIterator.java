package com.github.pahanuchek.family_tree.model.family_tree;


import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private List<E> listHumans;
    private int currentId;

    public HumanIterator(List<E> listHumans) {
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
    public E next() {
        return listHumans.get(currentId++);
    }
}
