package com.company.transport;

public class Ship extends Transport {
    private int payment;   // плата за проезд данным видом транспорта

    @Override
    public int getCost(){
        return this.payment;
    }

    @Override
    protected void setCost(ComfortClass value) {
        if(value == ComfortClass.COMMON_PLACE)
            this.payment = 65;
        else if(value == ComfortClass.CABIN)
            this.payment = 70;
        else if(value == ComfortClass.VIP_LODGE)
            this.payment = 75;
        else throw new IllegalArgumentException("Передан неверный аргумент в классе " + Ship.class.getName());
    }

    // Конструктор
    public Ship(String name, int travelTime, ComfortClass value){
        super(name, travelTime);
        setCost(value);
    }
}
