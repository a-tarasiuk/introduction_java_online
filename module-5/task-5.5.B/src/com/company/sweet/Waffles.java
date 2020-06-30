package com.company.sweet;

import com.company.typeElements.TypeSweet;

public class Waffles extends Sweet {
    private TypeSweet typeSweet = TypeSweet.WAFFLES;

    public Waffles(){
        super.setDescription(typeSweet.getName());
    }

    @Override
    public int getCost(){
        return typeSweet.getCost();
    }
}
