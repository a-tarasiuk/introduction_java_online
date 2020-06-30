package com.company.bouquet;

import com.company.component.Flower;
import com.company.component.Pack;

/**
 * Букет - это класс продукта.
 */

public class Bouquet {
    private final Flower flower;
    private final int count;
    private final Pack pack;
    private int totalPrice;

    public Bouquet(Flower flower, int count, Pack pack){
        this.flower = flower;
        this.count = count;
        this.pack = pack;
        totalPrice = flower.getPrice() * count + pack.getPrice();
    }

    @Override
    public String toString(){
        String result = "\nИтого получилось:"
                + flower
                + "\nКоличество цветов - " + count
                + pack
                + "\nОбщая стоимость букета: " + totalPrice + " BYN.";
        return result;
    }

}
