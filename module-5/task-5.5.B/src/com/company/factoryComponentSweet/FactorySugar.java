package com.company.factoryComponentSweet;

import com.company.componentSweet.ComponentSweet;
import com.company.componentSweet.Sugar;
import com.company.sweet.Sweet;

public class FactorySugar implements FactoryComponentSweet {
    private Sweet sweet;

    @Override
    public ComponentSweet create() {
        return new Sugar(sweet);
    }

    public FactorySugar(Sweet sweet){
        this.sweet = sweet;
    }
}
