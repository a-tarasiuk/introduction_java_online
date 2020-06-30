package com.company;

public class Main {
    //заполнение массива
    public static void getValues(int[][] array, int size){
        System.out.println("Координаты точек, занесенные в массив:");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < size; j++){
                array[i][j] = (int)(Math.random() * 20 - 10);
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }

        //печать
        for(int i = 0; i < size; i++)
            System.out.println("Точка с координатами (" + array[0][i] + ";" + array[1][i] + ")");
    }

    //расстояние между точками
    public static double distance(int x1, int x2, int y1, int y2){
        double value = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        return value;
    }

    public static void main(String[] args) {
        int     array[][],
                size = 0,
                x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        double  maxDistance = 0;
        while (true){
            size = (int)(Math.random()*10);
            if(size > 3) break;
        }
        array = new int[2][size];
        getValues(array,size);

        for(int i = 0; i < size - 1; i++)
            for(int j = 0; j < size - 1; j++){
                if(j > i - 1) {//условие, чтобы не было повторяющихся точек таких как АВ и ВА
                    if(distance(array[0][i], array[1][i], array[0][j + 1], array[1][j + 1]) > maxDistance) {
                        maxDistance = distance(array[0][i], array[1][i], array[0][j + 1], array[1][j + 1]);
                        //записываем координаты точек, расстояние между которыми максимальное
                        x1 = array[0][i];
                        x2 = array[1][i];
                        y1 = array[0][j+1];
                        y2 = array[1][j+1];
                    }
                    System.out.println("Расстояние между (" + array[0][i] + ";" + array[1][i] + ") и (" + array[0][j + 1] + ";" + array[1][j + 1] + ") \tсоставляет\t " + distance(array[0][i], array[1][i], array[0][j + 1], array[1][j + 1]));
                }
            }

        System.out.println("Расстояние между точками ( " + x1 + ";" + x2 + ") и (" + y1 + ";" + y2 + ") максимальное и равно " + maxDistance);
    }
}
