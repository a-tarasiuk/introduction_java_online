package com.company.typeElements;

public enum  TypePack implements Types{
    BOX("Коробка", 3),
    PACKAGE("Пакет", 1);

    private final String name;
    private final int cost;

    TypePack(String name, int cost){
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
