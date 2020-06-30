package com.company;

// S W I T C H  -  C A S E

import java.util.Scanner;

public class SwitchCase {
    /*------------------------------------------------ПЕРЕМЕННЫЕ------------------------------------------------------*/
    private int     key = 0;                                        //выбор пользователя (значение типа int)
    /*---------------------------------------------СОЗДАНИЕ СКАНЕРА---------------------------------------------------*/
    Scanner in = new Scanner(System.in);
    /*--------------------------------------------------МЕТОДЫ--------------------------------------------------------*/
    //проверка на корректность выбора
    public int getChoice(int length){
        getMessageChoice();
        while (true){
            this.key = in.nextInt();
            if (this.key >= 0 && this.key <= length)
                return this.key;
            getMessageError();
        }
    }

    public int getChoiceWithoutZero(int length){
        getMessageChoice();
        while (true){
            this.key = in.nextInt();
            if (this.key > 0 && this.key <= length)
                return this.key;
            getMessageError();
        }
    }
    /*-----------------------------------------ИНФОРМАЦИОННЫЕ СООБЩЕНИЯ-----------------------------------------------*/
    //сообщение об ошибке ввода с клавиатуры
    public void getMessageError(){
        System.out.print("\n[ОШИБКА] Неверный диапазон допустимых значений.\nПовторите ввод: ");
    }

    public void getMessageChoice(){
        System.out.print("\nВаш выбор: ");
    }
    /*--------------------------------------------------КОНЕЦ---------------------------------------------------------*/
}
