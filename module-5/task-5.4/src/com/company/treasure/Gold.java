package com.company.treasure;

public class Gold implements ITreasure{
    private String name = "Золото";
    private int price = 100;          // цена за 1 грамм

    @Override
    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }
}
