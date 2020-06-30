package com.company;

import java.util.Scanner;

public class Messages {
    //проверка на корректность выбора
    public int getChoice(int[] validKeys){
        int     key = 0;                                        //выбор пользователя
        Scanner in = new Scanner(System.in);
        while (true){
            key = in.nextInt();
            for(int i = 0; i < validKeys.length; i++)
                if (key == validKeys[i]) return key;
            getMessageError();
        }
    }

    //проверка на корректность выбора
    public int getChoice(int validKeys){
        int     key = 0;                                        //выбор пользователя
        Scanner in = new Scanner(System.in);
        while (true){
            key = in.nextInt();
            if (key == validKeys) return key;
            getMessageError();
        }
    }

    //сообщение об ошибке ввода с клавиатуры
    public void getMessageError(){
        System.out.print("\n[Error] Ошибка ввода.\nПовторите ввод: ");
    }

    public void getMessageWelcome(){
        System.out.println("0. Выход\n" +
                "1. Завести двигатель\n" +
                "2. Остановить двигатель\n" +
                "3. Начать движение\n" +
                "4. Заправиться\n" +
                "5. Заменить колесо\n" +
                "6. Вывести марку автомобиля\n" +
                "7. Вывести показатели приборной панели");
    }

    public void getMessageChoice(){
        System.out.print("\nВаш выбор: ");
    }

}
