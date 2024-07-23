package com.github.pahanuchek.family_tree.view.die;

import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.commands.Command;

public class NoDie extends Command {

    public NoDie(ConsoleUI consoleUI) {
        super(consoleUI, "Нет");
    }

    @Override
    public void execute() {
        getDescription();
    }
}