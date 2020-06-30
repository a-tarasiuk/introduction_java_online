package com.company.transport;

public class Bus extends Transport {

    private int payment;   // плата за проезд данным видом транспорта

    @Override
    public int getCost(){
        return this.payment;
    }

    @Override
    protected void setCost(ComfortClass value) {
        if(value == ComfortClass.BASE)
            this.payment = 10;
        else if(value == ComfortClass.AVERAGE)
            this.payment = 15;
        else if(value == ComfortClass.HIGHER)
            this.payment = 20;
        else throw new IllegalArgumentException("Передан неверный аргумент в классе " + Bus.class.getName());
    }

    // Конструктор
    public Bus(String name, int travelTime, ComfortClass value){
        super(name, travelTime);
        setCost(value);
    }

}

