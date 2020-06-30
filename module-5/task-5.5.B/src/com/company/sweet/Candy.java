package com.company.sweet;

import com.company.typeElements.TypeSweet;

public class Candy extends Sweet{
    private TypeSweet typeSweet = TypeSweet.CANDY;

    public Candy(){
        super.setDescription(typeSweet.getName());
    }

    @Override
    public int getCost(){
        return typeSweet.getCost();
    }
}
