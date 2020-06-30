package com.company.voucherTypes;

// Отдых

import com.company.food.Food;
import com.company.transport.Transport;

public class Relaxation extends Travel{
    private String  name = "Отдых";     // Тип путевки
    private int     countBeachVisited;  // Количество предусмотренных пляжей в путевке

    // GET-методы
    @Override
    protected String getName(){
        return name;
    }

    @Override
    protected int getCount(){
        return countBeachVisited;
    }

    @Override
    public String toString() {
        getInformation(getName(), getCount());
        return "";
    }

    // Конструктор
    public Relaxation(int daysTravel, int costTravelAgency, Transport[] transport, Food[] food, int countBeachVisited){
        super(daysTravel, costTravelAgency, transport, food);
        this.countBeachVisited = countBeachVisited;
    }
}
