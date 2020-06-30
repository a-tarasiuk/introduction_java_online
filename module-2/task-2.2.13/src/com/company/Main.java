package com.company;

public class Main {
    public static void main(String[] args) {
        int     size = 0,
                array[][],
                temp = 0;

        while (true){
            size = (int)(Math.random() * 10);
            if(size > 2) break;
        }

        array = new int[size][size];
        //-----------------------------------------------------------
        System.out.println("Исходная матрица:");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                array[i][j] = (int)(Math.random()*20);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        //-----------------------------------------------------------
        System.out.println("\nСортировка по столбцам по возрастанию:\n");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                arrayUp(array);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        //-----------------------------------------------------------
        System.out.println("\nСортировка по столбцам по убыванию:\n");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                arrayDown(array);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        //-----------------------------------------------------------
    }

    //-----------------------------------------------------------
    private static int[][] arrayUp(int[][] mass){
        int temp = 0;
        for(int i = 0; i < mass.length; i++){
            for(int j = 0; j < mass.length; j++){
                for(int k = mass.length - 1; k > j; k--){
                    if(mass[k][i] < mass[k-1][i]){
                        temp = mass[k][i];
                        mass[k][i] = mass[k-1][i];
                        mass[k-1][i] = temp;
                    }
                }
            }
        }
        return mass;
    }
    //-----------------------------------------------------------
    private static int[][] arrayDown(int[][] mass){
        int temp = 0;
        for(int i = 0; i < mass.length; i++){
            for(int j = 0; j < mass.length; j++){
                for(int k = mass.length - 1; k > j; k--){
                    if(mass[k][i] > mass[k-1][i]){
                        temp = mass[k][i];
                        mass[k][i] = mass[k-1][i];
                        mass[k-1][i] = temp;
                    }
                }
            }
        }
        return mass;
    }
    //-----------------------------------------------------------

}
