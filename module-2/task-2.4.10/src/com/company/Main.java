package com.company;

public class Main {
    public static void getArray(int[] array, int n){
        for(int i = 0; i < array.length; i++){
            array[i] = n % 10;
            System.out.println("array[" + i + "] = " + array[i]);
            n /= 10;
        }
    }

    public static void main(String[] args) {
        int     n = (int)(Math.random() * 100000 - 1000000), number = 0,
                cout = 0,
                array[];
        System.out.println("Дано число: " + n);

        //проверка на отрицательность
        if(n < 0) n = -n;
        number = n;

        //узнаем, какого размера массив создавать (он равен количеству цифр в числе)
        while (number > 0){
            number /= 10;
            cout++;
        }
        System.out.println("В котором содержится " + cout + " символа(-ов)");

        array = new int[cout];
        getArray(array, n);
    }
}
