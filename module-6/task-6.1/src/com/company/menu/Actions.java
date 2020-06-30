package com.company.menu;

import com.company.variable.VariablesMenu;
import com.company.message.MsgBase;

import java.util.Scanner;

public class Actions extends MsgBase {
    // возвращает String выбранного пункта меню из списка переданного аргумента
    public static <T extends VariablesMenu> String getUserSelect(VariablesMenu[] VariablesMenu){
        int choiceUser;

        // проверка на верный диапазон
        while (true){
            // сначала выводи сообщение в консоль
            System.out.println("\n" + msgChooseOneOfTheActions());
            // вывод на экран пунктов меню
            for(int i = 0; i < VariablesMenu.length; i++)
                System.out.println(i + ". " + VariablesMenu[i].getItem());
            // вывод предложения о вводе
            System.out.print(msgSelectChoice());
            // выбор пользователя
            choiceUser = new Scanner(System.in).nextInt();
            if(choiceUser >= 0 && choiceUser < VariablesMenu.length)
                break;
            else
                System.out.println(msgWrongChoice());
        }
        System.out.println(msgNowSelectMenuItem(VariablesMenu[choiceUser].getItem()));
        return VariablesMenu[choiceUser].getItem();
    }
}
