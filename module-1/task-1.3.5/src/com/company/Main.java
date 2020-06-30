package com.company;

public class Main {

    public static void main(String[] args) {
	/*
	1) n - переменная-счетчик (указывается под значком суммы E, например n = 1)
	2) K - предел счетчика (указывается сверху значка суммы E, например бесконечность)
	http://www.mathprofi.ru/ryady_dlya_chajnikov.html
	 */

        int     n = 0,          //переменная-счетчик, суммирование начинается с n и, например, до плюс бесконечности
                k = 0;          //предел переменной-счетчика

        double  S = 0,          //сумма числового ряда
                Si = 0,         //проверка члена числового ряда на модуль
                e = 0;          //некоторое число

        while(true){
            n = (int)(Math.random() * 100);
            k = (int)(Math.random() * 100);
            if(n < k) break;    //p должно быть больше n
        }

        System.out.println("Переменная-счетчик n = " + n);
        System.out.println("Предел переменной-счетчика p = " + k);

        e = Math.random() - 1;  //делаем -1, потому что в 99% случаев модуль члена ряда получается меньше числа e
        System.out.println("Некоторое число e = " + e);;

        for(int i = n; i <= k; i++) {
            Si = (1 / Math.pow(2, i)) + (1 / Math.pow(3, i));
            //System.out.println("|Si| = " + Math.abs(Si));
            //System.out.println(("|Si| - e = " + (Math.abs(Si) - e)));
            if( Math.abs(Si) >= e )
                S += Si;
        }
        System.out.println("S = " + S);
    }
}
