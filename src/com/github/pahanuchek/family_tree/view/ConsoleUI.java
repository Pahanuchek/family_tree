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
    public void printAnswer() {
        presenter.printTree();
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
        printAnswer();
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
        printAnswer();
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

    public Integer getYear() {
        try {
            System.out.print("Введите год: ");
            Integer year = isDigit();
            if (year == 0) {
                return null;
            }
            if (year > 1000 && year < LocalDate.now().getYear() + 1) {
                return year;
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

        Integer year = getYear();
        if (year == null) {
            return null;
        } else {
            stringBuilder.append(year + "-");
        }

        String month = getMonth();
        if (month == null) {
            return null;
        } else {
            stringBuilder.append(month + "-");
        }

        String day = getDay();
        if (day == null) {
            return null;
        } else {
            stringBuilder.append(day);
        }

        return stringBuilder.toString();
    }

    public void finish() {
        flagStartStop = false;
        scanner.close();
    }

    public String getName() {
        System.out.print("Введите имя: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Вы ввели пустое имя!");
        }
        return name;
    }

    public  String getGender() {
        System.out.println(genderMenu.getMenuConsole());
        String gender;
        String currentStr = scanner.nextLine();
        if (currentStr.isEmpty()) {
            System.out.println("Неправильно выбран пункт");
            return null;
        }
        int current = Integer.parseInt(currentStr);
        if (current > 0 && current <= genderMenu.getSize()) {
            gender = genderMenu.getListGender().get(current - 1).getDescription();
        } else {
            System.out.println("Неправильно выбран пункт");
            return null;
        }
        return gender;
    }
}
