package ru.mitzury;

import java.util.Scanner;

public class Lab1 {

    public static void lab1(String[] args) {

        // 1st
        System.out.println("Я");
        System.out.println("отвратительно");
        System.out.println("знаю");
        System.out.println("Java");
        //2st
        System.out.print("(46 + 10) * (10 / 3) =");
        int a = (46 + 10) * (10 / 3);
        System.out.println(a);
        System.out.print("29 * 4 * -25 = ");
        int b = 29 * 4 * -25;
        System.out.println(b);
        //3st
        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println(result);
        //4st
        double a1 = 3.6d;
        double a2 = 4.1d;
        double a3 = 5.9d;
        double a4 = a1 * a2 * a3;
        System.out.println(a4);
        //5st
        System.out.print("Input a number1: ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.print("Input a number2: ");
        Scanner scanner2 = new Scanner(System.in);
        int num2 = scanner2.nextInt();
        System.out.print("Input a number3: ");
        Scanner scanner3 = new Scanner(System.in);
        int num3 = scanner3.nextInt();
        System.out.println("Вы ввели num1 = " + num1 + "; num2 = " + num2 + "; num3 = " + num3);
        //6st
        System.out.println("Input B: ");
        Scanner scan = new Scanner(System.in);
        int B = scan.nextInt();
        if (B % 2 != 0) {
            System.out.println("нечетное");
        } else {
            if (B > 100) {
                System.out.println("Вне диапазона");
            } else {
                System.out.println("четное");
            }
        }
    }
}
