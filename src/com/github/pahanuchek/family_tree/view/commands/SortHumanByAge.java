package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class SortHumanByAge extends Command {

    public SortHumanByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по возрасту");
    }

    @Override
    public void execute() {
        getConsoleUI().getMainMenuService().sortByAge();
    }
}
