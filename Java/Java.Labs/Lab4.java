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
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab43() {
        System.out.println("Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]»" + "\n");

        String str1 = "Говорить бяка плохо.";
        String str2 = str1.replace("бяка", "[вырезано цензурой]");
        System.out.println("Было: " + str1);
        System.out.println("Стало: " + str2);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab44() {
        System.out.println("Имеются две строки. Найти количество вхождений одной (являющейся подстрокой) в другую." + "\n");
        String str1 = "Первая строка.";
        String str2 = "Вторая строка.";
        int i = str1.split(str2).length;
        System.out.println("Количество вхождений: " + i);

    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab45() {
        System.out.println("Напишите метод, который инвертирует слова в строке. Предполагается, что в строке нет знаков препинания, и слова разделены пробелами.\n" +
                "Sample Output:\n" +
                "The given string is: This is a test string\n" +
                "The string reversed word by word is:\n" +
                "sihT si a tset gnirts\n" + "\n");

        String str1 = "This is test string";
        System.out.println("Нормальная строка: " + str1);
        String revStr = new StringBuilder(String.valueOf(str1)).reverse().toString();
        System.out.println("Реверсивная строка: " + revStr);
    }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}