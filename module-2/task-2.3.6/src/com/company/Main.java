package com.company;

public class Main {
    public static void getArray(int[] mass){
        System.out.println("Исходный массив:");
        for(int i = 0; i < mass.length; i++){
            mass[i] = (int)(Math.random() * 10);
            System.out.print(mass[i] + " ");
        }
    }

    public static void sortArray(int[] mass){
        int step = mass.length / 2;
        while (step > 0) {
            for (int i = 0; i < mass.length - step; i++) {
                int j = i;  //будем идти начиная с i-элемента
                while (j >= 0 && mass[j] > mass[j + step]) {  //пока не пришли к началу массива и пока начальный элемент (позиция i) больше элемента на позиции (i+step)
                    mass[j] = mass[j] + mass[j+step] - (mass[j+step] = mass[j]);//меняем их местами
                    j--;    //сдвигаемся на один элемент назад
                }
            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int     //size = (int)(Math.random() * 15),
                size = 10,
                array[] = new int[size];

        //заполняем массив
        getArray(array);
        //сортируем массив
        sortArray(array);
        System.out.println("\nМассив после сортировки:");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
