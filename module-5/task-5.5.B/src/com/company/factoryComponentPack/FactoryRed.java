package com.company.factoryComponentPack;

import com.company.componentPack.ComponentPack;
import com.company.componentPack.Red;
import com.company.pack.Pack;

public class FactoryRed implements FactoryComponentPack {
    private Pack pack;

    @Override
    public ComponentPack create() {
        return new Red(pack);
    }

    public FactoryRed(Pack pack){
        this.pack = pack;
    }
}
