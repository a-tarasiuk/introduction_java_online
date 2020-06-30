package com.company.factoryComponentPack;

import com.company.componentPack.ComponentPack;
import com.company.componentPack.Pink;
import com.company.pack.Pack;

public class FactoryPink implements FactoryComponentPack {
    private Pack pack;

    @Override
    public ComponentPack create() {
        return new Pink(pack);
    }

    public FactoryPink(Pack pack){
        this.pack = pack;
    }
}
