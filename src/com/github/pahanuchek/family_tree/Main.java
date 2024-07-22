package com.github.pahanuchek.family_tree;


import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}