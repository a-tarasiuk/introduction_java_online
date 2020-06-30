package com.company.food;

// Еда

import java.util.ArrayList;

public class Food implements Comparable<Food> {
    private int     totalCost = 0;                    // Полная стоимость еды ($)
    private boolean breakfast,
                    lunch,
                    dinner,
                    supper,
                    alcohol;

    @Override
    public int compareTo(Food arg) {
        return Integer.compare(totalCost, arg.totalCost);
    }

    private void setTotalCost(){
        totalCost = 0;
        if(Ration.BREAKFAST.isInclude() == breakfast)   totalCost += Ration.BREAKFAST.getCost();
        if(Ration.LUNCH.isInclude() == lunch)           totalCost += Ration.LUNCH.getCost();
        if(Ration.DINNER.isInclude() == dinner)         totalCost += Ration.DINNER.getCost();
        if(Ration.SUPPER.isInclude() == supper)         totalCost += Ration.SUPPER.getCost();
        if(Ration.ALCOHOL.isInclude() == alcohol)       totalCost += Ration.ALCOHOL.getCost();
    }

    public int getTotalCost(){
        return this.totalCost;
    }

    public ArrayList<String> getRation(){
        ArrayList<String> value = new ArrayList<>();
        if(Ration.BREAKFAST.isInclude() == breakfast)   value.add(Ration.BREAKFAST.getName() + " - " + Ration.BREAKFAST.getCost() + " $");
        if(Ration.LUNCH.isInclude() == lunch)           value.add(Ration.LUNCH.getName() + " - " + Ration.BREAKFAST.getCost() + " $");
        if(Ration.DINNER.isInclude() == dinner)         value.add(Ration.DINNER.getName() + " - " + Ration.BREAKFAST.getCost() + " $");
        if(Ration.SUPPER.isInclude() == supper)         value.add(Ration.SUPPER.getName() + " - " + Ration.BREAKFAST.getCost() + " $");
        if(Ration.ALCOHOL.isInclude() == alcohol)       value.add(Ration.ALCOHOL.getName() + " - " + Ration.BREAKFAST.getCost() + " $");
        return value;
    }

    // Конструктор
    public Food(boolean breakfast, boolean lunch, boolean dinner, boolean supper, boolean alcohol){
        this.breakfast  = breakfast;
        this.lunch      = lunch;
        this.dinner     = dinner;
        this.supper     = supper;
        this.alcohol    = alcohol;
        setTotalCost();
    }
}

enum Ration {
    BREAKFAST("Завтрак", 10, true),
    LUNCH("Обед", 10, true),
    DINNER("Ужин", 10, true),
    SUPPER("Прием пищи перед сном", 10, true),
    ALCOHOL("Алкоголь", 15, true);

    private String  name;       // Тип рациона
    private int     cost;       // Стоимость типа рациона
    private boolean include;    // Тип рациона включен в меню

    public String getName(){
        return this.name;
    }

    public int getCost(){
        return this.cost;
    }

    public boolean isInclude(){
        return this.include;
    }

    Ration(String name, int cost, boolean include){
        this.name = name;
        this.cost = cost;
        this.include = include;
    }
}