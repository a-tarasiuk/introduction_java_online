package com.company.voucherTypes;

// Круиз

import com.company.food.Food;
import com.company.transport.Transport;

public class Cruise extends Travel{
    private String  name = "Круиз";     // Тип путевки
    private int     countPortsVisited;  // Количество предусмотренных портов в путевке

    // GET-методы
    @Override
    protected String getName(){
        return name;
    }

    @Override
    protected int getCount(){
        return countPortsVisited;
    }

    @Override
    public String toString() {
        getInformation(getName(), getCount());
        return "";
    }

    // Конструктор
    public Cruise(int daysTravel, int costTravelAgency, Transport[] transport, Food[] food, int countPortsVisited){
        super(daysTravel, costTravelAgency, transport, food);
        this.countPortsVisited = countPortsVisited;
    }
}
