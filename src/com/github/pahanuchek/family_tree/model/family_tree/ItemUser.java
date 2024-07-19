package com.github.pahanuchek.family_tree.model.family_tree;

import java.util.List;

public interface ItemUser<E> {
    int getId();
    boolean addChildren(E e);
    int getAge();
    String getName();
    boolean addFather(E e);
    boolean addMother(E e);
}
