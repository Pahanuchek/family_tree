package com.github.pahanuchek.family_tree.family_tree;

import java.util.List;

public interface ItemUser<E> {
    int getId();
    E getFather();
    boolean addParents(E e);
    boolean addChildren(E e);
    int getAge();
    String getName();
    E getMother();
    List<E> getChildren();
}
