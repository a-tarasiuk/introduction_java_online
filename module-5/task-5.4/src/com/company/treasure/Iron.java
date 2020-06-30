package com.company.treasure;

public class Iron implements ITreasure{
    private String name = "Железо";
    private int price = 2;          // цена за 1 грамм

    @Override
    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
