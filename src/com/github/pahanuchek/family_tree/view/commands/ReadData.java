package com.github.pahanuchek.family_tree.view.commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;

public class ReadData extends Command {

    public ReadData(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить данные");
    }

    @Override
    public void execute() {
        getConsoleUI().readTreeInFile();
    }
}
