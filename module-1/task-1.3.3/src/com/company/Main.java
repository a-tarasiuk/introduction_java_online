package com.company;

public class Main {

    public static void main(String[] args) {
        int x = 0, a = 100;

        /*1 способ*/
        for(int i = 0; i <= 100; i++){
            x += Math.pow(i, 2);
            //System.out.println("x = " + x);
        }
        System.out.println("Сумма квадратов первых ста числел равна: " + x);

        /*2 способ*/
        x = (a * (a+1) * (2 * a + 1)) / 6;
        System.out.println("Сумма квадратов первых ста числел равна: " + x);
    }
}
