package ru.mitzury;

import java.util.Scanner;

public class Lab4 {

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab41() {
        System.out.println("Написать метод для поиска самой длинной строки." + "\n");

        String str1 = "Первая строка.";
        String str2 = "Вторая строка. Длина";
        if (str1.length() > str2.length()) {
            System.out.println("Самая длинная строка: " + str1);
        } else {
            System.out.println("Самая длинная строка: " + str2);
        }
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab42() {
        System.out.println("Написать метод, который проверяет является ли слово палиндромом." + "\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = scan.nextLine();
        if(word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())){
            System.out.println(word + " - это слово палиндром.");
        }
        else {
            System.out.println(word + " - это слово не палиндром.");
        }
    }
}