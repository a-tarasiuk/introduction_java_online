package com.company;

public class Main {

    public static void main(String[] args) {
        int size = 0, step = 1;

        while(true){
            size = (int)(Math.random()*10);
            if(size % 2 == 0) break;
        }

        int array[][] = new int[size][size];

        System.out.println("size = " + size + "; array.lenght = " + array.length);

        //заполнение массива
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < size; j++){
                array[i][j] = step;
            }
            size--;
            step++;
        }

        //печать массива
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }



    }
}
