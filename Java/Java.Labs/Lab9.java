package ru.mitzury;

import java.util.Arrays;
import java.util.Scanner;

public class lab5 {

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void lab51() {

            Vector vec1 = new Vector(1.5,2.2,3);
            Vector vec2 = new Vector(4.5,5.2,6);
            System.out.println("Длина вектора 1: " + vec1.lengthVec());
            System.out.println("Длина вектора 2: " + vec2.lengthVec());
            System.out.println("Скалярное произведение: " + vec1.scalarVec(vec2));
            System.out.println("Векторное произведение: " + vec1.prodVec(vec2));
            System.out.println("Косинус (угол) между векторами: " + vec1.cosVec(vec2));
            System.out.println("Сумма векторов: " + vec1.sumVec(vec2));
            System.out.println("Разность векторов: " + vec1.minVec(vec2));
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            Vector[] res = Vector.generate(n);
            System.out.println("Массив случайных векторов размером N: " + Arrays.toString(res));
        }

        static class Vector {
            private final double x;
            private final double y;
            private final double z;

            public Vector(double x, double y, double z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }

            @Override
            public String toString() {
                return "{" +
                        "x=" + x +
                        ", y=" + y +
                        ", z=" + z +
                        '}';
            }

            // Длина вектора
            public double lengthVec() {
                return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
            }

            // Скалярное произведение
            public double scalarVec(Vector vector) {
                return x * vector.x + y * vector.y + z * vector.z;
            }

            // Векторное произведение
            public Vector prodVec(Vector vector) {
                return new Vector(
                        y * vector.z - z * vector.y,
                        z * vector.x - x * vector.z,
                        x * vector.y - y * vector.x);
            }

            // Косинус между векторами
            public double cosVec(Vector vector) {
                return scalarVec(vector) / (lengthVec() * vector.lengthVec());
            }

            //Сумма
            public Vector sumVec(Vector vectorSum) {
                return new Vector(
                        x + vectorSum.x,
                        y + vectorSum.y,
                        z + vectorSum.z
                );
            }

            //Разность
            public Vector minVec(Vector vectorMin) {
                return new Vector(
                        x - vectorMin.x,
                        y - vectorMin.y,
                        z - vectorMin.z
                );
            }

            //Случайный массив размерностью N
            public static Vector[] generate(int n){
                Vector[] vectors = new Vector[n];
                for(int i =0; i < n; i++){
                    vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
                }
                return vectors;
            }
        }
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
