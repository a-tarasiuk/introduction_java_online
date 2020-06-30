package com.company;

public class Main {

    public static void main(String[] args) {
        int     size = 0,
                summa = 0, maxSumma = 0, maxColumn = 0;

        while (true){
            size = (int)(Math.random()*10);
            if(size > 1) break;
        }

        int array[][] = new int[size][size];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                array[i][j] = (int)(Math.random() * 100);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                summa =+ array[j][i];
            }
            if(summa > maxSumma) {
                maxSumma = summa;
                maxColumn = i;
            }
            System.out.println("Сумма [" + i + "] столбца = " + summa);
        }

        System.out.print("Максимальная сумма = " + maxSumma + " в [" + maxColumn + "] столбце.");
    }
}
