package com.github.pahanuchek.family_tree.view.menu;

import com.github.pahanuchek.family_tree.view.Commandable;
import com.github.pahanuchek.family_tree.view.ConsoleUI;
import com.github.pahanuchek.family_tree.view.die.NoDie;
import com.github.pahanuchek.family_tree.view.die.YesDie;
import com.github.pahanuchek.family_tree.view.gender_commands.GenbderMaleCommand;
import com.github.pahanuchek.family_tree.view.gender_commands.GenderFemaleCommand;

import java.util.ArrayList;
import java.util.List;

public class DieMenu {
    private List<Commandable> listYesNo;

    public DieMenu(ConsoleUI consoleUI) {
        listYesNo = new ArrayList<>();
        listYesNo.add(new YesDie(consoleUI));
        listYesNo.add(new NoDie(consoleUI));
    }

    public String getMenuConsole() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Хотите ввести дату смерти: \n");
        for (int i = 0; i < listYesNo.size(); i++) {
            if (listYesNo.size() - 1 == i) {
                stringBuilder.append((i + 1) + ". ").append(listYesNo.get(i).getDescription());
            } else {
                stringBuilder.append((i + 1) + ". ").append(listYesNo.get(i).getDescription() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public List<Commandable> getListGender() {
        return listYesNo;
    }

    public void executeMenu(int current) {
    }

    public int getSize() {
        return listYesNo.size();
    }
}

