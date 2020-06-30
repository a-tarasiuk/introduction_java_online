package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = (int)(Math.random()*10),
                array[][] = new int[size][size],
                k = 0,  //строка
                p = 0;  //столбец

        while(true){
            k = (int)(Math.random()*10);
            p = (int)(Math.random()*10);
            if(k < size & p < size) break;
        }

        System.out.println("size = " + size);
        System.out.println("k (строка) = " + k);
        System.out.println("p (столбец) = " + p);

        System.out.println("\nИсходный массив:");
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 100);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nk[" + k + "] (строка): ");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[k][i] + " ");

        System.out.print("\np[" + p + "] (столбец): ");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i][p] + " ");


    }
}
