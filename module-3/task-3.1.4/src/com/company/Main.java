package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "9th999er 4 word wide 3 web 4242 hello w7o3WWW99";
        int     cout = 0;
        boolean value = false,
                valueNext = false;

        System.out.println("Исходное предложение (длина строки - " + str.length() + " симв.):\n" + str);
        for(int i = 0; i < str.length(); i++) {
            value = Character.isDigit(str.charAt(i));

            if(i != str.length() -1) //если это не конец строки, а то произойдет выход за пределы строки, когда выполнится (i+1)
                valueNext = Character.isDigit(str.charAt(i+1));
            else valueNext = false; //если конец строки, то последний символ не число

            if (value & !valueNext) {
                cout++;
            }
        }

        System.out.println("В предложении содержится " + cout + " чисел.");
    }
}
