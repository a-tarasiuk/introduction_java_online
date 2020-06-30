package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = 0,
                summa = 0,
                array[][];

        while (true) {
            size = (int) (Math.random() * 10);
            if (size > 1) break;
        }

        array = new int[size][size];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                summa =+ (array[i][j] = (int)(Math.random() * 10 - 5));
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        for(int i = 0; i < array.length; i++)
            if(array[i][i] > 0) System.out.println("Положительный эелемент главной диагонали равен " + array[i][i]);

    }
}
