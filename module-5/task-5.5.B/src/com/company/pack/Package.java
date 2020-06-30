package com.company.pack;

import com.company.typeElements.TypePack;

public class Package extends Pack {
    TypePack typePack = TypePack.PACKAGE;

    public Package(){
        super.setType(typePack.getName());
    }

    @Override
    public int getCost(){
        return typePack.getCost();
    }
}
