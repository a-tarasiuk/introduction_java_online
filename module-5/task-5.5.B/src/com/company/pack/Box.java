package com.company.pack;

import com.company.typeElements.TypePack;

public class Box extends Pack{
    TypePack typePack = TypePack.BOX;

    public Box(){
        super.setType(typePack.getName());
    }

    @Override
    public int getCost(){
        return typePack.getCost();
    }
}
