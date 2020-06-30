package com.company.factorySweet;

import com.company.sweet.Chocolate;
import com.company.sweet.Sweet;

public class FactoryChocolate implements FactorySweet {
    @Override
    public Sweet create() {
        return new Chocolate();
    }
}
