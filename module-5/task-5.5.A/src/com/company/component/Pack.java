package com.company.component;

/**
 * Упаковка.
 * Переменная "name" - тип упаковки.
 * Переменная 'priceForOne" - цена за упаковку.
 */

public enum  Pack implements Type{
    PAPER_CRAFT{
        final String name = "Крафт бумага";
        final int price = 3;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return price;
        }
    },

    PAPER_SIMPLE{
        final String name = "Простая бумага";
        final int price = 2;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return price;
        }
    },

    BOX{
        final String name = "Коробка в форме сердца";
        final int price = 7;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return price;
        }
    },

    CELLOPHANE{
        final String name = "Целлофан";
        final int price = 1;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return price;
        }
    },

    WITHOUT {
        final String name = "Без упаковки";
        final int price = 0;

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    };

    @Override
    public String toString(){
        return "\nТип упаковки: " + getName()
                + "\nЦена за упаковку - " + getPrice() + " BYN.";
    }

}
