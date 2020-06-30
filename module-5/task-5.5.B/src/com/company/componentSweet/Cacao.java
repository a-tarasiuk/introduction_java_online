package com.company.componentSweet;

import com.company.sweet.Sweet;
import com.company.typeElements.TypeFilling;

public class Cacao extends ComponentSweet{
    private Sweet sweet;
    private static Cacao cacao;
    private TypeFilling typeFilling = TypeFilling.CACAO;

    public Cacao(Sweet sweet){
        this.sweet = sweet;
    }

    @Override
    public String getDescription(){
        return sweet.getDescription() + " + " + typeFilling.getName();
    }

    @Override
    public int getCost(){
        return sweet.getCost() + typeFilling.getCost();
    }
}
