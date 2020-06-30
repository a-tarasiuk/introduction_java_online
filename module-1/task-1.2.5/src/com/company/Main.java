package com.company;

public class Main {

    public static void main(String[] args) {
        int x, F;

        x = (int) (Math.random()*200 -100);

        if(x <= 3) {
            F = (int) Math.pow(x, 2) - 3*x + 9;
            System.out.println("[x <= 3]\nx = " + x + "\nF(x) = " + F);
        }
        else {
            F = 1 / ((int)Math.pow(x,3) + 6);
            System.out.println("[x > 3]\nx = " + x + "\nF(x) = " + F);
            }
    }
}
