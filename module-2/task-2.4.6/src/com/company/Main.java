package com.company;

public class Main {

	public static int nod(int a, int b){
		//System.out.println("\nДлина + массива = " + array.length);
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			return a;
	}

	public static int nod(int[] a) {
		int nodArray = a[0];

		for( int i = 1; i < a.length; i++ ) {
			nodArray = nod(nodArray, a[i]);
		}

		return nodArray;
	}

    public static void main(String[] args) {
        /*
       Целые числа называются взаимно простыми, если они не имеют никаких общих делителей, кроме ±1.
       Натуральные числа a и b называют взаимно простыми, если их наибольший общий делитель равен 1 (НОД(a; b) = 1).
         */
	    int[] array = new int[3];
	    System.out.print("Даны числа: ");
	    for(int i = 0;  i < array.length; i++){
	    	while (true){	//НОД может быть определен для любых двух целых чисел. 0 - не является целым числом.
				array[i] = (int)(Math.random() * 20);
				if(array[i] != 0) break;
			}

	        System.out.print(array[i] + "\t");
        }

	    if(nod(array) == 1) System.out.println("\nНОД трёх чисел: " + nod(array) + ". Числа взаимопростые!");
	    else System.out.println("\nЧисла не являются взаимопростыми.");



    }
}
