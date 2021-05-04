package ru.mitzury;


public abstract class Human {

    private String Name;
    private String LastName;
    //конструктор
    Human(String Name,String LastName){
        this.Name = Name;
        this.LastName = LastName;
    }

    public String getName(){
        return Name;
    }

    public String getLastName(){
        return LastName;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    //вывод
    public abstract void display();
}
