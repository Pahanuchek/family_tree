package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class SortHumanById extends Command {

    public SortHumanById(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по идентификатору");
    }

    @Override
    public void execute() {
        getConsoleUI().getMainMenuService().sortById();
    }
}
