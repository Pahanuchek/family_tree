package com.github.pahanuchek.family_tree.view.die;

import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.commands.Command;

public class YesDie extends Command {

    public YesDie(ConsoleUI consoleUI) {
        super(consoleUI, "Да");
    }

    @Override
    public void execute() {
        getDescription();
    }
}