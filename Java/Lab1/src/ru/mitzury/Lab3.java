package ru.mitzury;


import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        public static void lab32() {
        System.out.println("Напишите программу, которая считывает с клавиатуры длину массива " +
                "(например, пользователь вводит цифру 4), затем пользователь вводит 4 числа и на" +
                " новой строке выводится массив из 4 элементов." + "\n");

        System.out.println("Array length: ");
        Scanner scanner = new Scanner(System.in);
        int aLenght = scanner.nextInt();
        int[] nums = new int[aLenght];
        for (int i = 0; i < aLenght; i++) {
            System.out.println("Enter numbers of array: ");
            int num = scanner.nextInt();
            nums[i]  = num;
        }
        String intArrayString = Arrays.toString(nums);
        System.out.println(intArrayString);
    }

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}


