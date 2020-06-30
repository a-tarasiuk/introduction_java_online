package com.company.ship.types;

/**
 * Перечисление - SizeShip.
 * Тут задается вместимость судна.
 */

public enum SizeShip {
    SMALL(20),
    MEDIUM(30),
    LARGE(40);

    private int value;

    SizeShip(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
