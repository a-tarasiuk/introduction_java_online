package com.company;

class Numbers{
    private int numberOfSigns = 0,       //количество знаков в числе
                degreeOfStart = 0,       //степень числа
                degreeOfEnd = 0,        //степень числа
                swap = 0, temp = 0,
                cout = 0,               //счетчик для количества четных цифр в сумме
                sum = 0;                //сумма чисел, содержащих в себе только нечетные цифры

    //конструктор
    public Numbers(){
        while (true){
            numberOfSigns = (int)(Math.random() * 9);   //почему 9? Потому, что Integer.MAX_VALUE = 2147483647, что составляет 10 знаков
            if(numberOfSigns != 0) break;
        }
        System.out.println("Количество знаков в числе: " + numberOfSigns);
    }

    //проверка цифр числа на четность\нечетность
    public boolean check(int a){
        while (a > 0){
            if((a % 10) % 2 == 0) return false; // число содержит в себе четную цифру, значит не подходит
            a /= 10;
        }
        return true;    //число содержит только нечетное цифры
    }

    public void getNumbers(){
        degreeOfStart = (int)(Math.pow(10, numberOfSigns - 1));
        degreeOfEnd = (int)(Math.pow(10, numberOfSigns));

        for(int i = degreeOfStart; i < degreeOfEnd; i++){
            if(check(i)) {
                System.out.println("Число " + i + " содержит в себе только нечетные циры.");
                sum += i;
            }
        }
    }

    //сколько четных цифр в числе
    public void howManyEvenDigits(int b){
        cout = 0;
        temp = b;
        while (temp > 0){
            if((temp % 10) % 2 == 0) cout++;
            temp /= 10;
        }
        System.out.println("В числе " + b + " содержится " + cout + " четных(ая) цифр(а).");
    }

    public int getSum(){
        return sum;
    }

    public int getNumberOfSigns(){
        return numberOfSigns;
    }

}

public class Main {

    public static void main(String[] args) {
        Numbers n = new Numbers();
        n.getNumbers();
        System.out.println("\nСумма " + n.getNumberOfSigns() + "-значных чисел, содержащих в себе нечетные цифры равна: " + n.getSum());
        n.howManyEvenDigits(n.getSum());
    }
}
