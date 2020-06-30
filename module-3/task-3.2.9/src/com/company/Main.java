package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int     lower = 0,
                upper = 0;

        System.out.print("Программа считает количество строчных (маленьких) и прописных (больших) букв в веденной строке.\n" +
                         "ПРИМЕЧАНИЕ: Учитываются только буквы английского алфавита.\nВведите строку: ");
        Scanner in = new Scanner(System.in);
        String  str = in.nextLine(),
                strNew = str.replaceAll("[^a-zA-Z]", "");   //оставляем только символы английского алфавита
        in.close();

        for(int i = 0; i < strNew.length(); i++)
            if(strNew.charAt(i) == strNew.toLowerCase().charAt(i)) lower++;

        upper = strNew.length() - lower;

        System.out.println("\nКоличество строчных (маленьких) букв: " + lower);
        System.out.println("\nКоличество прописных (больших) букв: " + upper);
    }
}
