package ru.mitzury;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //1st

        for (int i = 1; i <= 99; i++)
        {
            System.out.println("Строка №" + i);
        }

        //2st

        System.out.print("Числа делятся на 3: ");
        for (int i = 1; i <= 100; i++)
        {
            if (i % 3 == 0)
            System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.print("Числа делятся на 5: ");
        for (int i = 1; i <= 100; i++)
        {
            if (i % 5 == 0)
                System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.print("Числа делятся на 3 и 5: ");
        for (int i = 1; i <= 100; i++)
        {
            if (i % 5 == 0 && i % 3 == 0)
                System.out.print(i + " ");
        }

        //3st
        System.out.print("\n");
        System.out.println("ВВедите число 1: ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.print("ВВедите число 2: ");
        Scanner scanner2 = new Scanner(System.in);
        int num2 = scanner2.nextInt();
        System.out.print("ВВедите число 3: ");
        Scanner scanner3 = new Scanner(System.in);
        int num3 = scanner3.nextInt();
            if (num1 + num2 == num3)
                System.out.print("true");
            else
                System.out.print("false");

        //4st
        System.out.print("\n");
        System.out.println("ВВедите число 1: ");
        Scanner scanner4 = new Scanner(System.in);
        int num11 = scanner.nextInt();
        System.out.print("ВВедите число 2: ");
        Scanner scanner5 = new Scanner(System.in);
        int num12 = scanner2.nextInt();
        System.out.print("ВВедите число 3: ");
        Scanner scanner6 = new Scanner(System.in);
        int num13 = scanner3.nextInt();
            if (num11 < num12 && num13 > num12)
             System.out.print("true");
            else
                System.out.print("false");

        //5st

        System.out.print("\n");
        int[] nums = new int[] { 3, 2, 3, 5, 3 };
if (nums.length -1 == 3 && nums.)


    }
}
