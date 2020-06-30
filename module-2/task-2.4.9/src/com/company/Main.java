package com.company;

public class Main {
    /*
    Т.к. есть один прямой угол в четырехугольнике, имеем прямоугольный треугольник.
    Шаги:
    1) Найти гипотенузу в прямоугольном треугольнике (один треугольник)
    2) Зная гипотенузу (это будет третья стороно второго треугольника), нати по формуле Герона площадь второго треугольника
    3) Сложить площади двух треугольников
     */

    public static double square(int x, int y, int z, int t){
        double  gipotenyza = 0,
                squareTriangleOne = 0,  //площадь прямоугольного треугольника
                squareTriangleTwo = 0,  //площадь треугольника по формуле Герона
                perimeter = 0;          //полупериметр
        gipotenyza = Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
        squareTriangleOne = (x * y) / 2;

        perimeter = (gipotenyza + z + t) / 2;
        squareTriangleTwo = Math.sqrt(perimeter * (perimeter - z) * (perimeter - t) * (perimeter - gipotenyza));

        return squareTriangleOne + squareTriangleTwo;
    }

    public static void main(String[] args) {
        int     x = 0,
                y = 0,
                z = 0,
                t = 0,
                g = 0; //гипотенуза
        while (true){
            x = (int)(Math.random() * 20);
            y = (int)(Math.random() * 20);
            z = (int)(Math.random() * 20);
            t = (int)(Math.random() * 20);
            if(x != 0 & y != 0 & z != 0 & t != 0) break;
        }

        System.out.println("Стороны четырёхугольника:");
        System.out.println("x = " + x + ", y = " + y + ", z = " + z + ", t = " + t);

        System.out.println("Площадь прямоугольного треугольника: " + square(x, y, z, t));
    }
}
