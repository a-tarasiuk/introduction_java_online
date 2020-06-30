package com.company;

public class Main {

    public static void main(String[] args) {
        int     sizeA = 0, sizeB = 0,
                a[], b[];

        while (true){
            sizeA = (int)(Math.random() * 10);
            sizeB = (int)(Math.random() * 10);
            if(sizeA > 2 & sizeB > 2) {
                a = new int[sizeA];
                b = new int[sizeB];
                break;
            }
        }

        //заполнение массива a
        System.out.print("Массив a[" + sizeA + "]: ");
        for(int i = 0; i < a.length; i++){
            a[i] = (int)(Math.random()*10);
            System.out.print(a[i] + " ");
        }

        //заполнение массива b
        System.out.print("\nМассив b[" + sizeB + "]: ");
        for(int i = 0; i < b.length; i++){
            b[i] = (int)(Math.random()*10);
            System.out.print(b[i] + " ");
        }

        //пузырьковая сортировка a
        for(int i = a.length - 1; i >= 1; i--)
            for(int j = 0; j < i; j++)
                if(a[i] < a[j])
                    a[i] = a[i] + a[j] - (a[j] = a[i]);

        //пузырьковая сортировка b
        for(int i = b.length - 1; i >= 1; i--)
            for(int j = 0; j < i; j++)
                if(b[i] < b[j])
                    b[i] = b[i] + b[j] - (b[j] = b[i]);

        //вывод массива после сорировки
        System.out.print("\nМассив после сортировки:\n");
        System.out.print("Массив a[" + sizeA + "]: ");
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.print("\nМассив b[" + sizeB + "]: ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");

    }
}
