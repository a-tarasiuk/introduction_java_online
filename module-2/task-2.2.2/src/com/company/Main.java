package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = (int)(Math.random()*10),
                array[][] = new int[size][size];
        System.out.println("Исходный размер:");
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int)(Math.random()*100);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Элементы по диагонали:");
        for(int i = 0; i < array.length; i++)
                System.out.print(array[i][i] + "\t");

    }
}
