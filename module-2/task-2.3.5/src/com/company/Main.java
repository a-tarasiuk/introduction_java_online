package com.company;

public class Main {

    //заполнение массива
    public static void getArray (int[] mass){
        System.out.print("Исходный массив [" + mass.length + "]:\n");
        for(int i = 0; i < mass.length; i++){
            mass[i] = (int)(Math.random() * 10);
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }

    //сортировка методом вставки
    public static void insertBinarySearch(int[] mass){
        int element = 0,     //элемент, который будем переставлять
            left = 0,       //левая граница массива
            right = 0,      //правая граница массива
            middle = 0;     //середина

        for(int i = 1; i < mass.length; i++){
            if(mass[i-1] > mass[i]){
                element = mass[i];
                left = 0;
                right = i-1;
                do{
                    middle = left + (right - left) / 2; //ищем середину
                    if(mass[middle] < element) left = middle + 1;   //сдвигаем границу до тех пор, пока левая граница не будет равна правой. При этом условии вставляется element
                    else right = middle - 1;
                }
                while (left <= right); //ищем, пока левая граница не будет равна правой

                for(int j = i-1; j >= left; j--) mass[j+1] = mass[j];
                mass[left] = element;
            }
        }
    }

    public static void main(String[] args) {
        int     size = 0,
                array[];

        while(true){
            size = (int)(Math.random()*10);
            if(size > 2) {
                array = new int[size];
                break;
            }
        }

        getArray(array);
        insertBinarySearch(array);

        System.out.println("\nОтсортированный массив:");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
