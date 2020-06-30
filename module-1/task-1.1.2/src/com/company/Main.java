package com.company;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Main {

    public static void main(String[] args) {
        double  a = 2.00,
                b = 3.00,
                c = 4.00;

        System.out.println((b + sqrt(pow(b, 2.00) + 4 * a * c)) / (2 * a) - pow(a, 3.00) * c + pow(b, -2.00));
    }
}
