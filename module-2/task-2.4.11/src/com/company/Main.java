package com.company;

public class Main {
    public static void whoIsBigger(int a, int b){
        int one = a, two = b;
        if(a < 0) one = -a;
        if(b < 0) two = -b;

        while (true){
            one /= 10;
            two /= 10;

            if(one == 0 & two == 0) {
                System.out.println("В числах одинаковое количество цифр.");
                break;
            }
            else if(one == 0) {
                System.out.println("В числе " + b + " больше цифр, чем в числе " + a);
                break;
            }
            else if(two == 0) {
                System.out.println("В числе " + a + " больше цифр, чем в числе " + b);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int     numberOne = (int)(Math.random() * 100000 - 1000000),
                numberTwo = (int)(Math.random() * 100000 - 1000000);

        System.out.println("Число первое: " + numberOne + "\nЧисло второе: " + numberTwo);
        whoIsBigger(numberOne, numberTwo);


    }
}
