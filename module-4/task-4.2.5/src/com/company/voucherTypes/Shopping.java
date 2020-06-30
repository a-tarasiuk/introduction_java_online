package com.company.voucherTypes;

// Шопинг

import com.company.food.Food;
import com.company.transport.Transport;

public class Shopping extends Travel{
    private String name = "Шопинг";     // Тип путевки
    private int countStoreVisited;      // Количество предусмотренных магазинов в путевке

    // GET-методы
    @Override
    protected String getName(){
        return name;
    }

    @Override
    protected int getCount(){
        return countStoreVisited;
    }

    @Override
    public String toString() {
        getInformation(getName(), getCount());
        return "";
    }

    // Конструктор
    public Shopping(int daysTravel, int costTravelAgency, Transport[] transport, Food[] food, int countStoreVisited){
        super(daysTravel, costTravelAgency, transport, food);
        this.countStoreVisited = countStoreVisited;
    }
}
