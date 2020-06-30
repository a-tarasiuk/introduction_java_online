package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * На системе координат имеется два прямоугольника.
 * Прямоугольник А, вершины имеют координаты:
 * А1(-2,0)
 * A2(-2,4)
 * A3(2,4)
 * A4(2,0)
 *
 * Прямоугольник В, вершины имеют координаты:
 * B1(4,0)
 * B2(4,-3)
 * B3(-3,-4)
 * B4(-4,0)
 *
 * Решение:
 * Берем левую нижнюю точку и правую верхнюю точку обоих прямоугольников и сравниваем введенные пользователем Х и У.
 *
 */

public class Figure {
    // Прямоугольник А
    private int x1 = -2,    y1 = 0,
                x2 = 2,     y2 = 4;

    // Прямоугольник В
    private int x3 = -3,    y3 = -4,
                x4 = 4,     y4 = 0;

    public Figure(){
        System.out.println("Welcome to the app!");
    }

    public void start(){
        int x, y;

        while (true) {
            try {
                System.out.print("\nEnter point \"X\": ");
                x = new Scanner(System.in).nextInt();
                System.out.print("\nEnter point \"Y\": ");
                y = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("\nWrong value! Try again!");
            }
        }

        System.out.println(isInside(x,y));
    }

    // точка принадлежит обоим прямоугольникам
    private boolean isInside(int x, int y){
        return isInsideA(x, y) || isInsideB(x, y);
    }

    // точка входит в прямоугольник А
    private boolean isInsideA(int x, int y){
        return (x >= x1) && (x <= x2) && (y >= y1) && (y <= y2);
    }

    // точка входит в прямоугольник В
    private boolean isInsideB(int x, int y){
        return (x >= x3) && (x <= x4) && (y >= y3) && (y <= y4);
    }
}
