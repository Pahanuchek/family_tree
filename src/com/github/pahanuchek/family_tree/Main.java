package com.github.pahanuchek.family_tree;

import com.github.pahanuchek.family_tree.human.Gender;
import com.github.pahanuchek.family_tree.human.Human;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Human human = new Human("Pavel", Gender.Male, LocalDate.of(1993, 12, 24));
        System.out.println(human);
    }
}