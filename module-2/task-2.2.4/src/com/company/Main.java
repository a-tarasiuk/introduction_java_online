package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = (int)(Math.random()*10),
                array[][] = new int[size][size],
                step = 0,
                n = 0;

        System.out.println("size = " + size);
        n = size;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i % 2 == 0) {
                    step++;
                    array[i][j] = step;
                }
                else {
                    array[i][j] = n;
                    n--;
                }
                System.out.print(array[i][j] + "\t");
            }
            step = 0;
            n = size;
            System.out.println();
        }
    }
}
