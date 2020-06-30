package com.company;

public class Main {

    public static void magicSuare(int n){
        // https://ru.wikipedia.org/wiki/%D0%9C%D0%B0%D0%B3%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82

        System.out.print("Размер магического квадрата: " + n + "\n");
        int[][] array = new int[n][n];

        int     value = 1,
                row = 0,        timeRow = 0,
                column = n / 2, timeColumn = 0;

        while (value <= n * n) {
            array[row][column] = value;
            value++;
            timeRow = row;
            timeColumn = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = n - 1;
            }
            if (column == n) {
                column = 0;
            }
            if (array[row][column] != 0) {
                row = timeRow + 1;
                column = timeColumn;
                if (row == -1) {
                    row = n - 1;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();

        }

        System.out.print("Магическая сумма = " + n*(n*n+1)/2);
    }

    public static void main(String[] args) {
        int n = 0;

        while(true){
            n = (int)(Math.random() * 10);
            if(n > 2 & n % 2 != 0) break;
        }

        magicSuare(n);
    }
}
