package com.company;

public class Main {
    /*
    сам метод replaceAll - https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#replaceAll-java.lang.String-java.lang.String-%23replaceAll-java.lang.String-java.lang.String-
    Цитата:
     	replaceAll(String regex, String replacement)
        EN - Replaces each substring of this string that matches the given regular expression with the given replacement.
        RU - Заменяет каждую подстроку этой строки, которая соответствует данному регулярному выражению с данной заменой.

        regex       - что будет заменяться (строка или регулярное выражение)
        replacement - строка, на которую будет производиться замена

        Регулярные выражения:
        https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#sum

        Из ссылки *регулярные выражения" нам понятно, что "." - это абсолютно любой символ, который содержится в строке
        Значит regex = "."

     */
    public static String doubleStr(String s1, String s2) {
        return s2 =s1.replaceAll(".", "$0$0");
    }

    public static void main(String[] args) {
        String  s1 = "ABCDEFJ",
                s2 = "";

        System.out.println("Исходная строка:\n" + s1 + "\nПосле дублирования каждого симовла:\n" + doubleStr(s1, s2));
    }
}
