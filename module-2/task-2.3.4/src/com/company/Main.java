package com.company;

public class Main {
    public Main() {
    }

    public static void getArray(int[] mass) {
        System.out.print("Исходный массив [" + mass.length + "]: ");

        for(int i = 0; i < mass.length; ++i) {
            mass[i] = (int)(Math.random() * 10.0D);
            System.out.print(mass[i] + " ");
        }

        System.out.println();
    }

    public static void bubbleSort(int[] mass) {
        int numberIteration = 0;

        for(int i = mass.length - 1; i > 0; --i) {
            for(int j = i - 1; j >= 0; --j) {
                if (mass[j] > mass[i]) {
                    mass[j] = mass[j] + mass[i] - (mass[i] = mass[j]);
                    ++numberIteration;
                }
            }
        }

        System.out.println("\nКоличество перестановок: " + numberIteration);
    }

    public static void main(String[] args) {
        boolean var1 = false;

        int size;
        do {
            size = (int)(Math.random() * 10.0D);
        } while(size <= 2);

        int[] array = new int[size];
        getArray(array);
        bubbleSort(array);
        System.out.println("Сортированный массив: ");

        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }

    }
}
