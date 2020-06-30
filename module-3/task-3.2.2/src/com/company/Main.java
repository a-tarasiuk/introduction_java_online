package com.company;

public class Main {
    public static void wayOne (String str){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a') {
                newStr += (str.charAt(i) + "b");
            }
            else newStr += str.charAt(i);
        }
        System.out.println("Предложение после замены:\n" + newStr);
    }

    public static void wayTwo(StringBuffer sb){
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a')
                sb.insert(i+1, 'b');
        }
        System.out.println("Предложение после замены:\n" + sb);
    }

    public static void wayThree(StringBuffer sbThree){
        for(int i = 0; i < sbThree.length(); i++){
            if(sbThree.charAt(i) == 'a'){
                sbThree.replace(i+1, sbThree.length(), (String) sbThree.subSequence(i, sbThree.length()));
                sbThree.setCharAt(i+1, 'b');

            }
        }
        System.out.println("Предложение после замены:\n" + sbThree);
    }

    public static void main(String[] args) {
        String          str = "Mather, father, sister, brother, mam, tad, laptop";
        StringBuffer    sb = new StringBuffer("Mama, papa, laptop, car, wash, gela"),
                        sbThree = new StringBuffer("Lama, noteboook, other way, man, women, car, wash");

        // Способ 1
        System.out.println("[1] Исходное предложение:\n" + str);
        wayOne(str);

        // Способ 2
        System.out.println("\n[2] Исходное предложение:\n" + sb);
        wayTwo(sb);

        // Способ 3
        System.out.println("\n[3] Исходное предложение:\n" + sbThree);
        wayThree(sbThree);
    }
}
