package ru.mitzury;

import java.time.LocalDate;

public class House {

    String name;
    int floors, year;

    House(String name, int floors, int year){
        this.name = name;
        this.floors = floors;
        this.year = year;
    }
    //Лет с момента постройки
    public int ageHouse(){
        int age = LocalDate.now().getYear() - this.year;
        return age;
    }
    //Вывод на консоль
    public String printHouse(){
        return String.format("Name: %s Floors: %s Year of construct: %s Age: %s",
                this.name,this.floors,this.year, ageHouse());
    }
}
