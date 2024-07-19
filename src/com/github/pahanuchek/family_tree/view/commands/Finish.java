package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Выйти");
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
