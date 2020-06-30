package com.company.voucherTypes;

// Лечение

import com.company.food.Food;
import com.company.transport.Transport;

public class Treatment extends Travel{
    private String name = "Лечение";        // Тип путевки
    private int countSanatoriumsVisited;    // Количество предусмотренных санаториев в путевке

    // GET-методы
    @Override
    protected String getName(){
        return name;
    }

    @Override
    protected int getCount(){
        return countSanatoriumsVisited;
    }

    @Override
    public String toString() {
        getInformation(getName(), getCount());
        return "";
    }

    // Конструктор
    public Treatment(int daysTravel, int costTravelAgency, Transport[] transport, Food[] food, int countSanatoriumsVisited){
        super(daysTravel, costTravelAgency, transport, food);
        this.countSanatoriumsVisited = countSanatoriumsVisited;
    }
}
