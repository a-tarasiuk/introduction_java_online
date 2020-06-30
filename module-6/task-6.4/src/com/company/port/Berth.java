package com.company.port;

import com.company.port.types.SizeBerth;
import com.company.ship.ShipGenerator;
import com.company.ship.Ship;
import com.company.ship.types.SizeShip;

import java.util.Random;

/**
 *  Причал
 */

public class Berth implements Runnable {
    {id++;}

    private static int id;
    private final String NAME;
    private final ShipGenerator generator;
    private final SizeBerth size;

    public Berth(ShipGenerator generator){
        this.NAME = "Berth " + id;
        this.generator = generator;
        this.size = getRandomSizeBerth();
        System.out.println("\n" + this.NAME + " was created!" +
                "\nSize: " + size.toString() +
                "\nCarrying capacity: " + size.getValue() + " (units)");
        new Thread(this, NAME).start();
    }

    @Override
    public void run() {
        while (true){
            Ship ship = generator.getShip();

            // проверяем, если корабль прибыл пустой - погружаем в корабль товар
            if(!ship.isFull()) {
                // корабль прибыл к причалу для загрузки - IN
                getMessageLoaded("[IN FOR LOADING]", ship.getName(), ship.getNowGoods(), ship.getMaxGoods(), this.NAME);

                while (!ship.isFull()){
                    ship.add(size.getValue());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // корабль загружается
                    getMessageLoaded("[+]", ship.getName(), ship.getNowGoods(), ship.getMaxGoods(), this.NAME);
                }
            }
            // если корабль прибыл полный, то осуществляем разгрузку товара
            else {
                // корабль прибыл к причалу для выгрузки - OUT
                getMessageUnloaded("[IN FOR UNLOADING]", ship.getName(), ship.getNowGoods(), ship.getMaxGoods(), this.NAME);
                while (!ship.isEmpty()){
                    ship.unload(size.getValue());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // корабль разгружается
                    getMessageUnloaded("[-]", ship.getName(), ship.getNowGoods(), ship.getMaxGoods(), this.NAME);
                }
            }
            // корабль убывает от причала
            getMessageUnloaded("[OUT]", ship.getName(), ship.getNowGoods(), ship.getMaxGoods(), this.NAME);
            generator.addShip(ship);
        }
    }

    private SizeBerth getRandomSizeBerth(){
        return SizeBerth.values()[new Random().nextInt(SizeShip.values().length - 1)];
    }

    private void getMessageLoaded(String parameter, String shipName, int nowGoods, int maxGoods, String berthName){
        System.out.format("\n%-20s %-6s (loaded   %-2d out of %-2d) in %-6s", parameter, shipName, nowGoods, maxGoods, berthName);
    }

    private void getMessageUnloaded(String parameter, String shipName, int nowGoods, int maxGoods, String berthName){
        System.out.format("\n%-20s %-6s (unloaded %-2d out of %-2d) in %-6s", parameter, shipName, nowGoods, maxGoods, berthName);
    }
}


