package com.company;

public class Main {
    public static int factorial(int number)
    {
        if (number == 0) return 1;
        else if(number % 2 == 0) number--;
        return number * factorial(number-1);
    }

    public static void main(String[] args) {
        int number = 9;
        System.out.println("Факториал нечетных чисел от 1 до " + number + " равен " + factorial(number));
    }
}
