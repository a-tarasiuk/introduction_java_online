package com.company.componentPack;

import com.company.pack.Pack;
import com.company.typeElements.TypeColour;

public class Pink extends ComponentPack {
    private Pack pack;
    private TypeColour typeColour = TypeColour.PINK;

    public Pink(Pack pack){
        this.pack = pack;
    }

    @Override
    public String getDescription(){
        return pack.getDescription() + " (цвет - " + typeColour.getName() + ")";
    }

    @Override
    public int getCost(){
        return pack.getCost() + typeColour.getCost();
    }
}
