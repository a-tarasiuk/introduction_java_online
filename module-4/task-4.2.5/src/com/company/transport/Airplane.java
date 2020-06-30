package com.company.transport;

public class Airplane extends Transport {
    private int payment;   // плата за проезд данным видом транспорта

    @Override
    public int getCost(){
        return this.payment;
    }

    @Override
    protected void setCost(ComfortClass value) {
        if(value == ComfortClass.ECONOMY_CLASS)
            this.payment = 50;
        else if(value == ComfortClass.BUSINESS_CLASS)
            this.payment = 55;
        else if(value == ComfortClass.FIRST_CLASS)
            this.payment = 60;
        else throw new IllegalArgumentException("Передан неверный аргумент в классе " + Airplane.class.getName());
    }

    // Конструктор
    public Airplane(String name, int travelTime, ComfortClass value){
        super(name, travelTime);
        setCost(value);
    }
}
