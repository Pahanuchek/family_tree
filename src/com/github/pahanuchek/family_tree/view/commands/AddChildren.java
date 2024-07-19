package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class AddChildren extends Command {

    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить отца");
    }

    @Override
    public void execute() {
        getConsoleUI().addChildren();
    }
}
