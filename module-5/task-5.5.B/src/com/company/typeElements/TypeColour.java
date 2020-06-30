package com.company.typeElements;

public enum TypeColour implements Types {
    BLACK("Черный", 2),
    WHITE("Белый", 1),
    RED("Красный", 3),
    BLUE("Синий", 3),
    PINK("Розовый", 3);

    private final String colour;
    private final int cost;

    TypeColour(String colour, int cost){
        this.colour = colour;
        this.cost = cost;
    }

    @Override
    public String getName(){
        return " " + colour;
    }

    @Override
    public int getCost(){
        return cost;
    }
}
