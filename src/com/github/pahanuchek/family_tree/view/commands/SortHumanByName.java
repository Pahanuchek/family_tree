package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class SortHumanByName extends Command {

    public SortHumanByName(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по имени");
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
