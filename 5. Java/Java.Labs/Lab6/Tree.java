package ru.mitzury;

public class Tree {
    int age;
    String name;
    boolean alive;

    Tree(){
        System.out.println("Пустой конструктор без параетров сработал.");;
    }

    Tree(int age, String name){
        this.age = age;
        this.name = name;
    }

    Tree(int age, String name, boolean alive){
        this.age = age;
        this.name = name;
        this.alive = alive;
    }

    @Override
    public String toString(){
        return "Tree: " +
                "Name:" + name + " " +
                "Age:" + age + " " +
                "Alive:" + alive;
    }
}
