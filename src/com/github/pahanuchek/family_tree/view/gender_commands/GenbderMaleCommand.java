package com.github.pahanuchek.family_tree.view.gender_commands;

import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.commands.Command;

public class GenbderMaleCommand extends Command {

    public GenbderMaleCommand(ConsoleUI consoleUI) {
        super(consoleUI, "Женский");
    }

    @Override
    public void execute() {
        getDescription();
    }
}
