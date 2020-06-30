package com.company;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

class Triangle{
    private Point a;
    private Point b;
    private Point c;

    private double  sideAB              = 0,        //длина стороны АВ
                    sideAC              = 0,        //длина стороны АС
                    sideBC              = 0;        //длина стороны ВС
    private double  middleSideAB_X      = 0,        //координаты середины прямой АВ по оси Х
                    middleSideAB_Y      = 0,        //координаты середины прямой АВ по оси У
                    middleX             = 0,
                    middleY             = 0;

    //расстояние между двумя точками на плоскости
    public double getSide(Point first, Point second){
        return first.distanceBetweenPoints(second);
    }

    //вычисление периметра
    public double getPerimeter(){
        return sideAB + sideBC + sideAC;
    }

    //вычисление площади
    public double getSquare(){
        return Math.sqrt(getPerimeter() * (getPerimeter() - sideAB) * (getPerimeter() - sideAC) * (getPerimeter() - sideBC));
    }

    //точка пересечения медиан треугольника - делит каждую медиану в отношении 2:1, считая от вершины.
    public void getMedianIntersectionPoints(){
        //нам нужно знать середину основания треугольника вершины, из которой будем вести медиану
        middleSideAB_X = (a.getX() + b.getX()) / 2d;
        middleSideAB_Y = (a.getY() + b.getY()) / 2d;

        //далее применяем уравнение, для нахождения координаты пересечения медиан
        middleX = (c.getX() + 2 * middleSideAB_X) / 3d;
        middleY = (c.getY() + 2 * middleSideAB_Y) / 3d;
    }

    //вывод полной информации
    public void getAllInformationAboutTringle(){
        System.out.println(
                "Точка А(" + a.getX() + ":" + a.getY() + ")\n" +
                "Точка B(" + b.getX() + ":" + b.getY() + ")\n" +
                "Точка C(" + c.getX() + ":" + c.getY() + ")\n" +
                "Длина отрезка АВ: " + sideAB + "\n" +
                "Длина отрезка АС: " + sideAC + "\n" +
                "Длина отрезка ВС: " + sideBC + "\n" +
                "Середина отрезка AB имеет координаты (" + middleSideAB_X + ":" + middleSideAB_Y + ")\n" +
                "Медиана имеет координаты (" + middleX + ":" + middleY + ")\n" +
                "Периметр треугольника: " + getPerimeter() + "\n" +
                "Площадь треугольника: " + getSquare());
    }

    private void checkPointsNull(Point a, Point b, Point c) throws NullPointerException{
        if(a == null || b == null || c == null) throw new NullPointerException("Объект не может быть null.");
        if(getSide(a,b) * getSide(a,c) * getSide(b,c) == 0  ||
                a.getX() == b.getX() && b.getX() == a.getY() && a.getY() == b.getY() ||
                a.getX() == c.getX() && c.getX() == a.getY() && a.getY() == c.getY() ||
                b.getX() == c.getX() && c.getX() == b.getY() && b.getY() == c.getY())
            throw new NullPointerException("Треугольник не может быть создан с данными координатами:\n" +
                    "Точка А(" + a.getX() + ":" + a.getY() + ");\n" +
                    "Точка B(" + b.getX() + ":" + b.getY() + ");\n" +
                    "Точка C(" + c.getX() + ":" + c.getY() + ").");
        else {
            sideAB = getSide(a,b);
            sideAC = getSide(a,c);
            sideBC = getSide(b,c);
        }
    }

    Triangle(Point a, Point b, Point c){
        checkPointsNull(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
        getMedianIntersectionPoints();
    }

}

class Point{
    private final int   x,                      //координаты точки на плоскости Х
                        y;                      //координаты точки на плоскости Y

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    //получить длину отрезка (сторона треугольника) между двумя точками
    public double distanceBetweenPoints(Point point){
        return Math.sqrt( Math.pow(point.getX() - getX(), 2) + Math.pow(point.getY() - getY(), 2) );
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void getMessageWelcome(){
        System.out.println(
            "Создать треугольник:\n" +
            "0. Выход\n" +
            "1. Автоматически\n" +
            "2. Вручную");
    }

    public static void getMessageYourChoice(){
        System.out.print("\nВаш выбор: ");
    }

    public static void getMessageWrongChoice(){
        System.out.println("Неверный выбор. Повторите ввод!");
    }

    public static void switchCase(int choice, Scanner scanner){
        if(choice < 0 || choice > 2) getMessageWrongChoice();
        else {
            switch (choice){
                case 0: case0(); break;
                case 1: case1(); break;
                case 2: case2(scanner); break;
            }
        }
    }

    public static void case0(){
    }

    public static void case1(){
        Point a = new Point( (int)(Math.random() * 10), (int)(Math.random() * 10) );
        Point b = new Point( (int)(Math.random() * 10), (int)(Math.random() * 10) );
        Point c = new Point( (int)(Math.random() * 10), (int)(Math.random() * 10) );
        new Triangle(a, b, c).getAllInformationAboutTringle();
    }

    public static void case2(Scanner scanner){
        System.out.println("Введите координаты точки А:");
        Point a = new Point(getX(scanner), getY(scanner));
        System.out.println("Введите координаты точки В:");
        Point b = new Point(getX(scanner), getY(scanner));
        System.out.println("Введите координаты точки С:");
        Point c = new Point(getX(scanner), getY(scanner));
        new Triangle(a, b, c).getAllInformationAboutTringle();
    }

    public static int getX(Scanner scanner){
        System.out.print(" - ось Х: ");
        return scanner.nextInt();
    }

    public static int getY(Scanner scanner){
        System.out.print(" - ось Y: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) throws NullPointerException {
        int choice;
        getMessageWelcome();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                getMessageYourChoice();
                choice = scanner.nextInt();
                if(choice == 0) break;
                else switchCase(choice, scanner);
            } catch (NullPointerException n){
                System.out.println(n.getMessage());
                }
        }
    }
}
