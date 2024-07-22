package com.github.pahanuchek.family_tree.view;

import com.github.pahanuchek.family_tree.view.gender_commands.GenbderMaleCommand;
import com.github.pahanuchek.family_tree.view.gender_commands.GenderFemaleCommand;

import java.util.ArrayList;
import java.util.List;

public class GenderMenu {
    private List<Commandable> listGender;

    public GenderMenu(ConsoleUI consoleUI) {
        listGender = new ArrayList<>();
        listGender.add(new GenderFemaleCommand(consoleUI));
        listGender.add(new GenbderMaleCommand(consoleUI));
    }

    public String getMenuConsole() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите пол: \n");
        for (int i = 0; i < listGender.size(); i++) {
            if (listGender.size() - 1 == i) {
                stringBuilder.append((i + 1) + ". ").append(listGender.get(i).getDescription());
            } else {
                stringBuilder.append((i + 1) + ". ").append(listGender.get(i).getDescription() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public List<Commandable> getListGender() {
        return listGender;
    }

    public void executeMenu(int current) {
    }
}
