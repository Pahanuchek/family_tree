package com.github.pahanuchek.family_tree.view.gender_commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.commands.Command;

public class GenderFemaleCommand extends Command {

    public GenderFemaleCommand(ConsoleUI consoleUI) {
        super(consoleUI, "Мужской");
    }

    @Override
    public void execute() {
        getDescription();
    }
}