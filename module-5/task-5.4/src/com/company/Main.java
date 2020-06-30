package com.company;

import com.company.dungeon.Dungeon;

import java.util.Scanner;

public class Main extends Message{

    public static void main(String[] args) {
        // создаем подземелье
        Dungeon dungeon = new Dungeon("Подземелье Черного Дракона!");
        System.out.println(dungeon.toString());

        // и добавляем 10 сокровищ в подземелье
        dungeon.addTreasure(10);

        // переменная для выхода из цикла меню
        boolean isExit = false;

        while (!isExit){
            menuMain();
            menuChoice();
            switch (new Scanner(System.in).nextInt()){
                case 0:
                    isExit = true;
                    menuIsExit();
                    break;
                case 1:
                    dungeon.viewAllDungeon();
                    break;
                case 2:
                    dungeon.viewDearest();
                    break;
                case 3:
                    dungeon.viewByCost();
                    break;
                default:
                    menuWrongChoice();
            }
        }
    }
}
