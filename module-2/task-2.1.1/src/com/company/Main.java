package com.company;

public class Main {

    public static void main(String[] args) {
        int N = 0, K = 0, SUM = 0;

        N = (int)(Math.random() * 100);
        K = (int)(Math.random() * 10);

        System.out.println("Число K = " + K + "\nРазмер массива - A[" + N + "]\n");

        int[] A = new int[N];

        //заполняем массив
        for(int i = 0; i < N; i++) {
            A[i] = (int) (Math.random() * 100);
        }

        //находим кратные элементы
        for(int i = 0; i < N; i++) {
            if(A[i] %K == 0) {
                System.out.println("[+] Число " + A[i] + " делится на " + K + " без остатка.");
                SUM += A[i];
            }
            else System.out.println("Число " + A[i] + " НЕ делится на " + K + " без остатка.");
        }

        System.out.println("\nSUM = " + SUM);
    }
}
