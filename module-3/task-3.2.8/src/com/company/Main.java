package com.company;

import java.util.Scanner;

public class Main {
    /*
    split - разделяет строку на части. Каждая часть разделяется regex
     */

    public static void main(String[] args) {
        int maxLength = 0;
        String  maxString = "",
                str;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку слов, разделенных пробелами.\nПРИМЕЧАНИЕ: слова должды быть разной длины:\n> ");

        str = in.nextLine();
        System.out.println("\nИсходное предложение:\n" + str);
        in.close();
        for(String s : str.split(" ")){
            if(s.length() > maxLength) {
                maxString = s;
                maxLength = s.length();
            }
        }


        System.out.println("Самое длинное слово: " + maxString + ", длиной: " + maxLength);

    }
}
