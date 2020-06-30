package com.company;

import java.rmi.MarshalException;

public class Main {

    public static void main(String[] args) {
	    int     m = 0, n = 0,
				//counter = 0,
                array[][];
	    while (true){
	        m = (int)(Math.random()*10);
	        n = (int)(Math.random()*10);
	        if(m > 2 & n > 2) break;
        }
	    System.out.println("m = " + m + " n = " + n);

	    array = new int[m][n];

	    for(int i = 0; i < m; i++){
	    	for(int j = 0, counter = 0; j < n; j++, counter++){
				if(counter < i) array[i][j] = 0;
				if(counter > i) array[i][j] = 1;
	    		System.out.print(array[i][j] + "\t");
			}
	    	System.out.println();
		}

    }
}
