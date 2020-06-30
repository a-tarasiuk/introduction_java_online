package com.company;

public class Main {
    //faq - https://ru.wikihow.com/%D0%BF%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D0%B8%D1%82%D1%8C,-%D1%8F%D0%B2%D0%BB%D1%8F%D0%B5%D1%82%D1%81%D1%8F-%D0%BB%D0%B8-%D1%87%D0%B8%D1%81%D0%BB%D0%BE-%D0%BF%D1%80%D0%BE%D1%81%D1%82%D1%8B%D0%BC
    //Метод - перебор делителей
    public static boolean simpleNumber(int number){
        int sqrtNumber = (int)(Math.sqrt(number));
        for(int i = 2; i <= sqrtNumber; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = (int)(Math.random() * 100);
        double  A[] = new double[N];
        double sum = 0.0;

        //заполнение массива
        for(int i = 0; i < N; i++) {
            A[i] = Math.random() * 100;
            if(simpleNumber(i) & i > 1) {
                System.out.println("A[" + i + "] = " + A[i]);
                sum += A[i];
            }
        }

        System.out.println("Сумма чисел, порядковые номера которых являются простыми числами = " + sum);


    }



}
