package com.company.transport;

public class Train extends Transport {
    private int cost;   // плата за проезд данным видом транспорта

    @Override
    protected void setCost(ComfortClass value) {
        if(value == ComfortClass.RESERVED_WAGON)
            this.cost = 25;
        else if(value == ComfortClass.COMMON_WAGON)
            this.cost = 30;
        else throw new IllegalArgumentException("Передан неверный аргумент в классе " + Train.class.getName());
    }

    @Override
    public int getCost(){
        return this.cost;
    }

    // Конструктор
    public Train(String name, int travelTime, ComfortClass value){
        super(name, travelTime);
        setCost(value);
    }
}
