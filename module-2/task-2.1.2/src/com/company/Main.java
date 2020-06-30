package com.company;

public class Main {

    public static void main(String[] args) {
        int kol = 0;                                //количество замен
        int Z = (int)(Math.random() * 200 - 100);   //рандомное число
        int N = (int)(Math.random() * 100);          //размер массива
        int A[] = new int[N];

        //заполнение массива
        for(int i = 0; i < N; i++)
            A[i] = (int)(Math.random() * 200 - 100);

        for(int i = 0; i < N; i++)
            if(A[i] > Z) {
                A[i] = Z;
                kol++;
            }

        System.out.println("Количество замен = " + kol);
    }
}
