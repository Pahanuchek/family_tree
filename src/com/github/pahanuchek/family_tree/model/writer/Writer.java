package com.github.pahanuchek.family_tree.model.writer;

public interface Writer {
    boolean writeDoc(Object object);
    Object readDoc();
}
