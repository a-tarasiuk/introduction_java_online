package com.company;

public class Main {

    public static int preMaxNumberMethodOne(int[] array){
        int     max = 0,
                preMax = 0;
        //находим максимальный элемент
        for(int i = 0; i < array.length; i++)
            if (array[i] > max) {
                max = array[i];
            }
        //находим элемент, предшествующий максимальному
        for(int i = 0; i < array.length; i++){
            if(array[i] > preMax & array[i] < max) preMax = array[i];
        }
        return preMax;
    }

    public static int preMaxNumberMethodTwo(int[] array){
        int     max = 0,
                preMax = 0;
        //находим максимальный элемент
        for(int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                preMax = max;
                max = array[i];
            }
            else if(array[i] > preMax) preMax = array[i];
        }

        return preMax;
    }


    public static void main(String[] args) {
	    int     size = 10,
                array[] = new int[size],
                maxNumber = 0;

	    System.out.println("Исходный массив:");
	    for(int i = 0; i< array.length; i++) {
            array[i] = (int) (Math.random() * 20);
            System.out.print(array[i] + " ");
	    }

	    System.out.println("\n(Способ 1) Число, предшествующее максимальному элементу: " + preMaxNumberMethodOne(array));
        System.out.println("\n(Способ 2) Число, предшествующее максимальному элементу: " + preMaxNumberMethodTwo(array));
    }
}
