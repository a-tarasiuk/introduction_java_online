package com.company;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        double  x = 219.347;
        BigDecimal value = BigDecimal.valueOf((int)x/1000.0 + (x-(int)x) * 1000).setScale(3, BigDecimal.ROUND_DOWN);
        System.out.println(value);
    }
}
