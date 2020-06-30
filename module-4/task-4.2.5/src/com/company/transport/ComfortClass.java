package com.company.transport;

// Уровни комфорта
public enum ComfortClass {
    // Для автобуса
    BASE,                   // Базовый
    AVERAGE,                // Средний
    HIGHER,                 // Высший

    // Для поезда
    RESERVED_WAGON,         // Плацкартный вагон
    COMMON_WAGON,           // Общий вагон

    // Для самолета
    ECONOMY_CLASS,          // Эконом-класс
    BUSINESS_CLASS,         // Бизнес-класс
    FIRST_CLASS,            // Первый класс

    // Для корабля
    COMMON_PLACE,           // Общее место
    CABIN,                  // Каюта
    VIP_LODGE               // VIP ложа
}
