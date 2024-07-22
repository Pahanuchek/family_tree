package com.github.pahanuchek.family_tree.model.human;

import com.github.pahanuchek.family_tree.model.family_tree.ItemUser;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, ItemUser<Human> {
    private  int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deadDay;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deadDay = deadDay;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, LocalDate birthDay) {
        this(id, name, gender, birthDay, null);
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addChildren(Human child) {
        if (!this.children.isEmpty()) {
            for(Human childrenReal: children) {
                if (childrenReal.equals(child)) {
                    return false;
                }
            }
        }
        children.add(child);
        if (this.gender == Gender.Male) {
            child.addFather(this);
        } else if (this.gender == Gender.Female) {
            child.addMother(this);
        }
        return true;
    }

    public boolean addFather(Human father) {
        if (this.father == null) {
            this.father = father;
            father.addChildren(this);
            return true;
        }
        return false;
    }

    public boolean addMother(Human mother) {
        if (this.mother == null) {
            this.mother = mother;
            mother.addChildren(this);
            return true;
        }
        return false;
    }

    public int getAge() {
        if (deadDay == null) {
            return Period.between(birthDay, LocalDate.now()).getYears();
        } else {
            return Period.between(birthDay, deadDay).getYears();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id && Objects.equals(name, human.name) && gender == human.gender && Objects.equals(birthDay, human.birthDay) && Objects.equals(deadDay, human.deadDay) && Objects.equals(father, human.father) && Objects.equals(mother, human.mother) && Objects.equals(children, human.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthDay, deadDay, father, mother, children);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("№: " + id + ". ");
        result.append("Меня зовут " + this.name + ". ");
        result.append("Мне " + this.getAge() + " лет. ");
        if (this.father == null && this.mother != null) {
            result.append("Мою маму зовут " + mother.getName() + ". ");
        } else if (this.father != null && this.mother == null) {
            result.append("Моего папу зовут " + father.getName() + ". ");
        } else if (this.father != null && this.mother != null) {
            result.append("Моих родителей зовут: " + father.getName() + " - папа, " + mother.getName() + " мама. ");
        }
        if (children != null && !children.isEmpty()) {
            if (children.size() == 1) {
                result.append("Моего ребенка зовут " + children.get(0).getName() + ". ");
            } else {
                result.append("Моих детей зовут ");
                for (Human child : children) {
                    if (child.equals(children.get(children.size() - 1))) {
                        result.append(child.getName() + ". ");
                    } else {
                        result.append(child.getName() + ", ");
                    }
                }
            }
        }
        return result.toString();
    }

}

