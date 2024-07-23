package com.github.pahanuchek.family_tree.view.menu;

import com.github.pahanuchek.family_tree.presenter.Presenter;
import com.github.pahanuchek.family_tree.view.Commandable;
import com.github.pahanuchek.family_tree.view.ConsoleUI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPointAddHuman {
    private Presenter presenter;
    private GenderMenu genderMenu;
    private Scanner scanner;
    private ConsoleUI consoleUI;
    private DieMenu dieMenu;

    public MenuPointAddHuman(Presenter presenter, GenderMenu genderMenu, ConsoleUI consoleUI) {
        this.presenter = presenter;
        this.genderMenu = genderMenu;
        scanner = new Scanner(System.in);
        this.consoleUI = consoleUI;
        dieMenu = new DieMenu(consoleUI);
    }

    public void addHuman() {
        List<String> dataHuman = new ArrayList<>();

        String name = getName();
        if (name.isEmpty()) {
            return;
        }
        dataHuman.add(name);

        String gender = getGender();
        if (gender.isEmpty()) {
            return;
        }
        dataHuman.add(gender);

        System.out.println("Введите дату рождения");
        String dateBirthDay = getDate();
        if (dateBirthDay == null) {
            return;
        }
        dataHuman.add(dateBirthDay);
        String answer = isDie();
        if (answer == null || answer.equals("Нет")) {
            dataHuman.add(null);
        } else {
            System.out.println("\nВведите дату смерти");
            String dateDeadDay = getDate();
            dataHuman.add(dateDeadDay);
        }
        presenter.addHuman(dataHuman);
        System.out.println("Человек добавлен!");
    }
    public Integer isDigit() {
        try {
            String yearStr = scanner.nextLine();
            Integer year = Integer.parseInt(yearStr);
            return year;
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Введено некорректное значение");
            return null;
        }
    }

    public String getYear() {
        try {
            System.out.print("Введите год: ");
            Integer year = isDigit();
            if (year == 0) {
                return null;
            }
            if (year > 1000 && year < LocalDate.now().getYear() + 1) {
                return year + "";
            } else {
                System.out.println("Введен не существующий год!");
            }
        } catch (NullPointerException e) {;
        }
        return null;
    }
    public String getMonth() {
        try {
            System.out.print("Введите месяц: ");
            Integer month = isDigit();
            if (month == 0) {
                return null;
            }
            if (month >= 1 && month <= 12) {
                if (month < 10) {
                    return "0" + month;
                } else {
                    return month + "";
                }
            } else {
                System.out.println("Такого месяца не существует!");
            }
        } catch (NullPointerException e) {
        }
        return null;
    }

    public String getDay() {
        try {
            System.out.print("Введите день: ");
            Integer day = isDigit();
            if (day == 0) {
                return null;
            }
            if (day >= 1 && day <= 31) {
                if (day < 10) {
                    return "0" + day;
                } else {
                    return day + "";
                }
            } else {
                System.out.println("Такого месяца не существует!");
            }
        } catch(NullPointerException e) {
        }
        return null;
    }

    public String getDate() {
        StringBuilder stringBuilder = new StringBuilder();

        String year = getYear();
        String month = getMonth();
        String day = getDay();
        String date = dateCheck(year, month, day);
        if (date == null) {
            return null;
        }
        return date;
    }

    public String dateCheck(String year, String month, String day) {
        if (year == null || month == null || day == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year).append("-").append(month).append("-").append(day);
        return stringBuilder.toString();
    }



    public String getName() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Вы ввели пустое имя!");
        }
        return name;
    }

    public String isVisiblePointMenu(String title, int size, List<Commandable> list) {
        System.out.println(title);
        String gender;
        String currentStr = scanner.nextLine();
        if (currentStr.isEmpty()) {
            System.out.println("Неправильно выбран пункт");
            return null;
        }
        int current = Integer.parseInt(currentStr);
        if (current > 0 && current <= size) {
            gender = list.get(current - 1).getDescription();
        } else {
            System.out.println("Неправильно выбран пункт");
            return null;
        }
        return gender;
    }

    public  String getGender() {
        String title = genderMenu.getMenuConsole();
        int size = genderMenu.getSize();
        List<Commandable> list = genderMenu.getListGender();
        return isVisiblePointMenu(title, size, list);
    }
    public String isDie() {
        String title = dieMenu.getMenuConsole();
        int size = dieMenu.getSize();
        List<Commandable> list = dieMenu.getListGender();
        return isVisiblePointMenu(title, size, list);
    }
}
