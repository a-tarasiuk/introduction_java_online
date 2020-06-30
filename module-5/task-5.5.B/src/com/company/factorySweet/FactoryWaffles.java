package com.company.factorySweet;

import com.company.sweet.Sweet;

public class FactoryWaffles implements FactorySweet {
    @Override
    public Sweet create() {
        return new com.company.sweet.Waffles();
    }
}
