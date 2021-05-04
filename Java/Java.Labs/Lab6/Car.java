package ru.mitzury;

public class Car {

    String color, name;
    int weigh;
    //Пустой конструктор
    Car(){

    }
    //Цвет автомобиля
    Car(String color){
        this.color = color;
    }
    //Цвет и вес автомобиля
    Car(String color,int weigh){
        this.color = color;
        this.weigh = weigh;
    }
    //Цвет, название и вес автомобиля
    Car(String color, String name, int weight){
        this.color = color;
        this.name = name;
        this.weigh = weight;
    }
    //Вывод на консоль
    public String printCar(){
        return String.format("Color: %s Name: %s Weight: %s",this.color,this.name,this.weigh + "kg");
    }
}
