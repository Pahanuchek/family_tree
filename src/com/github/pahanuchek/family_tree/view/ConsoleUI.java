package com.github.pahanuchek.family_tree.view;

import com.github.pahanuchek.family_tree.presenter.Presenter;
import com.github.pahanuchek.family_tree.view.menu.GenderMenu;
import com.github.pahanuchek.family_tree.view.menu.MainMenu;
import com.github.pahanuchek.family_tree.view.menu.MainMenuService;

import java.util.Scanner;


public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flagStartStop;
    private MainMenu mainMenu;

    private GenderMenu genderMenu;

    private MainMenuService mainMenuService;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flagStartStop = true;
        mainMenu = new MainMenu(this);
        genderMenu = new GenderMenu(this);
        mainMenuService = new MainMenuService(presenter, genderMenu, this);
    }


    @Override
    public void start() {
        while (flagStartStop) {
            System.out.println(mainMenu.getMenuConsole());
            try {
                int current = Integer.parseInt(scanner.nextLine());
                if (current >= 1 && current <= mainMenu.getSize()) {
                    mainMenu.executeMenu(current);
                } else {
                    System.out.println("Неккоректно выбран пункт!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неккоректно выбран пункт!");
            }
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void finish() {
        flagStartStop = false;
        scanner.close();
    }

    public MainMenuService getMainMenuService() {
        return mainMenuService;
    }
}
