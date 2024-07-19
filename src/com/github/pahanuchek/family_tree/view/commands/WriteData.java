package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class WriteData extends Command {

    public WriteData(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить данные");
    }

    @Override
    public void execute() {
        getConsoleUI().writeTreeToFile();
    }
}