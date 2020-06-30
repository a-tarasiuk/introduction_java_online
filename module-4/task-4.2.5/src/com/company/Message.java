package com.company;

import com.company.food.Food;
import com.company.transport.Transport;

public class Message {
    protected static void messageChoice(){
        System.out.print("Ваш выбор: ");
    }

    protected static void messageMain(){
        System.out.println("0. Выход\n" +
                "1. Подробная информация о путевках\n" +
                "2. Сортировка путевок\n");
    }

    protected static void messageSort(){
        System.out.println("\n0. Назад\n" +
                "1. По стоимости путевки\n");
    }

    protected static void messageRank(){
        System.out.println("\n0. Назад\n" +
                "1. Сначала дешевые\n" +
                "2. Сначала дорогие\n" +
                "3. Ввести диапазон стоимости\n");
    }

    protected static void messageMinDiapason(){
        System.out.print("\nМинимальная сумма $: ");
    }

    protected static void messageMaxDiapason(){
        System.out.print("Максимальная сумма $: ");
    }

    protected static void messageWrongDiapason(){
        System.out.println("\n\tМаксимальное значение должно быть больше минимального.\n\tПовторите ввод!\n");
    }

    protected static void messageDiapasonNotFound(int minValue, int maxValue){
        System.out.println("\n\tОтсутствуют путёвки в заданном диапазоне цен (от - " + minValue + " $ до " + maxValue + " $)");
    }

    protected static void errorChoiceMessage(){
        System.out.println("\n\t- Неверный выбор. Повторите ввод...\n");
    }

    protected static void messageCombinations(Transport transport, Food food, int countDays, int costTravelAgency){
        System.out.format("\n| %-35s| %-50s |", "Транспорт:", transport.getName() + " - " + transport.getCost() + " $");
        System.out.format("\n| %-35s| %-50s |", "- время в пути:", transport.getTravelTime() + " дн.");
        System.out.format("\n| %-35s| %-50s |", "Общее время на дорогу:", (countDays + transport.getTravelTime()) + " дн.");
        System.out.format("\n| %-35s| %-50s |", "Суточный рацион:", "");
        for(int k = 0; k < food.getRation().size(); k++)
            System.out.format(String.format("\n| %-35s| %-50s |", "", food.getRation().get(k)));
        System.out.format("\n| %-35s| %-50s |", "Итоговая стоимость рациона:", food.getTotalCost() + " $");
        System.out.format("\n| %-35s| %-50s |", "Итоговая стоимость путевки:", (costTravelAgency + transport.getCost() + food.getTotalCost()) + " $");
    }
}
