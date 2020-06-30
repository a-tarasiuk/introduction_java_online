package com.company;

class IncreasingSequence{
    int array[],
        size = 0,
        temp = 0,
        maxValue = 0;

    // задание максимального числа k (maxValue)
    public IncreasingSequence(){
        maxValue = (int)(Math.random() * 300);
        //maxValue = Integer.MAX_VALUE;
    }

    //метод для создания массива с количеством цифр в числе и его заполнение
    public void getArray(int number) {
        array = new int[getSizeArray(number)];
        setArray(number);
    }

    //заполнение массива цифрами числа
    public void setArray(int number){
        for(int i = 0; i < array.length; i++){
            array[i] = number % 10;
            number /= 10;
        }
    }

    // метод для получения количества цифр в числе
    public int getSizeArray(int value) {
        size = 0;
        //узнаем, сколько цифр в числе, чтобы создать массив, размер которого равен количеству цифр в числе
        while (value > 0) {
            value /= 10;
            size++;
        }
        return size;
    }

    public int getMaxValue(){
        return maxValue;
    }

    public boolean increase(int number) {
        getArray(number);
        //начинаем сравнивать с конца массива, т.к. цифры в его заносились с конца числа
        for (int i = array.length -1 ; i > 0; i--) {
            if (array[i] > array[i - 1]) return false;
            }
        return true;
    }

}

public class Main {

    public static void main(String[] args) {
	    IncreasingSequence is = new IncreasingSequence();
	    System.out.println("Исходное число: " + is.getMaxValue());
        for(int i = 0; i < is.getMaxValue(); i++)
            if(is.increase(i))
                System.out.println("Число " + i + " возрастающее.");

    }
}
