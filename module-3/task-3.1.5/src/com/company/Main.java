package com.company;

public class Main {
    public static boolean getStr(String str, int i){
        if(str.charAt(i) == ' ' & i != (str.length()-1)) {
            if(str.charAt(i-1) == ' ') return false;
            else return true;
        }
        else {
            if(str.charAt(i) != ' ') return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String  str = "    Just    do    it. Book reader. ",
                newStr = "";

        System.out.println("Исходное предложение (" + str.length() + " симв):\n" + str);

        for(int i = 1; i < str.length(); i++) {
            if (getStr(str, i)) newStr += str.charAt(i);
        }

        System.out.println("Предложение после удаления пробелов:\n" + "|" + newStr + "|");
    }
}
