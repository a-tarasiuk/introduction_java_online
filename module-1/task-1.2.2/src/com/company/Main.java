package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0, result;
        a = (int)(Math.random() * 1000);
        b = (int)(Math.random() * 1000);
        c = (int)(Math.random() * 1000);
        d = (int)(Math.random() * 1000);

        result = max(a, b, c, d);
        System.out.println("a = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d + "\nРезультат = " + result);
    }


    static int minAB(int a, int b){
        if (a < b)
            return a;
        else return b;
    }

    static int minCD(int c, int d){
        if (c < d)
            return c;
        else return d;
    }

    static int max(int a, int b, int c, int d) {
        if (minAB(a,b) > minCD(c,d))
            return minAB(a,b);
        else    return minCD(c,d);
    }
}
