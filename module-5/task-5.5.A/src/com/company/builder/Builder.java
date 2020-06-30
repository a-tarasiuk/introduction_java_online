package com.company.builder;

import com.company.component.Flower;
import com.company.component.Pack;

/**
 * Интерфейс.
 * Определяет все шаги создания букета.
 */

public interface Builder {
    void createFlower(Flower flower);   // создать цветы
    void createCount(int count);        // количество цветов в букете
    void createPack(Pack pack);         // создать упаковку
}
