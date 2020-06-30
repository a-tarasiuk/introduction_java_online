package com.company.port.types;

public enum  SizeBerth {
    SMALL(5),
    MEDIUM(10);

    private int value;

    SizeBerth(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
