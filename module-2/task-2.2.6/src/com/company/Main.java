package com.company;

public class Main {

    public static void main(String[] args) {
	    int 	size = 0;

	    while(true){
	        size = (int)(Math.random()*10);
	        if(size % 2 == 0 & size != 0)
	        	break;
        }

		System.out.println("size = " + size + "\n");

	    int array[][] = new int[size][size];

		for( int i = 0; i < size / 2; i++ ) {
			System.out.println("-----------------");
			for (int j = 0; j <= i; j++) {
				array[j][i] = array[j][size-i-1] = array[size-j-1][i] = array[size-j-1][size-i-1] = 1;		//сверху единицы
				//array[i][j] = array[size-i-1][j] = array[i][size-j-1] = array[size-i-1][size-j-1] = 1;	//сверху нули
				System.out.println("array[" + j + "][" + i + "] = " + array[j][i]);
			}
		}

	    //печать массива
		for(int i = 0; i < array.length; i++ ){
			for(int j = 0; j < array.length; j++){
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
    }
}
