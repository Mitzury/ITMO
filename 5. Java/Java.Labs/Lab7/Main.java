package ru.mitzury;

public class Main {

    public static void main(String[] args) {

        Truck truck = new Truck(8000,"KamaZ",'A',120,10,9000);
        truck.outPut();
        System.out.println();

        UserAge age = new UserAge();
        age.input();
        UserName name = new UserName();
        name.input();
        System.out.println();

        Airplane.Wing wing = new Airplane.Wing();
        wing.setWeight(200);
        System.out.println("Вес левого крыла: " + wing.getWeight());
        Airplane.Wing wing2 = new Airplane.Wing();
        wing.setWeight(0);
        System.out.println("Вес правого крыла: " + wing2.getWeight());
    }
}
