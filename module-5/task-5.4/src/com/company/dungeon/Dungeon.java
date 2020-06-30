package com.company.dungeon;

import com.company.actions.ActionsDungeon;

public class Dungeon extends ActionsDungeon {
    private String name;

    @Override
    public String toString(){
        return "Поздравляем! Создано подземелье: " + name;
    }

    public Dungeon(String name){
        super();
        this.name = name;
    }
}
