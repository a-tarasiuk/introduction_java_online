package com.company.factoryPack;

import com.company.pack.Box;
import com.company.pack.Pack;

public class FactoryBox implements FactoryPack {
    @Override
    public Pack create() {
        return new Box();
    }
}
