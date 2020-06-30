package com.company.ship;

import com.company.ship.types.SizeShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipGenerator {
    private final int MAX_SHIPS = 5 + (int)(Math.random() * 5);
    private final List<Ship> ships = new ArrayList<Ship>();

    public ShipGenerator(){
        createShips();
    }

    public synchronized Ship getShip(){
        try {
            for(Ship ship : ships){
                notifyAll();
                ships.remove(ship);
                return ship;
            }
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void addShip(Ship ship){
        try {
            notifyAll();
            ships.add(ship);
            wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createShips(){
        // создаем рандомное количество кораблей в диапазоне
        for(int i = 0; i < MAX_SHIPS; i++) {
            ships.add(new Ship(getRandomSizeShip()));
        }
    }

    private SizeShip getRandomSizeShip(){
        Random random = new Random();
        return SizeShip.values()[random.nextInt(SizeShip.values().length)];
    }

    public int getTotalCapacity(){
        int totalCapacity = 0;
        for(Ship ship : ships)
            totalCapacity += ship.getMaxGoods();
        return totalCapacity;
    }
}
