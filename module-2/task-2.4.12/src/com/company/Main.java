package com.company;

    /*
    Даны натуральные числа K и N.
    Написать метод (методы) формирования массива А, элементами которого являются числа не больше N,
    сумма цифр которых равна К.
     */

public class Main {
    /*
    1) Создается массив для каждого числа от 1 до n (вызовом метода arrayNumber), чтобы получить сумму цифр числа.
    Размер массива arrayNumber вычисляется в методе getSizeArrayBasedOnNumber исходя из того, сколько цифр в числе.
     */

    //узнаем, сколько цифр в числе
    public static int getSizeArrayBasedOnNumber(int a){
        int     cout = 0,
                originalNumber = a;
        while (originalNumber != 0){
            originalNumber /= 10;
            cout++;
        }
        //System.out.println("В числе " + a + " содержится " + cout + " цифр.");
        return cout;
    }

    //находим сумму цифр числа
    public static int sumOfNumbers(int number, int k){
        int sum = 0,
            a = number,         //делаем это, чтобы в System.out.println использовать исходное значение - число number
            array[] = new int[getSizeArrayBasedOnNumber(number)];

        //находим сумму цифр числа
        for(int i = 0; i < array.length; i++){
            sum += a % 10;
            a /= 10;
        }

        //System.out.println("Сумма цифр числа " + number + " равняется " + sum);
        return sum;
    }

    //сколько чисел от 1 до n, у которых сумма цифр в числе равняется k (это и будет размер массива, в который нужно будет занести данные числа)
    public static int howManyDigits(int n, int k){
        int digits = 0; //сколько чисел от 1 до n, у которых сумма цифр в числе равняется k (это и будет размер массива, в который нужно будет занести данные числа)

        for(int i = n; i > 0; i--) {
            if(sumOfNumbers(i, k) == k) digits++;
        }

        System.out.println("Чисел, у которых сумма цифр равна " + k + " составляет: " + digits);
        return digits;
    }

    public static void main(String[] args) {
        int     k = (int)(Math.random() * 10),
                n = (int)(Math.random() * 100000),
                array[],
                sum = 0;

        System.out.println("Даны числа: k = " + k + ", n = " + n);

        array = new int[howManyDigits(n, k)];

        //заносим искомые числа в массив
        for(int i = n, j = 0; i > 0; i--) {
            sum = sumOfNumbers(i, k);
            if (sum == k) {
                array[j] = i;
                j++;
            }
        }

        System.out.println("Искомый массив:");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");



    }
}

