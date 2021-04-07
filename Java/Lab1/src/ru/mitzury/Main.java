package ru.mitzury;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        boolean sorted = true;
        int[] nums = new int[]{1, 2, 3, 4, 5};
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