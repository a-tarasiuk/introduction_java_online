package com.company;

import com.company.food.Food;
import com.company.transport.*;
import com.company.voucherTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main extends Message{
    // Главное меню
    public static void menuMain(Scanner scanner, Travel[] travels){
        while (true){
            int key = 0;
            messageMain();
            messageChoice();
            key = scanner.nextInt();

            switch (key){
                case 0:
                    System.out.println("\n\tЗавершение программы...");
                    return;
                case 1:
                    for(Travel value : travels) {
                        System.out.print(value.toString());
                        value.getCombinations();
                    }
                    break;
                case 2:
                    menuSort(scanner, travels);
                    break;
                default:
                    errorChoiceMessage();
            }
        }
    }

    // Сортировка путевок
    public static void menuSort(Scanner scanner, Travel[] travels){
        while (true){
            int key = 0;
            messageSort();
            messageChoice();
            key = scanner.nextInt();
            switch (key){
                case 0:
                    System.out.println("\n\tВозврат в главное меню...");
                    return;
                case 1:
                    menuCostTravel(scanner, travels);
                    break;
                default:
                    errorChoiceMessage();
            }
        }
    }

    // По стоимости путевки
    public static void menuCostTravel(Scanner scanner, Travel[] travels){
        while (true){
            int key = 0;
            messageRank();
            messageChoice();
            key = scanner.nextInt();
            switch (key){
                case 0:
                    System.out.println("\n\tВозврат в главное меню...");
                    return;
                case 1:
                    lowCostTravel(travels);
                    break;
                case 2:
                    highCostTravel(travels);
                    break;
                case 3:
                    rangeCostTravel(scanner, travels);
                    break;
                default:
                    errorChoiceMessage();
            }
        }
    }

    // Сортировка по стоимости путевки (сначала дешевые)
    public static void lowCostTravel(Travel[] travels){
        Arrays.sort(travels);
        for(Travel value : travels)
            System.out.println(value.toString());
    }

    // Сортировка по стоимости путевки (сначала дорогие)
    public static void highCostTravel(Travel[] travels){
        Arrays.sort(travels, Collections.reverseOrder());
        for(Travel value : travels)
            System.out.println(value.toString());
    }

    // Сортировка по стоимости путевки (диапазон)
    public static void rangeCostTravel(Scanner scanner, Travel[] travels){
        boolean isBreak     = true;
        int     minValue      = 0,
                maxValue      = 0;
        messageMinDiapason();
        minValue = scanner.nextInt();

        // Проверка, чтобы максимальное значение было больше минимального
        while (true){
            messageMaxDiapason();
            maxValue = scanner.nextInt();
            if(maxValue < minValue)
                messageWrongDiapason();
            else break;
        }

        for (Travel t : travels){
            for(ArrayList<Integer> cost : t.getCostCombinations())
                if(cost.get(2) >= minValue && cost.get(2) <= maxValue) {
                    isBreak = false;
                    System.out.print(t.toString());
                    messageCombinations(t.getTransport(cost.get(0)), t.getFood(cost.get(1)), t.getCountDays(), t.getCostTravelAgency());
                }
        }

        if(isBreak)
            messageDiapasonNotFound(minValue, maxValue);

    }

    // Сортировка по стоимости транспорта (сначала дешевые)
    public static void lowCostTransport(Travel[] travels){

    }

    // Сортировка по стоимости транспорта (сначала дорогие)
    public static void highCostTransport(Travel[] travels){

    }

    // Сортировка по стоимости рациона питания (сначала дешевые)
    public static void lowCostFood(Travel[] travels){

    }

    // Сортировка по стоимости рациона питания (сначала дорогие)
    public static void highCostFood(Travel[] travels){

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Конструктор самолетов
        // String name, int travelTime, ComfortClass value
        Airplane airplane1 = new Airplane("Самолет эконом класса", 5, ComfortClass.ECONOMY_CLASS);
        Airplane airplane2 = new Airplane("Самолет бизнес класса", 4, ComfortClass.BUSINESS_CLASS);
        Airplane airplane3 = new Airplane("Самолет первого класса", 3, ComfortClass.FIRST_CLASS);

        // Конструктор автобусов
        // String name, int travelTime, ComfortClass value
        Bus bus1 = new Bus("Автобус базовой комплектации", 15, ComfortClass.BASE);
        Bus bus2 = new Bus("Автобус средней комплектации", 10, ComfortClass.AVERAGE);
        Bus bus3 = new Bus("Автобус максимальной комплектации", 7, ComfortClass.HIGHER);

        // Конструктор кораблей
        // String name, int travelTime, ComfortClass value
        Ship ship1 = new Ship("Корабль с общим местом", 21, ComfortClass.COMMON_PLACE);
        Ship ship2 = new Ship("Корабль с отдельной каютой", 20, ComfortClass.CABIN);
        Ship ship3 = new Ship("Корабль с VIP ложей", 19, ComfortClass.VIP_LODGE);

        // Конструктор поездов
        // String name, int travelTime, ComfortClass value
        Train train1 = new Train("Поезд - общее место", 30, ComfortClass.COMMON_WAGON);
        Train train2 = new Train("Поезд - плацкартное", 30, ComfortClass.RESERVED_WAGON);

        // Конструктор еды
        // boolean breakfast, boolean lunch, boolean dinner, boolean supper, boolean alcohol
        Food food0 = new Food(false, true, false, false, false);
        Food food1 = new Food(true, false, false, false, false);
        Food food2 = new Food(true, true, false, false, false);
        Food food3 = new Food(true, true, true, false, false);
        Food food4 = new Food(true, true, true, true, false);
        Food food5 = new Food(true, true, true, true, true);

        // Конструктор путевок
        Travel[] travels = new Travel[11];

        // Конструктор Excursion
        // int daysTravel, int costTravelAgency, transport[] transport, food[] food, int countLionsVisited
        Transport[] t1 = new Transport[]{airplane1, bus1};
        Food[]      f1 = new Food[]{food0, food1};
        Excursion   e1 = new Excursion(10, 300, t1, f1, 5);
        travels[0] = e1;

        Transport[] t2 = new Transport[]{airplane2, bus2};
        Food[]      f2 = new Food[]{food2, food3};
        Excursion   e2 = new Excursion(11, 350, t2, f2, 6);
        travels[1] = e2;

        Transport[] t3 = new Transport[]{airplane3, bus3};
        Food[]      f3 = new Food[]{food4, food5};
        Excursion   e3 = new Excursion(12, 400, t3, f3, 7);
        travels[2] = e3;

        // Конструктор Cruise
        // int daysTravel, int costTravelAgency, transport[] transport, food[] food, int countPortsVisited
        Transport[] t4 = new Transport[]{ship1, ship2};
        Food[]      f4 = new Food[]{food3, food5};
        Cruise      c4 = new Cruise(10, 500, t4, f4, 5);
        travels[3] = c4;

        Transport[] t5 = new Transport[]{ship2, ship3};
        Food[]      f5 = new Food[]{food4, food5};
        Cruise      c5 = new Cruise(11, 510, t5, f5, 6);
        travels[4] = c5;

        // Конструктор Relaxation
        // int daysTravel, int costTravelAgency, transport[] transport, food[] food, int countBeachVisited
        Transport[] t6 = new Transport[]{train1, bus3};
        Food[]      f6 = new Food[]{food1, food2};
        Relaxation  r6 = new Relaxation(12, 150, t6, f6, 7);
        travels[5] = r6;

        Transport[] t7 = new Transport[]{train2, bus1};
        Food[]      f7 = new Food[]{food3, food4};
        Relaxation  r7 = new Relaxation(12, 170, t7, f7, 8);
        travels[6] = r7;

        // Конструктор Shopping
        // int daysTravel, int costTravelAgency, transport[] transport, food[] food, int countStoreVisited
        Transport[] t8 = new Transport[]{bus3, airplane1};
        Food[]      f8 = new Food[]{food0, food1};
        Shopping    s8 = new Shopping(8, 190, t8, f8, 19);
        travels[7] = s8;

        Transport[] t9 = new Transport[]{bus2, airplane2};
        Food[]      f9 = new Food[]{food1, food2};
        Shopping    s9 = new Shopping(9, 185, t9, f9, 18);
        travels[8] = s9;

        // Конструктор Treatment
        // int daysTravel, int costTravelAgency, transport[] transport, food[] food, int countSanatoriumsVisited
        Transport[] t10  = new Transport[]{airplane2, airplane3};
        Food[]      f10  = new Food[]{food3, food4};
        Treatment   tr10 = new Treatment(5, 600, t10, f10, 5);
        travels[9] = tr10;

        Transport[] t11  = new Transport[]{airplane3, airplane1};
        Food[]      f11  = new Food[]{food3, food0};
        Treatment   tr11 = new Treatment(6, 610, t11, f11, 5);
        travels[10] = tr11;

        menuMain(scanner, travels);

        /*
        System.out.println("Весь список туристических поездок:");

        for(Travel value : travels)
            System.out.println(value.toString());
        */
    }
}
