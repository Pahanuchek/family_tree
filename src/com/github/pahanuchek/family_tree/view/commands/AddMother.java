package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class AddMother extends Command {

    public AddMother(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить маму");
    }

    @Override
    public void execute() {
        getConsoleUI().addMother();
    }
}
