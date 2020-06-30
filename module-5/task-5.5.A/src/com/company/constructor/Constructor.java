package com.company.constructor;

import com.company.builder.Builder;
import com.company.component.Flower;
import com.company.component.Pack;
import com.company.component.Type;

import java.util.Scanner;

public class Constructor extends Message{
    public void constructBouquet(Builder builder){
        constructFlower(builder);
        constructCount(builder);
        constructPack(builder);
    }

    /* Выбираем цветы для букета */
    public void constructFlower(Builder builder){
        Flower[] flowers = Flower.values();
        messageWhatFlowers();
        builder.createFlower((Flower) choiceEnum(flowers));
    }

    /* Выбираем, сколько будет цветов в букете */
    public void constructCount(Builder builder){
        while (true){
            int count;
            messageHowMuch();
            count = new Scanner(System.in).nextInt();
            if(count > 0) {
                builder.createCount(count);
                break;
            }
            else messageErrorChoice();
        }
    }

    /* Выбираем упаковку */
    public void constructPack(Builder builder) {
        Pack[] packs = Pack.values();
        messageWhatPack();
        builder.createPack((Pack) choiceEnum(packs));
    }

    /* Возвращает тип (Flower либо Pack), выбранный пользователем */
    private <T extends Type> Type choiceEnum(T[] flowers){
        int choice;
        for(int i = 0; i < flowers.length; i++)
            System.out.println((i + 1) + ". " + flowers[i].getName() + " (цена за единицу - " + flowers[i].getPrice() + " BYN);");

        while (true){
            messageYourChoice();
            choice = new Scanner(System.in).nextInt();
            if(choice < 1 || choice > flowers.length)
                messageErrorChoice();
            else
                return flowers[choice - 1];
        }
    }
}
