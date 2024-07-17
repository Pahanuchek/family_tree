package com.github.pahanuchek.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private  long id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deadDay;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate birthDay, LocalDate deadDay,
                 Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deadDay = deadDay;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, LocalDate birthDay, LocalDate deadDay) {
        this(id, name, gender, birthDay, deadDay, null, null);
    }

    public Human(int id, String name, Gender gender, LocalDate birthDay) {
        this(id, name, gender, birthDay, null, null, null);
    }
    public Human(int id, String name, Gender gender, LocalDate birthDay, Human parent) {
        this(id, name, gender, birthDay, null, null, null);
        addParents(parent);
    }

    public Human(int id, String name, Gender gender, LocalDate birthDay, Human father, Human mother) {
        this(id, name, gender, birthDay, null, father, mother);
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDeadDay() {
        return deadDay;
    }

    public void setDeadDay(LocalDate deadDay) {
        this.deadDay = deadDay;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public boolean addChildren(Human child) {
        if (child != null) {
            children.add(child);
            child.addParents(this);
            return true;
        } else {
            for(Human childrenReal: children) {
                if (childrenReal.equals(child)) {
                    return false;
                }
            }
        }
        children.add(child);
        return true;
    }

    public boolean addParents(Human parent) {
        if (parent.getGender().equals(Gender.Male) && this.father == null) {
            this.father = parent;
            return true;
        } else if (parent.getGender().equals(Gender.Female) && this.mother == null) {
            this.mother = parent;
            return true;
        }
        return false;
    }

    public int getAge(LocalDate birthDay, LocalDate deadDay) {
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
        result.append("Id: " + id + ". ");
        result.append("My name is " + this.name + ". ");
        result.append("I'm " + this.getAge(this.birthDay, this.deadDay) + " years old. ");
        if (this.father == null && this.mother != null) {
            result.append("My mother's name is " + mother.getName() + ". ");
        } else if (this.father != null && this.mother == null) {
            result.append("My dad's name is " + father.getName() + ". ");
        } else if (this.father != null && this.mother != null) {
            result.append("My parent's names are " + father.getName() + " dad and " + mother.getName() + " mom. ");
        }
        if (children != null && !children.isEmpty()) {
            if (children.size() == 1) {
                result.append("My children name is " + children.get(0).getName() + ". ");
            } else {
                result.append("My children's names are ");
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

