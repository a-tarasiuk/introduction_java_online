package com.company;
class Armstrong{
    private int maxValue = 0,
                duplicateValue = 0,
                size = 0,
                numberArmstrong = 0,
                array[];

    // задание максимального числа k (maxValue)
    public void setMaxValue(){
        while (true){
            maxValue = (int)(Math.random() * Integer.MAX_VALUE);
            if(maxValue > 2) break;
        }
    }

    //метод для создания массива с количеством цифр в числе
    public void getArray(int number) {
        array = new int[getSizeArray(number)];
    }

    // метод для получения количества цифр в числе
    public int getSizeArray(int value) {
        size = 0;
        //узнаем, сколько цифр в числе, чтобы создать массив, размер которого равен количеству цифр в числе
        while (value > 0) {
            value /= 10;
            size++;
        }
        return size;
    }

    //метод для занесения цифр числа, возведенные в степень, в массив
    public void insertNumberInArray(int number) {
        if(number == 0) return; //0 не будет являться числом Армстронга
        numberArmstrong = 0;
        duplicateValue = number;
        getArray(number);
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)Math.pow(duplicateValue % 10, array.length);
            numberArmstrong += array[i];
            duplicateValue /= 10;
        }

        if(isTheNumberOfArmstrong(numberArmstrong, number)) System.out.println("Число " + number + " является числом Армстронга.");
    }

    //проверка, является ли число, числом Армстронга
    //a - число, возведенное в степень
    //b - исходное число
    public boolean isTheNumberOfArmstrong(int a, int b){
        if(a == b) return true;
        else return false;

    }

    public int getMaxValue(){
        return maxValue;
    }

}

public class Main {

    public static void main(String[] args) {
        Armstrong arm = new Armstrong();
        arm.setMaxValue();

        System.out.println("Число предел - " + arm.getMaxValue());

        for(int i = 0; i < arm.getMaxValue(); i++)
            arm.insertNumberInArray(i);
    }
}
