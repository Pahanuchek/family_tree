package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class AddFather extends Command {

    public AddFather(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить отца");
    }

    @Override
    public void execute() {
        getConsoleUI().addFather();
    }
}