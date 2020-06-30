package com.company;

public class Main {
	public static void sumOfThreeNumbers(int[] array, int k, int m){
		int sum = 0;
		for(int i = k; i < m; i++) {
			sum = 0;

			if(m - i < 2) break;	//условие, чтобы если останется сумма двух элементов до конца массива, то не печатать, т.к. по условию нужно найти сумму трёх последовательных элементов
			else {
				System.out.print("Сумма элементов: ");
				for (int j = 0; j < 3; j++) {
					System.out.print("[" + i + "] = " + array[i + j] + ", ");
					if (i + j != m) sum = sum + array[i + j];    //если последний элемент m будет равен концу массива
					else break;
				}
				System.out.println("составляет = " + sum);
			}
		}
		//if(m < k) return 0;
		//return array[k] + sumOfThreeNumbers(array, k+1, m);
	}

    public static void main(String[] args) {
	    int     size = 0,
                array[],
				k = 0,	//нижняя граница
				m = 0,	//верхняя граница
				sum = 0;
	    while (true){
	        size = (int)(Math.random() * 20);
	        k = (int)(Math.random() * 20);
	        m = (int)(Math.random() * 20);
	        if(size > 3 & k < m & k > 0 & m < size & m - k > 3) break;
        }
	    array = new int[size];

	    System.out.println("Исходный массив array[" + array.length + "]:");
	    for(int i = 0; i < array.length; i++){
	        array[i] = (int)(Math.random() * 10);
	        System.out.print(array[i] + "\t");
        }
	    System.out.println("\nНижняя граница: array[" + k + "]\nВерхняя граница: array[" + m + "]");

		for(int i = 0; i < array.length; i++){
			if(i == k) System.out.print("[" + array[i] + "]\t");
			else if (i == m) System.out.print("[" + array[i] + "]\t");
			else System.out.print(array[i] + "\t");
		}
		System.out.println();
	    System.out.println("\nСумма трёх последовательно расположенных элементов массива':");
		sumOfThreeNumbers(array, k, m);

    }
}
