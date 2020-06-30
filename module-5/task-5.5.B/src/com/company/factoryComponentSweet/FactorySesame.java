package com.company.factoryComponentSweet;

import com.company.componentSweet.ComponentSweet;
import com.company.componentSweet.Sesame;
import com.company.sweet.Sweet;

public class FactorySesame implements FactoryComponentSweet {
    private Sweet sweet;

    @Override
    public ComponentSweet create() {
        return new Sesame(sweet);
    }

    public FactorySesame(Sweet sweet){
        this.sweet = sweet;
    }
}
