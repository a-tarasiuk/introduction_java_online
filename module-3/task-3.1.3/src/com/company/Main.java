package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Other 4 word wide 3 web 4242 hello w7o3o9";
        int cout = 0;

        System.out.println("Исходное предложение:\n" + str);

        for(int i = 0; i < str.length(); i++)
            if(Character.isDigit(str.charAt(i))) cout++;

        System.out.println("В предложении содержится " + cout + " цифр.");
    }
}
