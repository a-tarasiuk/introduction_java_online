package com.company;

public class Main {

    public static void main(String[] args) {
        int     m = 0,                              //кол-во отрицательных элементов
                j = 0,                              //кол-во положительных элементов
                k = 0;                              //кол-во нулевых элементов
        int N = (int)(Math.random() * 100);          //размер массива
        int A[] = new int[N];

        //заполнение массива
        for(int i = 0; i < N; i++) {
            A[i] = (int) (Math.random() * 200 - 100);
            System.out.println("A[" + i + "] = " + A[i]);
        }


        //подсчет
        for(int i = 0; i < N; i++){
            if(A[i] == 0) k++;
            else if(A[i] < 0) m++;
            else if(A[i] > 0) j++;
        }

        System.out.println("Положительных элементов = " + j);
        System.out.println("Отрицательных элементов = " + m);
        System.out.println("Нулевых элементов = " + k);

    }
}
