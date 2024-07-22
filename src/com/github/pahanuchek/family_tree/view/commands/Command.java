package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.Commandable;
import com.github.pahanuchek.family_tree.view.ConsoleUI;

public abstract class Command implements Commandable {
    private String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
