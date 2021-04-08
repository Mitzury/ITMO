package ru.mitzury;


import java.util.Scanner;

public class Lab3 {

    public static void lab31() {

System.out.println("Напишите программу, которая проверяет отсортирован ли массив по возрастанию. " +
"Если он отсортирован по возрастанию то выводится “OK”, если нет, " +
"то будет выводиться текст “Please, try again”" + "\n");

        boolean sorted = true;
        int[] nums = new int[]{1, 2, 3, 10, 5};
        if (nums.length <= 1) {
            System.out.println("Array is sorted");
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    sorted = false;
                    break;
                }
            }
            System.out.println(sorted ? "ok" : "Please, try again");
        }

    }
}


