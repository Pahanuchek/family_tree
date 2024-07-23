package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class SearchHuman extends Command {

    public SearchHuman(ConsoleUI consoleUI) {
        super(consoleUI, "Найти человека");
    }

    @Override
    public void execute() {
        getConsoleUI().getMainMenuService().searchHuman();
    }
}