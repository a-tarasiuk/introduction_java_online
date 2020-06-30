package com.company;

public class Main {
    //заполнение массива
    public static void getArray(int[] array){
        for(int i = 0; i < array.length; i++){
            while (true){
                array[i] = (int)(Math.random()*20);
                if(array[i] != 0) break;
            }
            System.out.print(array[i] + "\t");
        }
    }

    //наибольший общий делитель (Алгоритм Евклида)
    // https://scienceland.info/algebra8/euclid-algorithm
    public static int nod(int[] array){
        System.out.println("\nДлина массива = " + array.length);
        int nod = 0;
        for(int i = array.length - 1; i > 0; i--) {
            while (array[i] > 0) {
                int swap = array[i];
                array[i] = array[i-1] % array[i];
                array[i-1] = swap;
                nod = array[i-1];
            }
        }
        System.out.println("\nNOD = " + nod);
        return nod;
    }


    public static void main(String[] args) {
        int[] array = new int[4];
        System.out.println("Исходные 4 числа:");
        getArray(array);
        nod(array);
    }
}
