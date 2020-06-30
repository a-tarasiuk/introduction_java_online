package com.company.typeElements;

public enum TypeSweet implements Types {
    CANDY("Конфеты", 5),
    CHOCOLATE("Шоколад", 10),
    WAFFLES("Вафли", 7);

    private final String name;
    private final int cost;

    TypeSweet(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getCost(){
        return cost;
    }
}
