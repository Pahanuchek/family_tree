package com.github.pahanuchek.family_tree.presenter;

import com.github.pahanuchek.family_tree.model.service.Service;
import com.github.pahanuchek.family_tree.view.View;

import java.util.List;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void searchHuman(int id) {
        printHuman(id);
    }

    public boolean writeTreeToFile() {
        return service.writeTreeInTheFile();
    }

    public boolean readTreeInFile() {
        boolean result = service.readTreeFromFile();
        return result;
    }

    public void printTree() {
        String answer = service.printTree();
        System.out.println(answer);
    }

    public void sortByName() {
        service.sortTreeByName();
    }

    public void sortByAge() {
        service.sortTreeByAge();
    }

    public void sortById() {
        service.sortTreeById();
    }

    public boolean addFather(int idHuman, int idFather) {
        boolean result = service.addFather(idHuman, idFather);
        return result;
    }

    public boolean addMother(int idHuman, int idMother) {
        boolean result = service.addMother(idHuman, idMother);
        return result;
    }

    public boolean addChildren(int idHuman, int idChildren) {
        boolean result = service.addChildren(idHuman, idChildren);
        return result;
    }

    public void printHuman(int id) {
        service.printHuman(id);
    }

    public void addHuman(List<String> dataHuman) {
        service.addHuman(dataHuman);
    }

}
