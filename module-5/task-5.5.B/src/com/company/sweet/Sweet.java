package com.company.sweet;

public abstract class Sweet {
    private String name;     // название сладости

    protected void setDescription(String description){
        this.name = description;
    }

    public String getDescription(){
        return name;
    }

    public abstract int getCost();

}