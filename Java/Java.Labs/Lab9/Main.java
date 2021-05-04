package ru.mitzury;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {

        int[][] array1 = {{1, 4, 7}, {2, 8, 8}, {3, 6, 8}};
        int[][] array2 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {3, 6, 9}};

        char[][] array3 = new char [10][8];
        int[] array4 = {0,0,7,2,5,8,3,6,9,89};
        int[] array5 = {1,1,1,1,1,1,1,1,1,3};
        int[][] array6 = {};
        char[][] array7 = new char [0][0];
        System.out.println("EX1______________________");
        NumMax(array1);
//        NumMax(array6);
        System.out.println("EX2______________________");
        SquareArray(array1);
        SquareArray(array2);
//        SquareArray(array6);
        System.out.println("EX3______________________");
        CountMax(array2);
//        CountMax(array6);
        System.out.println("EX4______________________");
        GeneratorChar(array3);
//        GeneratorChar(array7);
        System.out.println("EX5______________________");
        GeneratorNum(array4,array5);

    }
    public static void NumMax(int [][] array){
        if (array == null|array.length == 0) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        int nummax = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (nummax < array[i][j]) {
                    nummax = array[i][j];
                }
            }
        }
        System.out.println("Наибольший элемент в массиве: "+nummax+"\n");
    }
    public static void SquareArray(int [][] array){
        if (array == null) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        int i=0;
        int j=0;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
            }
        }
        if (i==j){
            System.out.println("Двумерный массив является квадратным"+"\n");
        }else{

        System.out.println("Двумерный массив не является квадратным"+"\n");
        }
    }
    public static void CountMax(int [][] array){
        if (array == null|array.length == 0) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        int i=0;
        int j=0;
        int countMax=0;
        int b=0;
        int indexArray=0;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                countMax +=array[i][j];
            }
            if (b<countMax){
                b=countMax;
                indexArray=i;
            }
            countMax=0;
        }
        System.out.println("Cтрока, сумма элементов которой является максимальной среди всех строк матрицы: "+indexArray+"\n");

    }

    public static void GeneratorChar(char[][] array){
        if (array == null|array.length == 0) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        int[] charCodes = IntStream.rangeClosed('А', 'я').toArray();
        Random random = new Random();
        int pos;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                pos= random.nextInt(charCodes.length);
                array[i][j]=(char)charCodes[pos];
                System.out.print(" "+array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
}
    public static void GeneratorNum(int []array1,int []array2)throws NoSuchElementException {
        if (array1 == null|array1.length == 0) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        if (array2 == null|array2.length == 0) {
            throw new NullPointerException("Массив не должен быть равен null");
        }
        Random random = new Random();
        int pos;
        int a=1;
        int j=0;
        while (a==1&&j!=array1.length){
            pos= random.nextInt(array1.length);
            for (int i = 0; i < array2.length; i++) {
                if(array1[pos]==array2[i]){
                    System.out.println("Cлучайное число из первого массива, которое есть во втором массиве: "+ array2[i]);
                    a=0;
                    break;
                }
            }
            j++;
        }
        if(j==array1.length){
            throw new NoSuchElementException("Массивы не содержат одинаковые элементы");
        }

    }
}