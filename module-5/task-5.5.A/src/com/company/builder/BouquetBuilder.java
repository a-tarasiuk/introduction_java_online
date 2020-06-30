package com.company.builder;

import com.company.bouquet.Bouquet;
import com.company.component.Flower;
import com.company.component.Pack;

public class BouquetBuilder implements Builder{
    private Flower flower;
    private int count;
    private Pack pack;

    @Override
    public void createFlower(Flower flower){
        this.flower = flower;
    }

    @Override
    public void createCount(int count){
        this.count = count;
    }

    @Override
    public void createPack(Pack pack){
        this.pack = pack;
    }

    public Bouquet getBouquet(){
        return new Bouquet(flower, count, pack);
    }
}
