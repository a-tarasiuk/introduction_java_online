package com.company;

public class Main {

    public static void main(String[] args) {
        Payment payment1 = new Payment();
        payment1.addProduct("Зубная щетка", 10);
        payment1.addProduct("Зубная паста", 5);
        payment1.addProduct("Мыло", 2);
        payment1.getInformation();

        Payment payment2 = new Payment();
        payment2.addProduct("Гель для душа", 10);
        payment2.addProduct("Стиральный порошок", 20);
        payment2.addProduct("Белый пористый шоколад", 30);
        payment2.getInformation();
    }
}
