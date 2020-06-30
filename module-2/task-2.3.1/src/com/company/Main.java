package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size1 = 0,
                size2 = 0,
                k = 0,
                array1[],
                array2[];

        while (true) {
            k = (int) (Math.random() * 10);
            size1 = (int) (Math.random() * 10);
            size2 = (int) (Math.random() * 10);
            if (size1 > 0 & size2 > 0)
                if (k < size1 - 1) break;
        }

        array1 = new int[size1];
        array2 = new int[size2];

        System.out.println("\n---------------------------------------------------------");
        System.out.print("Натуральное число k = " + k);
        System.out.println("\n---------------------------------------------------------");
        System.out.print("Массив array1[" + array1.length + "]: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 10);
            System.out.print("|" + array1[i]);
        }

        System.out.print("\nМассив array2[" + array2.length + "]: ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) (Math.random() * 10);
            System.out.print("|" + array2[i]);
        }

        System.out.println("\n---------------------------------------------------------");

        array1 = Arrays.copyOf(array1, array1.length + array2.length);

        for(int j = k; j < array1.length - array2.length; j++)
            array1[j + array2.length] = array1[j];

        for (int i = 0, j = k; i < array2.length; i++) {
            array1[j] = array2[i];
            j++;
        }

        System.out.print("Новый массив array1[" + array1.length + "]: ");
        for(int i = 0; i < array1.length; i++)
            System.out.print("|" + array1[i]);
    }
}
