package com.github.pahanuchek.family_tree.writer;

public interface Writer {
    void writeDoc(Object object);
    Object readDoc();
}
