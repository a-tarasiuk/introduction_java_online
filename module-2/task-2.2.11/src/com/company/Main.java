package com.company;

public class Main {

    public static void main(String[] args) {
        int     array[][] = new int[10][20],
                number = 0;

        //заполнение матрицы
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                array[i][j] = (int)(0 + Math.random()*16);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        //нахождение строк
        for(int i = 0; i < 10; i++){
            number = 0;
            for(int j = 0; j < 20; j++){
                if(array[i][j] == 5)
                    number++;
            }
            if (number >= 3)
                System.out.println("В строке [" + i + "] число 5 встречается 3 и\\или более раз");
        }

    }
}
