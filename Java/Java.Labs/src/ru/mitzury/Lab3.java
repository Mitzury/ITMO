package ru.mitzury;

import java.util.Arrays;
import java.util.Random;
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
        System.out.println("Result: " + intArrayString);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab33() {
        System.out.println("Напишите метод, который меняет местами первый и последний элемент массива" + "\n");
        int[] array1 = new int[]{1,2,3,4,5};
        int first = array1[0];
        int lastsym = array1.length - 1;
        int last = array1[lastsym];
        int[] array2 = new int[]{last,2,3,4,first};
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab34() {
        System.out.println("Дан массив чисел. Найдите первое уникальное в этом массиве число." + "\n");
        int[] array1 = new int[]{1,1,2,2,3,4,4};
        int count = 0;
        for (int i = 0 ; i < array1.length ; i++)
        {
            boolean uniq = true;
            for (int i2 = 0 ; i2 < array1.length ; i2 ++)
            {
                if (i != i2 && array1[i] == array1[i2])
                {
                uniq = false;
                break;
                }
            }
            if(uniq)
            {
                System.out.println(array1[i]);
                break;
            }
        }
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static int lab35(int n) {
        System.out.println("Вычислить N-е число Фибоначчи. Не использовать рекурсию и массивы, только циклы." + "\n");

        if (n==1) {
             return 0;
        }
        if (n ==2) {
            return 1;
        }
        int previous = 1;
        int acc = 1;

        while (n - 2 > 0) {
            int s = acc;
            acc += previous;
            previous = s;
            n--;
        }
        return  acc;
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void  lab36() {
        System.out.println("Заполните массив случайным числами и отсортируйте его. Используйте сортировку слиянием." + "\n");
        Random random = new Random();
        int min = 1;
        int max = 100;

        int array[] = new int[100];
        for (int i = 0; i < 100; i++) {
            int rnd = random.nextInt(max - min);
            array[i] = rnd;
        }
        System.out.println("Изначальный массив: " + Arrays.toString(array));

        int[] array2 = new int[array.length / 2];
        System.arraycopy(array, 0, array2, 0, array.length / 2);

        int[] array3 = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, array3, 0, array.length - array.length / 2);

        System.out.println("массив 2: " + Arrays.toString(array2));
        System.out.println("массив 2: " + Arrays.toString(array3));
        Arrays.sort(array2);
        Arrays.sort(array3);
        System.out.println("Сортированный массив 2: " + Arrays.toString(array2));
        System.out.println("Сортированный массив 3: " + Arrays.toString(array3));


        int[] arrayC = new int[array2.length + array3.length];
        int i = 0, j = 0;
        for (int k = 0; k < arrayC.length; k++) {

            if (i > array2.length - 1) {
                int a = array3[j];
                arrayC[k] = a;
                j++;
            } else if (j > array3.length - 1) {
                int a = array2[i];
                arrayC[k] = a;
                i++;
            } else if (array2[i] < array3[j]) {
                int a = array2[i];
                arrayC[k] = a;
                i++;
            } else {
                int b = array3[j];
                arrayC[k] = b;
                j++;
            }

        }

        System.out.println("Сортированный изначальный массив: " + Arrays.toString(arrayC));
    }

}
