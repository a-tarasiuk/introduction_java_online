package com.company;

/* Класс - действие, который используется воизбежание дублирования одинакового кода */

import java.util.Random;

public class Actions {
    private String name = "";

    public String EnterName(){
        Random r = new Random();
        for(int i = 0; i < 5 + r.nextInt(15); i++)
            this.name += (char)(65 + r.nextInt(90 - 65 + 1));
        return this.name;
    }
}
