package com.github.pahanuchek.family_tree.view.menu;

import com.github.pahanuchek.family_tree.view.Commandable;
import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Commandable> listCommands;

    public MainMenu(ConsoleUI consoleUI) {
        listCommands = new ArrayList<>();
        listCommands.add(new PrintTree(consoleUI));
        listCommands.add(new AddHuman(consoleUI));
        listCommands.add(new AddFather(consoleUI));
        listCommands.add(new AddMother(consoleUI));
        listCommands.add(new AddChildren(consoleUI));
        listCommands.add(new SearchHuman(consoleUI));
        listCommands.add(new SortHumanByName(consoleUI));
        listCommands.add(new SortHumanByAge(consoleUI));
        listCommands.add(new SortHumanById(consoleUI));
        listCommands.add(new WriteData(consoleUI));
        listCommands.add(new ReadData(consoleUI));
        listCommands.add(new Finish(consoleUI));
    }

    public String getMenuConsole() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню семейного дерева: \n");
        for (int i = 0; i < listCommands.size(); i++) {
            if (listCommands.size() - 1 == i) {
                stringBuilder.append((i + 1) + ". ").append(listCommands.get(i).getDescription());
            } else {
                stringBuilder.append((i + 1) + ". ").append(listCommands.get(i).getDescription() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public void executeMenu(int current) {
        listCommands.get(current - 1).execute();
    }

    public int getSize() {
        return listCommands.size();
    }
}

