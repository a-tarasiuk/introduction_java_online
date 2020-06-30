package com.company.treasure;

/* Сокровище состоит из n-количества монет.
 * Монета, в свою очередь, состоит из %-золота, %-серебра, %-железа
 */

public class Coin implements ITreasure{
    private int     price;                 // цена монеты (зависит от веса и элементов, из которых она состоит)
    private Gold    gold;
    private Silver  silver;
    private Iron    iron;
    private int     weightGold;            // процентное соотношение золота в монете
    private int     weightSilver;          // процентное соотношение серебра в монете
    private int     weightIron;            // процентное соотношение железа в монете

    @Override
    public int getPrice() {
        return this.price;
    }

    private int getWeight(){
        return weightGold + weightSilver + weightIron;
    }

    @Override
    public String toString(){
        return "Монета обшим весом - " + this.getWeight() + " гр. " +
                "(Состав: " +
                gold.getName() + " - " + weightGold + " гр., " +
                silver.getName() + " - " + weightSilver + " гр., " +
                iron.getName() + " - " + weightIron + " гр.). " +
                "Цена - " + this.getPrice() + " $\n";
    }

    public Coin(){
        gold =      new Gold();
        silver =    new Silver();
        iron =      new Iron();

        weightGold =    (int)(1 + Math.random() * 100);
        weightSilver =  (int)(1 + Math.random() * 100);
        weightIron =    (int)(1 + Math.random() * 100);

        price = weightGold * gold.getPrice() + weightSilver * silver.getPrice() + weightIron * iron.getPrice();
    }
}
