package test;
/*
Выпуклый многоугольник задан на плоскости перечислением координат вершин в порядке обхода его границы.
Определить площадь многоугольника. Задаются сначала количество точке n, далее для каждой точки вводится x, а потом
y координата. Площадь округлять до десятых (один разряд после запяток)
        Например
        Входные данные:
        3
        1
        6
        2
        4
        3
        5 (т.е. получаем треугольник с координатами (1;6) (2;4) (3;5)
        Выходные: 1.5
*/

import java.util.Scanner;

public class PolygonArea {
    public static void main(String[] args) {
        System.out.println("Conors:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] x;
        x = new float[n + 1];
        float[] y;
        y = new float[n + 1];
        double S = 0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextFloat();
            y[i] = sc.nextFloat();
        }
        x[n] = x[0];
        y[n] = y[0];
        for (int i = 0; i < n; i++) {
            S += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        ;
        S = 0.5 * Math.abs(S);
        System.out.printf("S = %.1f", S);
    }
}