package com.company.transport;

public abstract class Transport implements Comparable<Transport>{
    private String  name;               // название вида транспорта
    private int     travelTime;         // время в пути (дней)

    @Override
    public int compareTo(Transport arg) {
        return Integer.compare(getCost(), arg.getCost());
    }

    // SET-методы
    // Задание стоимости переезда в зависимости от уровня комфорта
    protected abstract void setCost(ComfortClass value);

    // GET-методы
    // Получить стоимость поездки
    public abstract int getCost();

    // Получить время в тупи данным видом транспорта
    public int getTravelTime(){
        return travelTime;
    }

    // Получить название вида транспорта
    public String getName(){
        return this.name;
    }

    // Конструктор
    public Transport(String name, int travelTime){
        this.name = name;
        this.travelTime = travelTime;
    }
}
