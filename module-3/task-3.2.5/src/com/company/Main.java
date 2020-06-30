package com.company;

public class Main {

    public static void main(String[] args) {
         String str = "dsfs_a_f343f_a_f3g43_a_AAVSDVD_a_^@#$";
         char   ch = 'a';
         int    first = str.indexOf(ch),           //первое вхождение символа
                last = str.lastIndexOf(ch),   //последнее вхождение симовла
                cout = 0;
        for(int i = first; i <= last; i++)
            if(str.charAt(i) == ch) cout++;
         System.out.println("Исходная строка символов:\n" + str + "\nКоличество вхождений символа <a>:\n"+ cout);
    }
}
