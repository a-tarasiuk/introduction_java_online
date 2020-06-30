package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    /*
        Функция Math.sigmun() возвращает:
        0       - если аргумент равен ноль
        1.0     - если аргумент больше нуля
        -1.0    - если аргумент меньше нуля
        Функция Math.signum() принимает только значение float или double, поэтому ниже происходит преобразование
        типа int в тип double
         */

        int m = 0, n = 0;
        System.out.println("Введите натуральные числа в промежутке [m, n].");

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("Введите m: ");
            m = in.nextInt();
            if (Math.signum((float) m) > 0) break;
            else System.out.println("[ОШИБКА] m не может быть отрицательным!");
        }

        while(true) {
            System.out.print("Введите n: ");
            n = in.nextInt();
            if (Math.signum((float) n) < 0)
                System.out.println("[ОШИБКА] n не может быть отрицательным!");
            else if(n <= m)
                System.out.println("[ОШИБКА] n не может быть меньше либо равно m!");
            else break;
        }

        for(int i = m; i <= n; i++){
            for(int x = 2; x < i; x++)
                if((i % x) == 0) System.out.println("Число " + i + " делится на " + x + " без остатка!");
        }
    }
}
