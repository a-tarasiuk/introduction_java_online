package com.company.port;

import com.company.ship.ShipGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Порт.
 * Порт состоит из 3-х причалов.
 */

public class Port {
    private final String NAME = "GOLD START";
    private int maxLoadGoods;

    public Port(){
        System.out.println("# port " + NAME + " was created!");
    }

    public void start(){
        ShipGenerator shipGenerator = new ShipGenerator();

        maxLoadGoods = shipGenerator.getTotalCapacity() * 2;

        List<Berth> berths = createBerths(shipGenerator);

        System.out.println("\nTOTAL BERTHS: " + berths.size());
        // максимальная вместимость корабелй
        System.out.println("MAX SHIPS CAPACITY: " + shipGenerator.getTotalCapacity() + " (units)\n");
    }

    private List<Berth> createBerths(ShipGenerator shipGenerator){
        // создаем рандомное количество причалов
        int maxBerths = 3 + (int)(Math.random() * 3);
        // список причалов
        List<Berth> berths = new ArrayList<Berth>();
        // добавляем причалы в список
        for(int i = 0; i < maxBerths; i++)
            berths.add(new Berth(shipGenerator));

        return berths;
    }
}
