package com.company.sweet;

import com.company.typeElements.TypeSweet;

public class Chocolate extends Sweet{
    private TypeSweet typeSweet = TypeSweet.CHOCOLATE;

    public Chocolate(){
        super.setDescription(typeSweet.getName());
    }

    @Override
    public int getCost(){
        return typeSweet.getCost();
    }
}
