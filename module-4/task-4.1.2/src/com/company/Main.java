package com.company;

class Test2{
    private int a = 0;
    private int b = 0;

    public void getValues(){
        System.out.println("Значение переменной \"a\" = " + a + "\nЗначение переменной \"b\" = " + b);
    }

    public void setA(int value){
        this.a = value;
    }

    public void setB(int value){
        this.b = value;
    }

    public void getA(){
        System.out.println("Значение переменной \"a\" = " + a);
    }

    public void getB(){
        System.out.println("Значение переменной \"b\" = " + b);
    }

    Test2(){
        System.out.println("Конструктор по умолчанию запущен.");
        this.a = 10;
        this.b = 20;
    }

    Test2(int setValueA, int setValueB){
        System.out.println("Конструктор со значениями запущен.");
        this.a = setValueA;
        this.b = setValueB;
    }
}

public class Main {

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.getValues();
        t2.setA(3);
        t2.setB(5);
        t2.getA();
        t2.getB();

        t2 = new Test2(55, 88);
        t2.getValues();

        t2 = new Test2(100, 100);
        t2.getValues();
    }
}
