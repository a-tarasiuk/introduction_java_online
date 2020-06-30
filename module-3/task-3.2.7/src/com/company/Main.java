package com.company;

import java.util.Scanner;

public class Main {
	/*
	метод boolean contains() проверяет, содержится ли то, что в скобках.
	Возвращает true, если содержит
	 */

	public static String removeDuplicates(String s){
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if(!result.contains(String.valueOf(s.charAt(i)))) {
				result += String.valueOf(s.charAt(i));
			}
		}
		return result;
	}

    public static void main(String[] args) {
		System.out.print("Введите строку с повторяющимися символами.\nПрограмма удалит дубликаты символов.\n> ");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();

		System.out.println("Исходная строка:\n" + str);
		System.out.println("Измененная строка:\n" + removeDuplicates(str.replaceAll(" ", "")));


    }
}
