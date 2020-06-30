package com.company.treasure;

public class Silver implements ITreasure{
    private String name = "Серебро";
    private int price = 23;          // цена за 1 грамм

    @Override
    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
