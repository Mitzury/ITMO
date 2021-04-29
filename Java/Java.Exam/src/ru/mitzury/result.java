package ru.mitzury;

public class result {
    public String cityName;
    public double citytemp;
    public double feeltemp;
    public double humidity;

    public result(String cityName, double citytemp, double feeltemp, double humidity){
        this.cityName = cityName;
        this.citytemp = citytemp;
        this.feeltemp = feeltemp;
        this.humidity = humidity;
    }
    public String toString() {
        return "Ваш город: " + cityName + "\nТемпература: " + citytemp + "\nОщущается как: " + citytemp + "\nВлажность: " + humidity ;
    }
}
