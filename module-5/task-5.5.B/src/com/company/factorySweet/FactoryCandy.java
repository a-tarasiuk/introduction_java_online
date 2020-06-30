package com.company.factorySweet;

import com.company.sweet.Candy;
import com.company.sweet.Sweet;

public class FactoryCandy implements FactorySweet{
    @Override
    public Sweet create() {
        return new Candy();
    }
}
