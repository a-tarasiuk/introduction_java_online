package com.company;

public class Message {
    public static void menuMain(){
        System.out.println("\n0. Выход\n" +
                "1. Просмотр всех сокровищ (подробно)\n" +
                "2. Просмотр самого дорогого сокровища\n" +
                "3. Выбор сокровища по стоимости");
    }

    public static void menuChoice(){
        System.out.print("Ваш выбор: ");
    }

    public static void menuWrongChoice(){
        System.out.println("\n\t...(Ошибка) Неверный ввод, повторите ввод.");
    }

    public static void menuIsExit(){
        System.out.println("\n\t...Выход из программы.");
    }

    public static void insideEnterCostInTheRange(int min, int max){
        System.out.print("\nВведите стоимость $ (минимальная - " + min + ", максимальная - " + max + "): ");
    }
}
