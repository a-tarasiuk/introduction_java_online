package com.company;

public class Main {
    public static boolean palindrome(String s){
        int i = s.length() / 2;

        if (s.length() % 2 != 0)  //если в слове нечетное количество букв
            i++;

        for(; i < s.length(); i++) {
            //System.out.println("Слово: " + s + " | буква " + s.toLowerCase().charAt(i) + " и " + s.toLowerCase().charAt(s.length() - i - 1));
            if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(s.length() - i - 1)) return false;
        }

        return true;
    }

    public static void getWord(String str){
        for(String word : str.split("\\s")) {
            if (palindrome(word)) System.out.println("Слово: <" + word + "> является палиндромом.");
        }
    }

    public static void main(String[] args) {
        String str = "mam Pap madam leVel nOon sAgaS pRiCe father";

        System.out.println("Исходное предложение:\n" + str);

        getWord(str);

    }
}
