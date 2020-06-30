package com.company;

public class Main {

    public static void main(String[] args) {
        // Если три точки A, B и C лежат на одной прямой, то треугольник ABC обратится в отрезок прямой, а потому его площадь должна быть равна нулю.
        // Значит S = 0. Следовательно получим условие, при котором три точки лежат на одной прямой:
        // (x1 - x3)(y2 - y3) - (x2 - x3)(y1 - y3) = 0

        int x1, y1, x2, y2, x3, y3;

        while (true) {
            x1 = (int) (Math.random() * 100 - 100); //генерация числа в диапазоне [-100; 100]
            y1 = (int) (Math.random() * 100 - 100);
            x2 = (int) (Math.random() * 100 - 100);
            y2 = (int) (Math.random() * 100 - 100);
            x3 = (int) (Math.random() * 100 - 100);
            y3 = (int) (Math.random() * 100 - 100);

            System.out.println("\nТочка А(" + x1 + ":" + y1 + ")");
            System.out.println("Точка B(" + x2 + ":" + y2 + ")");
            System.out.println("Точка C(" + x3 + ":" + y3 + ")");

            if ((((x1 - x3) * (y2 - y3)) - ((x2 - x3) * (y1 - y3))) == 0) {
                System.out.println("Точки лежат на одной прямой!");
                break;
            }
            else System.out.println("Точки НЕ лежат на одной прямой!");
        }
    }
}
