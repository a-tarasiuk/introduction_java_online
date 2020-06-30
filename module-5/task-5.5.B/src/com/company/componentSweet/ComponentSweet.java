package com.company.componentSweet;

import com.company.sweet.Sweet;

public abstract class ComponentSweet extends Sweet {
    public abstract String getDescription();

    public ComponentSweet getComponentSweet(){
        return this;
    }
}
