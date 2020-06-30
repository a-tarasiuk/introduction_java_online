package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int     s1 = (int)(Math.random() * 10),
                s2 = (int)(Math.random() * 10),
                array[][] = new int[s1][s2],
                column1 = 0, column2 = 2;

        System.out.print("s1 (строки) = " + s1 + ";\ts2 (столбцы) = " + s2 + "\n");

        //печать массива
        for(int i = 0; i < s1; i++) {
            for (int j = 0; j < s2; j++) {
                array[i][j] = (int) (Math.random() * 100);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        //ввод столбцов
        Scanner s = new Scanner(System.in);
        System.out.print("Введите номера столбцов, которые необходимо поменять местами.");

        while (true){
            System.out.print("\nВведите номер первого столбца: ");
            column1 = s.nextInt();
            if(column1 <= s2 & column1 > 0) {
                column1--;
                break;
            }
        }

        while (true) {
            System.out.print("Введите номер второго столбца: ");
            column2 = s.nextInt();
            if(column2 != column1 & column2 <= s2 & column2 > 0) {
                column2--;
                break;
            }

        }

        s.close();

        //замена
        for(int i = 0; i < s1; i++){
            array[i][column1] = array[i][column1] + array[i][column2] - (array[i][column2] = array[i][column1]);
        }

        //печать новой
        System.out.print("\nНовая матрица:\n");
        for(int i = 0; i < s1; i++){
            for(int j = 0; j < s2; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
