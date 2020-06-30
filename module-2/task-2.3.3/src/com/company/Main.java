package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = 0, maxElement = 0, indexMaxElement = 0,
                array[];

        while (true){
            size = (int)(Math.random() * 10);
            if(size > 2) {
                array = new int[size];
                break;
            }
        }

        //заполнение массива a
        System.out.print("Массив array[" + size + "]: ");
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*10);
            System.out.print(array[i] + " ");
        }

        //сортировка выбором
        for(int i = 0; i < array.length - 1; i++){
            indexMaxElement = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[indexMaxElement]) indexMaxElement = j;
            }
            array[indexMaxElement] = array[indexMaxElement] + array[i] - (array[i] = array[indexMaxElement]);
        }

        //печать нового массива
        System.out.print("\nОтсортированный массив array[" + size + "]: ");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

    }
}
