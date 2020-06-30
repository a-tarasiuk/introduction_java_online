package com.company;

public class Main {
    //наименьшее общее кратное двух чисел
    public static int NOK(int a, int b){
        return Math.abs(a * b) / NOD(a, b);
    }

    //наибольший общий делитель
    public static int NOD(int a, int b){
        if(b < 0) b = -b;
        if(a < 0) a = -a;

        while (b > 0){
            int swap = b;
            b = a % b;
            a = swap;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 0, b = 0;
        while (true){
            a = (int)(Math.random() * 20);
            b = (int)(Math.random() * 20);
            if(a > 0 & b > 0) break;
        }
        System.out.println("Наибольший общий делитель чисел " + a + " и " + b + " равняется "  + NOD(a,b));
        System.out.println("Наименьшее общее кратное чисел " + a + " и " + b + " равняется "  + NOK(a,b));
    }
}
