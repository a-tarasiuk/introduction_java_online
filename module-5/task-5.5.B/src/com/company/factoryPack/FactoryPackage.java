package com.company.factoryPack;

import com.company.pack.Pack;
import com.company.pack.Package;

public class FactoryPackage implements FactoryPack {
    @Override
    public Pack create() {
        return new Package();
    }
}
