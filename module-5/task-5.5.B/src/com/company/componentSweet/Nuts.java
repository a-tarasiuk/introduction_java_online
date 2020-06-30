package com.company.componentSweet;

import com.company.sweet.Sweet;
import com.company.typeElements.TypeFilling;

public class Nuts extends ComponentSweet{
    private Sweet sweet;
    private TypeFilling typeFilling = TypeFilling.NUTS;

    public Nuts(Sweet sweet){
        this.sweet = sweet;
    }

    @Override
    public String getDescription(){
        return sweet.getDescription() + " + " + typeFilling.getName();
    }

    @Override
    public int getCost(){
        return sweet.getCost() + typeFilling.getCost();
    }
}
