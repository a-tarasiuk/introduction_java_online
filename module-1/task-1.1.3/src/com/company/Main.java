package com.company;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        double  x = 2.00,
                y = 3.00;

        System.out.println( ((sin(x)+cos(y))/(cos(x)-sin(y))) * tan(x) * y );
    }
}
