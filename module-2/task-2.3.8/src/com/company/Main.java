package com.company;

public class Main {
    /*
    Шаги:
    1) Найти НОД
    2) Найти НОК (чтобы найти НОК, нужно сначала найти НОД)
    3) Найти дополнительный множитель к каждой дроби

    НОК для 4 чисел NOK(a, LCM(b, LCM(c, d))), рекурсия
     */
    //печать двухмерного массива
    public static void printArray(int[][] array, int size){
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(array[i][j] + "\t\t");
            System.out.println();
        }
    }

    //заполняем массив
    public static void fullTheArray(int[][] a, int sizeArray){
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < sizeArray; j++)
                while (true) {    //в числителе и знаменателе не может быть нулей
                    a[i][j] = (int) (Math.random() * 10);
                    if (a[i][j] != 0) break;
                }
        }
    }

    //наименьшее общее кратное двух чисел
    public static int NOK(int a, int b){
        return Math.abs(a * b) / NOD(a, b);
    }

    //наименьшее общее кратное массива
    public static int NOKArray(int[][] array, int min, int max){
        if(min == max - 2)
            return NOK(array[1][min], array[1][min + 1]);
        else
            return NOK(array[1][min], NOKArray(array, min+1, max));
    }

    //наибольший общий делитель
    public static int NOD(int a, int b){
        if(b < 0) b = -b;
        if(a < 0) a = -a;

        while (b > 0){
            int swap = b;
            b = a % b;
            a = swap;
        }
        return a;
    }

    //приведение к общему знаменателю
    public static void commonDenominator(int[][] array, int size){
        for(int i = 0; i < size; i++) {
            array[0][i] = NOKArray(array, 0, size) / array[1][i] * array[0][i];    //числитель
            array[1][i] = NOKArray(array, 0, size); //знаменатель у всех будет общий
        }
    }


    //сортировка пузырьковая
    public static void bubbleSort(int[][] array, int sizeArray){
        /*
        из двух дробей с одинаковым знаменателем больша та, у которой числитель больше.
        Поэтому будем сравнивать числители
         */
        int     indexMaxElement = 0;

        for(int i = 0; i < sizeArray - 1; i++){
            indexMaxElement = i;
            for(int j = i + 1; j < sizeArray; j++){
                if(array[0][j] < array[0][indexMaxElement]) indexMaxElement = j;    //сравнили числители, записали индекс
            }
            //меняем числители
            array[0][indexMaxElement] = array[0][indexMaxElement] + array[0][i] - (array[0][i] = array[0][indexMaxElement]);
            //меняем знаменатели (хоть и у всех одинаковый знаменатель, для полноты сортировки поменяем и их)
            array[1][indexMaxElement] = array[1][indexMaxElement] + array[1][i] - (array[1][i] = array[1][indexMaxElement]);
        }
    }



    public static void main(String[] args) {
        int     size = 0,
                commonDenominator = 0;  //общий знаменатель
        while (true){
            size = (int)(Math.random()*10);
            if(size > 2) break;
        }
        int[][] array = new int[2][size];   //числитель, знаменатель
        int[] mass = new int[]{3,6,6,12};

        System.out.println("Исходные дроби:");
        fullTheArray(array, size);
        printArray(array, size);

        System.out.println("\nНОК для всех дробей: " + NOKArray(array, 0, size));

        System.out.println("\nДроби, приведенные к общему знаменателю:");
        commonDenominator(array, size);
        printArray(array, size);

        System.out.println("\nСортированные дроби:");
        bubbleSort(array, size);
        printArray(array, size);
    }
}
