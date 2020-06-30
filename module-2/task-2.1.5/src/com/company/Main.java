package com.company;

public class Main {

    public static void main(String[] args) {
        int     N = (int)(Math.random() * 100);          //размер массива
        int     A[] = new int[N];

        //заполнение массива
        for(int i = 0; i < N; i++)
            A[i] = (int)(Math.random() * 200 - 100);

        //печать массива
        for(int i = 0; i < A.length; i++)
            if(A[i] > i) System.out.println("A[" + i + "] = " + A[i] + " > " + i);

    }
}
