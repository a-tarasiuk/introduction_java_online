package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//НЕ ТОЧНО, ЛУЧШЕ ПЕРЕДЕЛАТЬ

public class Main {
    //заполняем элементами
    public static void getElements(List<Integer> list, int size){
        //заполняем
        for(int i = 0; i < size; i++)
            list.add((int) (Math.random() * 10));
    }

    //сортируем элементы (пузырьковая сортировка)
    public static void bubbleSorter(List<Integer> list){
        int indexMaxElement = 0, swap = 0;
        for(int i = 0; i < list.size() - 1; i++){
            indexMaxElement = i;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) < list.get(indexMaxElement)) indexMaxElement = j;
            }
            swap = list.get(i);
            list.set(i, list.get(indexMaxElement));
            list.set(indexMaxElement, swap);
        }
    }

    public static List<Integer> middleIndex(List<Integer> in, List<Integer> from) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < from.size(); i++) {
            int middle = Collections.binarySearch(in, from.get(i));
            if (middle < 0) result.add(-(middle + 1) + i);
            else result.add(middle + i);
        }
        return result;
    }

    public static void main(String[] args) {
        int     sizeArrayOne = 0,
                sizeArrayTwo = 0;

        while (true){
            sizeArrayOne = (int)(Math.random()*10);
            sizeArrayTwo = (int)(Math.random()*10);
            if(sizeArrayOne > 2 & sizeArrayTwo > 2) {
                System.out.println("sizeArrayOne = " + sizeArrayOne);
                System.out.println("sizeArrayTwo = " + sizeArrayTwo);
                break;
            }
        }

        List<Integer> in = new ArrayList<Integer>();
        List<Integer> from = new ArrayList<Integer>();

        getElements(in, sizeArrayOne);
        getElements(from, sizeArrayTwo);

        System.out.println("\nЗаполненный массив in:");
        for(int i = 0; i < in.size(); i++)
            System.out.print(in.get(i) + " ");
        System.out.println("\nЗаполненный массив from:");
        for(int i = 0; i < from .size(); i++)
            System.out.print(from.get(i) + " ");

        bubbleSorter(in);
        bubbleSorter(from);

        System.out.println("\nСортированный массив in:");
        for(int i = 0; i < in.size(); i++)
            System.out.print(in.get(i) + " ");
        System.out.println("\nСортированный массив from:");
        for(int i = 0; i < from .size(); i++)
            System.out.print(from.get(i) + " ");

        List<Integer> indexes = middleIndex(in, from);
        System.out.println("\nИндексы для вставки: " + indexes);

        for (int i = 0; i < indexes.size(); i++)  in.add(indexes.get(i), from.get(i));
        System.out.println("Конечный массив после объединения: "+ in);
    }
}