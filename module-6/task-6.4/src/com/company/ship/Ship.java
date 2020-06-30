package com.company.ship;

/**
 * Класс - ship (корабль).
 */

import com.company.ship.types.SizeShip;

public class Ship {
    {id++;}

    private static int id;                  // идентификационный номер
    private final String NAME;
    private final SizeShip size;
    private int nowGoods;                   // текущее количество товара

    public Ship(SizeShip size){
        // задается рандомная вместимость судна
        this.size = size;
        // судно либо полностью загружено либо порожнее (будет либо 0 либо полностью загружено)
        nowGoods = (int)(Math.random() * 2) * size.getValue();
        this.NAME = "Ship " + id;
        System.out.println("\n" + this.NAME + " was created!" +
                "\nSize: " + size.toString() +
                "\nNow goods: " + nowGoods + " (units)" +
                "\nMax goods: " + size.getValue() + " (units)");
    }

    public String getName(){
        return this.NAME;
    }

    public boolean isFull(){
        return nowGoods >= size.getValue();
    }

    public boolean isEmpty(){
        return nowGoods == 0;
    }

    public void add(int count){
        this.nowGoods += count;
    }

    public void unload(int count){
        this.nowGoods -= count;
    }

    public int getNowGoods(){
        return this.nowGoods;
    }

    public int getMaxGoods(){
        return size.getValue();
    }

}
