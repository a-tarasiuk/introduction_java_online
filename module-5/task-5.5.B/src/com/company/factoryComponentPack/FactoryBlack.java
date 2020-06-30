package com.company.factoryComponentPack;

import com.company.componentPack.Black;
import com.company.componentPack.ComponentPack;
import com.company.pack.Pack;

public class FactoryBlack implements FactoryComponentPack {
    private Pack pack;

    @Override
    public ComponentPack create() {
        return new Black(pack);
    }

    public FactoryBlack(Pack pack){
        this.pack = pack;
    }
}
