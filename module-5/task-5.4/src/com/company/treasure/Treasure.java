package com.company.treasure;

import java.util.ArrayList;

public class Treasure{
    {id_generator++;}

    private static int id_generator;
    private int id;
    private int cost;
    private ArrayList<Coin> coins;

    private void createTreasure(){
        for(int i = 0; i < (int)(1 + Math.random() * 20); i++)
            coins.add(new Coin());

        calculateCost();
    }

    private void calculateCost(){
        for(Coin coin : coins)
            cost += coin.getPrice();
    }

    public int getId(){
        return this.id;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public String toString(){
        String result = "\nСокровище № " + id + ", общей стоимостью - " + getCost() + " $, состоит из:\n";

        for(Coin coin : coins) {
            result = result.concat(coin.toString());
        }

        return result;
    }

    public String getInformationOnlyCost(){
        return "\nСокровище № " + id + ", общей стоимостью - " + getCost() + " $";
    }

    public Treasure(){
        id = id_generator;
        coins = new ArrayList<>();
        createTreasure();
    }
}
