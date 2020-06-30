package com.company;

public class Main {

    public static void main(String[] args) {
        int     m = 0, n = 0,
                maxElement = 0,
                array[][];

        while (true){
            m = (int)(Math.random()*10);
            n = (int)(Math.random()*10);
            if(m > 2 & n > 2) break;
        }

        array = new int[m][n];

        //заполнение матрицы и поиск максимального элемента
        System.out.println("Исходная матрица: ");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = (int)(Math.random()*10);
                if(array[i][j] > maxElement) {
                    maxElement = array[i][j];
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        //замена нечетных элементов на максимальный элемент
        System.out.println("Измененная матрица: ");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(array[i][j] % 2 != 0) array[i][j] = maxElement;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Максимальный элемент maxElement = " + maxElement);
    }
}
