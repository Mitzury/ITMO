package ru.mitzury;

import java.util.Scanner;

public class Lab1 {
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab11() {
        System.out.println("Выведите строки в следующем порядке:" + "\n");
        System.out.println("Я");
        System.out.println("отвратительно");
        System.out.println("знаю");
        System.out.println("Java");
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab12() {
        System.out.println("Посчитайте результат выражения\n" +
                "(46 + 10) * (10 / 3)\n" +
                "(29) * (4) * (-15)" + "\n");
        System.out.print("(46 + 10) * (10 / 3) =");
        int a = (46 + 10) * (10 / 3);
        System.out.println(a);
        System.out.print("29 * 4 * -25 = ");
        int b = 29 * 4 * -25;
        System.out.println(b);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab13() {
        System.out.println("В переменной number, лежит целое число 10500. В переменной result посчитайте следующее\n" +
                "выражение: (number / 10) / 10. Результат выведите на консоль." + "\n");

        int number = 10500;
        int result = (number / 10) / 10;
        System.out.println(result);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab14() {
        System.out.println("Даны три числа: 3.6, 4.1, 5.9. В переменной result посчитайте произведение этих чисел." + "\n");
        double a1 = 3.6d;
        double a2 = 4.1d;
        double a3 = 5.9d;
        double a4 = a1 * a2 * a3;
        System.out.println(a4);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab15() {
        System.out.println("В этой задаче вы должны считать целые числа из стандартного ввода, а затем вывести. Каждое\n" +
                "целое число нужно печатать с новой строки. Формат ввода:\n" +
                "42\n" +
                "100\n" +
                "125" + "\n");
        System.out.print("Input a number1: ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.print("Input a number2: ");
        int num2 = scanner.nextInt();
        System.out.print("Input a number3: ");
        int num3 = scanner.nextInt();
        System.out.println("Вы ввели num1 = " + num1 + "; num2 = " + num2 + "; num3 = " + num3);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab16() {
        System.out.println("Для целого числа b выполните следующие условные действия:\n" +
                "Если b нечетное, выведите “Нечетное”\n" +
                "Если b четное, выведите “Четное”\n" +
                " Если b четное и больше 100, выведите “Выход за пределы диапазона” \n");
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

