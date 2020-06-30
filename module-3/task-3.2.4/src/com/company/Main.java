package com.company;

public class Main {
    //s1 - строка с набором символов
    //s2 - искомое слово
    public static void getString(String s1, String s2){
        String s3 = "";
        for(int i = 0, j = 0; i < s1.length() & j < s2.length(); i++){
            if(s1.charAt(i) == s2.charAt(j)) {
                s3 += s1.charAt(i);
                i = 0;
                j++;
            }
        }
        System.out.println(s3);
    }

    public static void main(String[] args) {
        String  s1 = "информатика",
                s2 = "торт";
        //System.out.println("Суммарное количество возможных комбинаций:\n" + Math.pow(s1.length(),s2.length()));
        getString(s1, s2);

    }
}
