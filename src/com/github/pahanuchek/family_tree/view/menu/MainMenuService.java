package com.github.pahanuchek.family_tree.view.menu;

import com.github.pahanuchek.family_tree.presenter.Presenter;
import com.github.pahanuchek.family_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenuService {
    private Presenter presenter;
    private Scanner scanner;
    private GenderMenu genderMenu;
    private MenuPointAddHuman menuPointAddHuman;
    private ConsoleUI consoleUI;
    public MainMenuService(Presenter presenter, GenderMenu genderMenu, ConsoleUI consoleUI) {
        this.presenter = presenter;
        scanner = new Scanner(System.in);
        this.genderMenu = genderMenu;
        this.consoleUI = consoleUI;
        this.menuPointAddHuman = new MenuPointAddHuman(presenter, genderMenu, consoleUI);
    }
    public void addHuman() {
        menuPointAddHuman.addHuman();
    }

    public void searchHuman() {
        System.out.println("Введите идентификатор человека: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            presenter.printHuman(id);
        } catch (NumberFormatException  e) {
            System.out.println("Некорректно введен идентификатор!");
        } catch (NullPointerException e2) {
            System.out.println("Данные человек отсутствует в списке!");
        }
    }



    public void writeTreeToFile() {
        boolean result = presenter.writeTreeToFile();
        if (result) {
            System.out.println("Данные успешно записаны!");
        } else {
            System.out.println("Данные не записаны!");
        }
    }

    public void readTreeInFile() {
        boolean result = presenter.readTreeInFile();
        if (result) {
            System.out.println("Данные успешно загружены");
            presenter.printTree();
        } else {
            System.out.println("Данные не загружены");
        }
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortById() {
        presenter.sortById();
    }

    public void addFather() {
        presenter.printTree();
        System.out.println("Введите идентификатор человека, которому хотите добавить отца," +
                " и идентификатор отца через пробел: ");
        try {
            String strId = scanner.nextLine();
            List<String> listId = new ArrayList<>();
            listId = Arrays.asList(strId.split(" "));
            int idHuman = Integer.parseInt(listId.get(0));
            int idFather = Integer.parseInt(listId.get(1));
            boolean result = presenter.addFather(idHuman, idFather);
            if (result) {
                presenter.searchHuman(idHuman);
            } else {
                System.out.println("У данного человека уже есть отец");
            }
        } catch (NullPointerException e) {
            System.out.println("Данные люди отсутствуют в дереве!");
        }

    }

    public void addMother() {
        presenter.printTree();
        System.out.println("Введите идентификатор человека, которому хотите добавить маму," +
                " и идентификатор мамы через пробел: ");
        try {
            String strId = scanner.nextLine();
            List<String> listId = new ArrayList<>();
            listId = Arrays.asList(strId.split(" "));
            int idHuman = Integer.parseInt(listId.get(0));
            int idMother = Integer.parseInt(listId.get(1));
            boolean result = presenter.addMother(idHuman, idMother);
            if (result) {
                presenter.searchHuman(idHuman);
            } else {
                System.out.println("У данного человека уже есть мама");
            }
        } catch (NullPointerException e) {
            System.out.println("Данные люди отсутствуют в дереве!");
        }

    }

    public void addChildren() {
        presenter.printTree();
        System.out.println("Введите идентификатор родителя, которому хотите добавить ребенка," +
                " и идентификатор родителя через пробел: ");
        try {
            String strId = scanner.nextLine();
            List<String> listId = new ArrayList<>();
            listId = Arrays.asList(strId.split(" "));
            int idHuman = Integer.parseInt(listId.get(0));
            int idChildren = Integer.parseInt(listId.get(1));
            boolean result = presenter.addChildren(idHuman, idChildren);
            if (result) {
                presenter.searchHuman(idHuman);
            } else {
                System.out.println("Ребенок уже добавлен");
            }
        } catch (NullPointerException e) {
            System.out.println("Данные люди отсутствуют в дереве!");
        }

    }

    public void printTree() {
        presenter.printTree();
    }
}
