package com.company;

// Г О Р О Д

import java.util.Scanner;

public class Town {
    private String  name,               // название города
                    ifTheCapital;       // принимает значение "да" или "нет"
    private int     square;             // площадь города (км. кв.)
    private boolean capital = false;    // город является столицей?

    Scanner scanner = new Scanner(System.in);

    public String getName(){
        return name;
    }

    public int getSquare(){
        return this.square;
    }

    public boolean getCapital(){
        return capital;
    }

    public void setCapital(){
        while (true){
            System.out.print("\nСделать толицей? (введите \"ДА\" или \"НЕТ\"): ");
            ifTheCapital = scanner.next();
            if(ifTheCapital.compareToIgnoreCase("ДА") == 0) {
                capital = true;
                return;
            }
            else if(ifTheCapital.compareToIgnoreCase("НЕТ") == 0){
                capital = false;
                return;
            }
            else System.out.println("[ОШИБКА] Вводите только \"ДА\" либо \"НЕТ\".");
        }
    }

    Town(){
        while (true){
            this.name = scanner.nextLine();
            if (this.name.trim().length() != 0) {
                square = (int)(Math.random() * (100 + 1) + 1);
                System.out.println("Площадь города: " + square + " кв.км.");
                return;
            }
            System.out.print("\n[ОШИБКА] Название города не может быть пустым полем.\n" +
                    "Повторите ввод: ");
        }
    }
}
