package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = (int)(Math.random()*20),
                pozitive = 0;
        double array[][] = new double[size][size];

        System.out.print("size = " + size + "\n");

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                array[i][j] = Math.sin( (Math.pow(i,2) - Math.pow(j,2)) / 2);
                if(array[i][j] > 0) pozitive++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nПоложительных элементов: " + pozitive);
    }
}
