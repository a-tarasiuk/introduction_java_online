package com.company;

public class Main {

    public static void main(String[] args) {
        String  str = "Mather                           father    sister           brother";
        int     cout = 0,
                coutMax = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                cout++;
            else {
                //System.out.println("Символ " + str.charAt(i) + ", cout = " + cout + ", coutMax = " + coutMax);
                coutMax = Math.max(cout, coutMax);
                cout = 0;
            }
        }

        System.out.println("Максимальное количество подряд идущих пробелов: " + coutMax);
    }
}
