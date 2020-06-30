package com.company.factoryComponentPack;

import com.company.componentPack.Blue;
import com.company.componentPack.ComponentPack;
import com.company.pack.Pack;

public class FactoryBlue implements FactoryComponentPack {
    private Pack pack;

    @Override
    public ComponentPack create() {
        return new Blue(pack);
    }

    public FactoryBlue(Pack pack){
        this.pack = pack;
    }
}
