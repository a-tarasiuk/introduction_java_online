package com.company;

// Г О С У Д А Р С Т В О

import java.util.ArrayList;
import java.util.Scanner;

public class State {
    private String              name;                   // название государства
    private int                 square,                 // площадь государства
                                numberRegion;           // кол-во регионов
    private boolean             ifTheCapital = false;   // назначена ли уже столица

    private ArrayList<Region>   region = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public String getName(){
        return this.name;
    }

    public int getSquare(){
        for(int i = 0; i < region.size(); i++)
            square += region.get(i).getSquare();
        return square;
    }

    public ArrayList<Region> getRegion(){
        return region;
    }

    public int getNumberRegion(){
        return this.numberRegion;
    }

    public void setNumberRegion(){
        while (true){
            this.numberRegion = scanner.nextInt();
            if(this.numberRegion < 1 || this.numberRegion == '\n')
                System.out.print("\n[ОШИБКА] Должна быть хотя бы одна область.\n" +
                        "Повторите ввод: ");
            else return;
        }
    }

    public void addRegion(){
        region.add(new Region());
    }

    // назначена ли столица (false - нет, true - да)
    public boolean ifTheCapital(){
        ifTheCapital = false;
        for(int i = 0; i < region.size(); i++)
            for(int j = 0; j < region.get(i).getDistrict().size(); j++)
                for(int k = 0; k < region.get(i).getDistrict().get(j).getTown().size(); k++) {
                    if (ifTheCapital = region.get(i).getDistrict().get(j).getTown().get(k).getCapital()) {
                        j = region.get(i).getDistrict().size();
                        i = region.size() - 1;
                        break;
                    }
                }
        return ifTheCapital;
    }

    State(){
        while (true){
            this.name = scanner.nextLine();
            if (this.name.trim().length() != 0)
                return;
            System.out.print("\n[ОШИБКА] Название государства не может быть пустым полем.\n" +
                    "Повторите ввод: ");
        }
    }

}
