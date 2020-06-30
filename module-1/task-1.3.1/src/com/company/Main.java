package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum, x = 0;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("\nВведите целое положительное число: ");
            sum = 0;
            x = in.nextInt();

            if (x > 0) {
                for (int i = 1; i <= x; i++) {
                    sum += i;
                }
                System.out.println("Сумма чисел в промежутке [1:" + x + "] равна: " + sum);
            } else {
                System.out.println("[Error] Введите целое положительное число!");
            }
        }
    }
}
