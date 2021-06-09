package ru.mitzury;

public class Main {

    public static void main(String[] args) {
        Study course = new Study("Изучение Java - это сложно!");
        System.out.println(course.printCourse());

        Car BMW = new Car("Red","BMW M5",1790);
        Car MB = new Car("Black","E-class", 1890);
        Car AUDI = new Car("Grey","RS7",1925);
        System.out.println(BMW.printCar());
        System.out.println(MB.printCar());
        System.out.println(AUDI.printCar());

        House House_1 = new House("Дом №1", 9,1978);
        House House_2 = new House("Дом №2", 16,1988);
        System.out.println(House_1.printHouse());
        System.out.println(House_2.printHouse());

        Tree birch = new Tree();
        Tree aspen = new Tree(20,"осина");
        Tree pine = new Tree(40,"ель",true);
        System.out.println(birch.toString());
        System.out.println(aspen.toString());
        System.out.println(pine.toString());
    }
}