package com.company.factoryComponentSweet;

import com.company.componentSweet.ComponentSweet;
import com.company.componentSweet.Nuts;
import com.company.sweet.Sweet;

public class FactoryNuts implements FactoryComponentSweet{
    private Sweet sweet;

    @Override
    public ComponentSweet create() {
        return new Nuts(sweet);
    }

    public FactoryNuts(Sweet sweet){
        this.sweet = sweet;
    }
}
