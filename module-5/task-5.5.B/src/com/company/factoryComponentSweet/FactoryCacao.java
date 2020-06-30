package com.company.factoryComponentSweet;

import com.company.componentSweet.Cacao;
import com.company.componentSweet.ComponentSweet;
import com.company.sweet.Sweet;

public class FactoryCacao implements FactoryComponentSweet {
    private Sweet sweet;

    @Override
    public ComponentSweet create() {
        return new Cacao(sweet);
    }

    public FactoryCacao(Sweet sweet){
        this.sweet = sweet;
    }
}
