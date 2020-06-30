package com.company.actions;

import com.company.Message;
import com.company.treasure.Treasure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ActionsDungeon extends Message {
    private ArrayList<Treasure> treasures;

    // общее колиество сокровищ
    private int getTotalQuantity(){
        return treasures.size();
    }

    // добавить n-количество сокровищ
    public void addTreasure(int quantity){
        for(int i = 0; i < quantity; i++)
            treasures.add(new Treasure());
    }

    // просмотр сокровищ
    public void viewAllDungeon(){
        treasures.sort(Comparator.comparing(Treasure::getId));
        for(Treasure treasure : treasures)
            System.out.println(treasure.toString());
    }

    // просмотр самого дорогого сокровища
    public void viewDearest(){
        treasures.sort(Comparator.comparing(Treasure::getCost));
        System.out.println("\nВсего сокровищ - " + getTotalQuantity() +
                "\nСамое дорогое сокровище:\n" + treasures.get(treasures.size() - 1).toString());
    }

    // просмотр сокровища на заданную сумму
    public void viewByCost(){
        int cost;
        int positionMostMin = 0;                                    // позиция самого близкого по значению (минимальная стоимость)
        int positionMostMax = 0;                                    // позиция самого близкого по значению (максимальная стоимость)
        boolean notFound = true;                                    // в наличии

        ArrayList<Treasure> duplicate = new ArrayList<>(treasures); // создаем дубликат
        duplicate.sort(Comparator.comparing(Treasure::getCost));    // сортируем по стоимости

        while (true){
            insideEnterCostInTheRange(duplicate.get(0).getCost(), duplicate.get(duplicate.size() - 1).getCost());
            cost = new Scanner(System.in).nextInt();
            if(cost >= duplicate.get(0).getCost() && cost <= duplicate.get(duplicate.size() - 1).getCost()) break;
            else menuWrongChoice();
        }

        for(Treasure treasure : treasures)
            if(treasure.getCost() == cost) {
                notFound = false;
                System.out.println(treasure.toString());
            }

        if(notFound) {
            for (int i = 0; i < duplicate.size(); i++) {
                if (duplicate.get(i).getCost() > cost) {
                    positionMostMax = i;
                    break;
                }
                else positionMostMin = i;
            }

            System.out.println("\nОтсутствует сокровище заданной стоимостью! Но имеются такие:" +
                    "\n- Самое близкое по значению (минимальное):" + duplicate.get(positionMostMin).getInformationOnlyCost() +
                    "\n- Самое близкое по значению (максимальное):" + duplicate.get(positionMostMax).getInformationOnlyCost());
        }
    }

    public ActionsDungeon(){
        treasures = new ArrayList<>();
    }
}
