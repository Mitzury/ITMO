package ru.mitzury;

public class Truck extends Car{

    int wheels, maxWeight;

    Truck(int w, String m, char c, float s, int wheels, int maxWeight){
        super(w, m, c, s);
        this.wheels = wheels;
        this.maxWeight = maxWeight;
    }

    void newWheels(int wheels){
        this.wheels = wheels;
    }

    @Override
    public void outPut() {
        super.outPut();
        System.out.printf("Количество колес:  %s", this.wheels);
    }
}
