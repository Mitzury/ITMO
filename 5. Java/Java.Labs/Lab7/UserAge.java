package ru.mitzury;

import java.util.Scanner;

public class UserAge {

    Scanner scan = new Scanner(System.in);

    void input(){
        System.out.print("Введите возраст: ");
        int age = scan.nextInt();
        System.out.print("Ваш возраст: " + age);
        System.out.println();
    }
}

class UserName extends UserAge{
    @Override
    void input() {
        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        System.out.print("Ваше имя: " + name);
    }
}
