package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
    	/*
    	Т.к. в условии не указано, какая матрица, пусть будет квадратная.
    	 */

	    int 	size = (int)(Math.random()*10),
				array[][] = new int[size][size],	//строки, столбцы
				firstElement = 0,
				lastElement = 0,
				cout = 0;

		System.out.println("Исходная матрица (размер - " + array.length + "):");

	    for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = (int) (Math.random() * 100);
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nИзмененная матрица:");

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				firstElement = array[cout][j];				// 1) находим первый элемент столбца
				lastElement = array[array.length - 1][j];	// 2) находим последний элемент столбца
				//System.out.println("firstElement = " + firstElement + "\tlastElement = " + lastElement);
				if (firstElement > lastElement) {			// 3) если первый элемент > последнего элемента
					System.out.print(array[i][j] + "\t");	// 4) то печатаем
				}
			}
			System.out.println();
		}



    }
}
