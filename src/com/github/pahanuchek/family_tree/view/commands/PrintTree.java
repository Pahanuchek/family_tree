package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class PrintTree extends Command {

    public PrintTree(ConsoleUI consoleUI) {
        super(consoleUI, "Просмотреть дерево");
    }

    @Override
    public void execute() {
        getConsoleUI().getMainMenuService().printTree();
    }
}
