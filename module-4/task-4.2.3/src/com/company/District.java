package com.company;

// Р А Й О Н

/*
Площадь района зависит от кол-во городов, входящих в район.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class District {
    private String  name;                       // название района
    private int     square,                     // площадь района (км. кв.)
                    numberTown;                 // кол-во городов в районе

    ArrayList<Town> town = new ArrayList<>();   // города

    Scanner scanner = new Scanner(System.in);

    public ArrayList<Town> getTown(){
        return town;
    }

    public int getNumberTown(){
        return this.numberTown;
    }

    public String getName(){
        return this.name;
    }

    public int getSquare(){
        square = 0;
        for(int i = 0; i < town.size(); i++)
            square += town.get(i).getSquare();
        return square;
    }

    public void setNumberTown(){
        while (true){
            this.numberTown = scanner.nextInt();
            if (this.numberTown > 0) {
                town.ensureCapacity(numberTown);    // задаем первоначальный размер ArrayList'a
                return;
            }
            System.out.print("\n[ОШИБКА] Должен быть хотя бы один город.\n" +
                    "Повторите ввод: ");
        }
    }

    public void addTown(){
        town.add(new Town());
    }

    District(){
        while (true){
            this.name = scanner.nextLine();
            if (this.name.trim().length() != 0)
                return;
            System.out.print("\n[ОШИБКА] Название районного центра не может быть пустым полем.\n" +
                    "Повторите ввод: ");
        }
    }
}
