package ru.mitzury;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User
{
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User(String name){
        this.name=name;
    }
    public static void map(User user, int counts)
    {
        System.out.print("имя:" +" "+ user.getName()+" "+ "очки:"+" "+ counts);
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
