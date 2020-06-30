package com.company.pack;

public abstract class Pack {
    private String name;        // тип упаковки

    public void setType(String type){
        this.name = type;
    }

    public String getDescription(){
        return name;
    }

    public abstract int getCost();
}
