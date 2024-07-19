package com.github.pahanuchek.family_tree.view;

import com.github.pahanuchek.family_tree.presenter.Presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flagStartStop;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flagStartStop = true;
    }



    @Override
    public void start() {

    }

    @Override
    public void printAnswer(String answer) {
        presenter.printTree();
    }

    public void searchHuman()
    {
        System.out.println("Введите идентификатор человека: ");
        String strId = scanner.nextLine();
        int id = Integer.parseInt(strId);
        presenter.printHuman(id);
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

    }

    public void addMother() {
        presenter.printTree();
        System.out.println("Введите идентификатор человека, которому хотите добавить маму," +
                " и идентификатор мамы через пробел: ");
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

    }

    public void addChildren() {
        presenter.printTree();
        System.out.println("Введите идентификатор родителя, которому хотите добавить ребенка," +
                " и идентификатор родителя через пробел: ");
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

    }

    public void finish() {
        flagStartStop = false;
        scanner.close();
    }
}
