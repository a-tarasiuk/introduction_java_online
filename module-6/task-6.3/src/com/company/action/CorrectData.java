package com.company.action;

import com.company.data.Patterns;
import com.company.variable.GeneralMenu;
import com.company.message.MsgActions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectData extends MsgActions {
    protected  <T extends GeneralMenu> String getChoice(GeneralMenu[] VariablesMenu){
        int choiceUser;

        // проверка на верный диапазон
        while (true){
            // сначала выводи сообщение в консоль
            msgChooseOneOfTheActions();
            // вывод на экран пунктов меню
            for(int i = 0; i < VariablesMenu.length; i++)
                System.out.println(i + ". " + VariablesMenu[i].getItem());
            // выбор пользователя
            choiceUser = getInt();

            if(choiceUser >= 0 && choiceUser < VariablesMenu.length)
                break;
            else
                msgWrongChoice();
        }
        return VariablesMenu[choiceUser].getItem();
    }

    public String getCorrectData(Patterns pattern){
        String value;
        while (true) {
            pattern.getMsg();
            msgEnter();
            value = new Scanner(System.in).nextLine();
            if(value.matches(pattern.getRegex()))
                return value;
            else
                msgIncorrectData();
        }
    }

    // получить из клавиатуры число (иначе - исключение)
    protected Integer getInt(){
        // вывод предложения о вводе
        msgSelectChoice();
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ex) {
            msgIncorrectData();
            return -1;
        }
    }
}
