package com.company;

class Test1{
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

    public void sumValues(){
        System.out.println("Сумма значений переменных \"а\" и \"b\": " + (this.a + this.b));
    }

    public void maxOfValues(){
        System.out.print("Из значений переменных \"а\" = " + this.a + " и \"b\" = " + b + " максимальным является ");
        if(a > b) System.out.println("\"a\" = " + a);
        else if(a == b) System.out.println("- значения равны!");
        else System.out.println("\"b\" = " + b);

    }

}

public class Main {

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.setA(5);
        t1.setB(6);
        t1.getValues();
        t1.sumValues();
        t1.maxOfValues();
    }
}
