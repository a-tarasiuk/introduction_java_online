package com.company;

public class Main {

    public static void main(String[] args) {
        int     max = 0, numberMax = 0,
                min = 0, numberMin = 0,
                replase = 0;
        int     N = (int)(Math.random() * 100);          //размер массива
        int     A[] = new int[N];

        //заполнение массива
        for(int i = 0; i < N; i++)
            A[i] = (int)(Math.random() * 200 - 100);

        //печать массива
        for(int i = 0; i < A.length; i++)
            System.out.println("A[" + i + "] = " + A[i]);

        //подсчет
        max = A[0];
        min = A[0];

        for(int i = 0; i < A.length; i++) {

            if(A[i] > max) {
                max = A[i];
                numberMax = i;
            }

            if(A[i] < min) {
                min = A[i];
                numberMin = i;
            }
        }

        System.out.println("Максимальный элемент массива A[" + numberMax + "] = " + max);
        System.out.println("Минимальный элемент массива A[" + numberMin + "] = " + min);

        //замена максимального на минимальный элемент
        replase = A[numberMin];
        A[numberMin] = A[numberMax];
        A[numberMax] = replase;

        //печать массива после замены
        for(int i = 0; i < A.length; i++)
            System.out.println("A[" + i + "] = " + A[i]);

        System.out.println("Минимальный элемент массива после замены A[" + numberMax + "] = " + max);
        System.out.println("Максимальный элемент массива после замены A[" + numberMin + "] = " + min);
    }
}
