package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;    //углы треугольника

        while(true) {

            //генерируем уголы, которые не могут быть больше 180 градусов
            a = (int) (Math.random() * 180);
            b = (int) (Math.random() * 180);
            c = (int) (Math.random() * 180);

            //сумма всех углов треугольника равна 180 градусов. Проверяем это условие:
            if ((a + b + c) == 180) {
                System.out.println("Треугольник с углами:");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println("c = " + c);
                System.out.println("Существует!");

                //Проверяем, прямоугольный ли это треугольник:
                if(a == 90 | b == 90 | c == 90) {
                    System.out.println("# Треугольник прямоугольный!");
                    break;
                }
                else System.out.println("# Треугольник НЕ прямоугольный!\n");
            }
        }
    }
}
