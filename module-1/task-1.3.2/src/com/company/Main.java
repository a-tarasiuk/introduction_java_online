package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b, h, F, x;

        Scanner in = new Scanner(System.in);
        System.out.println("# Введите диапазон отрезка [a,b]");
        System.out.println("a: ");
        a = in.nextInt();
        System.out.println("b: ");
        b = in.nextInt();
        System.out.println("[OK] Отрезок [" + a + "," + b + "]");
        System.out.println("Введите шаг h: ");
        h = in.nextInt();

        for(x = a; x <= b - h; x += h) {
            System.out.println("x = " + x);
            if(x > 2) {
                F = x;
                System.out.println("F(x) = " + F);
            }
            else {
                F = 0 - x;
                System.out.println("F(x) = " + F);
            }
        }
    }
}
