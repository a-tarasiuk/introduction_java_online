package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	/*
        Т.к. в дано не указаны, какие два числа даны (натуральное, действительное), пусть это будут
        натуральные числа
        */

        int a = 0, b = 0;
        String s1, s2;              //сначала целое число int преобразуем в строку String

        char[] array1, array2;      //массив для хранения первого и второго чисел соответственно
        ArrayList<Character> array = new ArrayList<Character>();

        //задаем рандомно a и b
        //a = (int)(Math.random() * 1000000);
        //b = (int)(Math.random() * 1000000);
        a = 1030450789;
        b = 1054444444;
        System.out.println("Число a = " + a);
        System.out.println("Число b = " + b);

        //преобразуем int в string
        //valueOf(int i) — возвращает строковое представление int аргумента.
        s1 = String.valueOf(a);
        s2 = String.valueOf(b);

        //заполняем массивы типа char для хранения чисел
        array1 = s1.toCharArray();
        array2 = s2.toCharArray();

        /*
        //печать массивов (проверка)
        for(int i = 0; i < array1.length; i++)
            System.out.println(array1[i]);

        for(int i = 0; i < array2.length; i++)
            System.out.println(array2[i]);
        */
        array.add(' ');

        for(int i = 0; i < array1.length; i++) {

            //System.out.println("- Проверяем цифру " + array1[i]);
            for (int k = 0; k < array2.length; k++) {
                if (array1[i] == array2[k]) {   //если есть цифра в первом числе такая же, как и во втором, то добавим её в array
                    array.add(array1[i]);
                    break;
                }
            }
        }

        System.out.println("------------------------------");

        //ищем повторяющиеся символы в array и удаляем их
        for(int i = 0; i < array.size(); i++) {
            for(int j = i+1; j < array.size(); j++)
                if(array.get(i) == array.get(j)) array.remove(j);
        }

        //выводим на печать содержимое array
        for(Character x : array)
            System.out.println(x);

        System.out.println("------------------------------");
    }
}
