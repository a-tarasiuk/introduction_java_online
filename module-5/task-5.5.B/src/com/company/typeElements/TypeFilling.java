package com.company.typeElements;

public enum TypeFilling implements Types{
    CACAO("Какао (10 грамм)", 1),
    NUTS("Арахис (10 грамм)", 1),
    SESAME("Кунжут (10 грамм)", 1),
    SUGAR("Сахар (10 грамм)", 1);

    private final String filling;
    private final int cost;

    TypeFilling(String filling, int cost){
        this.filling = filling;
        this.cost = cost;
    }

    @Override
    public String getName(){
        return " " + filling;
    }

    @Override
    public int getCost(){
        return cost;
    }
}
