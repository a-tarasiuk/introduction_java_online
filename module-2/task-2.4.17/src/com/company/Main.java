package com.company;

class Number{
    private int number = 0,         //исходное число
                sumOfDigits = 0,    //сумма цифр числа
                swap = 0,
                cout = 0,           //количество вычитаний
                result = 0;

    public Number(){
        number = (int)(Math.random() * 100);
    }

    public void setSumOfDigits(){
        sumOfDigits = 0;
        swap = number;
        while (swap > 0){
            sumOfDigits += swap % 10;
            swap /= 10;
        }
    }

    public int deduction(int i){
        result = 0;
        cout = 0;
        while (i > 0) {
            /*
            По заданию:
            "Сколько действий нужно произвести, чтобы получился нуль?"
            Но:
            Может получиться и так, что на последнем вычитании получится отрицательное число.

            Т.к. в условии про это не сказано, сделаю так:

                Допустим число number = 62. Вычитаться будет сумма цифр, т.е. 8.
                На 7 шаге будет действие:
                6 - 8, т.е. получится отрицательный ответ (-2). На этом шаге и прекращаем вычитание

            if((i - getSumOfDigits()) < 0) {
                System.out.println("\nОстаток числа: " + i);
                return cout;
            }
            */

            result = i - deduction(i - getSumOfDigits());
            cout++;
            //System.out.println("result = " + result + ", cout = " + cout);
            return cout;
        }
        System.out.println("\nОстаток числа: " + i);
        return cout;
    }

    public int getNumber(){
        return number;
    }

    public int getSumOfDigits(){
        return sumOfDigits;
    }
}

public class Main {

    public static void main(String[] args) {
        Number n = new Number();
        n.setSumOfDigits();
        System.out.println("Исходное число: " + n.getNumber() + ", сумма цифр: " + n.getSumOfDigits());
        System.out.println("Количество вычетаний: " + n.deduction(n.getNumber()));
    }
}
