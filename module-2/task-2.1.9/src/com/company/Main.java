package com.company;

public class Main {

    public static void main(String[] args) {
        int numbers[] = new int[]{1,2,3,4,5,5,4,4,4,2,2,2,2,2};
        int nowCount = 0;            //текущее число повторений
        int maxCount = 0;              //наибольшее число повторений
        int minimalCount = 0;         //минимальный элемент

        /*
        Принцип действия:
        1) Сравниваем каждый элемент массива numbers[]
        2) Если находится повторяющийся, то
        3) Увеличиваем счетчик с именем nowCount на единицу (тем самым узнаем, сколько раз повторяется элемент)
        4) Если счетчик с именем nowCount больше 1 (точка А),то (это условие дает понять, что проверяемый элемент уже повторялся, значит мы его сравним с минимальным
        5) Минимальный элемент равен элементу в массиве (точка Б)
         */

        for(int i = 0; i < numbers.length; i++){
            nowCount = 0;
            for(int j = i; j < numbers.length; j++){
                if(numbers[j] == numbers[i]) {
                    nowCount++;
                    if(nowCount > 1) {                      // точка А
                        minimalCount = numbers[i];          // точка Б
                        if(numbers[j] <= minimalCount) minimalCount = numbers[i];
                    }

                }
                if(nowCount > maxCount) maxCount = nowCount;
            }

        }

        System.out.println("Минимальный частовстречающийся элемент = " + minimalCount + " | Число повторений = " + maxCount);
    }
}
