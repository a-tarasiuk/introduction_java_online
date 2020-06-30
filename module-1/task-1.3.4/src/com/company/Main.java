package com.company;

public class Main {

    public static void main(String[] args) {
        int x = 1, a = 100;

        /*1 способ*/
        for(int i = 1; i <= 200; i++){
            x *= Math.pow(i, 2);
            //System.out.println("i = " + i + " x = " + x);
        }
        System.out.println("Произведение квадратов первых двухста числел равно: " + x);
    }
}
