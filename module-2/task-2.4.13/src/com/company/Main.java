package com.company;
class Twins{
	private int  n = 0,
				limit = 0;

	// Конструктор (Метод) - для генерации числа n
	public Twins(){
		while (true){
			n = (int)(Math.random() * 100);
			if(n > 2) {		//по условию, n > 2
				limit = 2 * n;
				break;
			}
		}
	}

	public void getValues(){
		System.out.println("n = " + n + ", limit = " + limit);
	}

	public void getTwins(){
		for(int i = n; i <= limit; i++){
			if( (i+2) > limit) break;
			else System.out.println("Числа близнецы: " + i + " и " + (i+2));
		}
	}
}

public class Main {

    public static void main(String[] args) {

		Twins twins = new Twins();
	    twins.getValues();
	    twins.getTwins();
    }
}
