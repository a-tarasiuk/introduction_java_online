package com.company;

public class Main {
	//площадь шестиугольника
	public static void areaSix(int a){
		double sqare = 6 * areaTriandgle(a);
		System.out.println("Площадь шестиугольника = " + sqare);
	}

	//площадь равностороннего треугольника
	public static double areaTriandgle(int side){
		double square = (Math.sqrt(3) * Math.pow(side,2)) / 4;
		System.out.println("Площадь треугольника = " + square);
		return square;
	}

    public static void main(String[] args) {
	    int side = 0;
	    while (true){
	        side = (int)(Math.random() * 20);
	        if(side > 0) break;
        }
	    System.out.println("Сторона шестиугольника = " + side + " см.");
		areaSix(side);
    }
}
