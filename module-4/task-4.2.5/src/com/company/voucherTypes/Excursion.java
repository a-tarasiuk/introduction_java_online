package com.company.voucherTypes;

// Экскурсия

import com.company.food.Food;
import com.company.transport.Transport;

public class Excursion extends Travel{
    private String  name = "Экскурсия";     // Тип путевки
    private int     countLionsVisited;      // Количество предусмотренных достопримещательностей в путевке

    // GET-методы
    @Override
    protected String getName(){
        return name;
    }

    @Override
    protected int getCount(){
        return countLionsVisited;
    }

    @Override
    public String toString() {
        getInformation(getName(), getCount());
        return "";
    }

    // Конструктор
    public Excursion(int daysTravel, int costTravelAgency, Transport[] transport, Food[] food, int countLionsVisited){
        super(daysTravel, costTravelAgency, transport, food);
        this.countLionsVisited = countLionsVisited;
    }
}
