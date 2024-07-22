package com.github.pahanuchek.family_tree.view;

import com.github.pahanuchek.family_tree.presenter.Presenter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flagStartStop;
    private MainMenu mainMenu;

    private GenderMenu genderMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flagStartStop = true;
        mainMenu = new MainMenu(this);
        genderMenu = new GenderMenu(this);
    }


    @Override
    public void start() {
        while (flagStartStop) {
            System.out.println(mainMenu.getMenuConsole());
            if (scanner.hasNextInt()) {
                int current = scanner.nextInt();
                if (current >= 1 && current <= mainMenu.getSize()) {
                    mainMenu.executeMenu(current);
                }
            } else {
                System.out.println("Неккоректно выбран пункт!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void printAnswer() {
        presenter.printTree();
    }

    public void searchHuman() {
        System.out.println("Введите идентификатор человека: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            presenter.printHuman(id);
        }
    }

    public void addHuman() {
        List<String> dataHuman = new ArrayList<>();
        System.out.print("Введите имя: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        dataHuman.add(name);
        System.out.println(genderMenu.getMenuConsole());
        String gender = genderMenu.getListGender().get(Integer.parseInt(scanner.nextLine()) - 1).getDescription();
        dataHuman.add(gender);
        System.out.println("Введите дату рождения");
        String dateBirthDay = getDate();
        if (dateBirthDay.equals("")) {
            return;
        }
        dataHuman.add(dateBirthDay);
        System.out.println("\nВведите дату смерти, если ее нет введите 0:");
        String dateDeadDay = getDate();
        dataHuman.add(dateDeadDay);
        presenter.addHuman(dataHuman);
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
        printAnswer();
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
        printAnswer();
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
        printAnswer();
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

    public String getDate() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.print("Введите год: ");
        if (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            if (year == 0) {
                return "";
            }
            if (year > 1000 && year < LocalDate.now().getYear() + 1) {
                stringBuilder.append(year + "-");
            }
            else {
                System.out.println("Введен не существующий год!");
                return "";
            }
        } else {
             System.out.println("Ввден некорректный год!");
            return "";
        }
        System.out.print("Введите месяц: ");
        if (scanner.hasNextInt()) {
            int month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                if (month < 10) {
                    stringBuilder.append("0" + month + "-");
                } else {
                    stringBuilder.append(month + "-");
                }
            } else {
                System.out.println("Такого месяца не существует!");
                return "";
            }
        }  else {
            System.out.println("Неккоректный ввод числового значения месяца!");
            return "";
        }
        System.out.print("Введите день: ");
        if (scanner.hasNextInt()) {
            int day = scanner.nextInt();
            if (day >= 1 && day <= 31) {
                if (day < 10) {
                    stringBuilder.append("0" + day);
                } else {
                    stringBuilder.append(day);
                }
            } else {
                System.out.println("Такого месяца не существует!");
                return "";
            }
        }  else {
            System.out.println("Неккоректный ввод числового значения месяца!");
            return "";
        }

        return stringBuilder.toString();
    }

    public void finish() {
        flagStartStop = false;
        scanner.close();
    }
}
