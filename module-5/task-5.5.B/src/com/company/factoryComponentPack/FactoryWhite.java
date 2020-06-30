package com.company.factoryComponentPack;

import com.company.componentPack.ComponentPack;
import com.company.componentPack.White;
import com.company.pack.Pack;

public class FactoryWhite implements FactoryComponentPack {
    private Pack pack;

    @Override
    public ComponentPack create() {
        return new White(pack);
    }

    public FactoryWhite(Pack pack){
        this.pack = pack;
    }
}
