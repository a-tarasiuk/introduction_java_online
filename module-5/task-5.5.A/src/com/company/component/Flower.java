package com.company.component;

/**
 * Цветки.
 * Переменная "name" - название цветка.
 * Переменная 'priceForOne" - цена за 1 штуку.
 */

public enum Flower implements Type{

    CHAMOMILE(){
        final String name = "Ромашка";
        final int priceForOne = 3;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return priceForOne;
        }
    },

    LILY() {
        final String name = "Лилия";
        final int priceForOne = 7;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return priceForOne;
        }
    },

    ORCHID() {
        final String name = "Орхидея";
        final int priceForOne = 8;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return priceForOne;
        }
    },

    ROSE() {
        final String name = "Роза";
        final int priceForOne = 5;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return priceForOne;
        }
    },

    TULIP() {
        final String name = "Тюльпан";
        final int priceForOne = 3;

        public String getName(){
            return name;
        }

        public int getPrice(){
            return priceForOne;
        }
    };

    @Override
    public String toString(){
        return "\nТип цветка: " + getName()
                + "\nЦена за 1 цветок - " + getPrice() + " BYN.";
    }

}
