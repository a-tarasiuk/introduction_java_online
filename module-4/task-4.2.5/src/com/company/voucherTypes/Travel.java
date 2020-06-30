package com.company.voucherTypes;

import com.company.food.Food;
import com.company.Message;
import com.company.transport.Transport;

import java.util.ArrayList;

/*
    * Реализация интерфейса Comparable<Travel> нужна для того, чтобы переопределить м-д compareTo() для сравнения объектов по определенному полю
    Далее можно вызывать методо Arrays.sort(массив_объектов) для сортировки объектов по полю, которое определено в compareTo()

    * Массив costCombinations[size][3]:
    - size - число комбинаций транспорта, еды и costTravelAgency
    - 3 - в первом столбце будет позиция транспорта, во второй - еды, в третьей - общая стоимость
 */
public abstract class Travel extends Message implements FinancialDepartment, Comparable<Travel>{
    private Transport[]                     transport;
    private Food[]                          food;
    private int                             countDays;                                  // Продолжительность поездки
    private int                             costTravelAgency;                           // Стоимость услуг тур. фирмы за путевку
    private ArrayList<ArrayList<Integer>>   costCombinations = new ArrayList<>();       // Комбинации стоимостей

    @Override
    public int compareTo(Travel arg) {
        return Integer.compare(getCostTravelAgency(), arg.getCostTravelAgency());
    }

    // GET-методы
    // Получить продолжительность поездки (дней)
    public int getCountDays(){
        return this.countDays;
    }

    // Получить заложенную стоимость тур. фирмы
    public int getCostTravelAgency(){
        return this.costTravelAgency;
    }

    // Получить комбинации стоимостей
    public ArrayList<ArrayList<Integer>> getCostCombinations(){
        return costCombinations;
    }

    // Получить transport[]
    public Transport getTransport(int position){
        return this.transport[position];
    }

    // Получить food[]
    public Food getFood(int position){
        return this.food[position];
    }

    // Стоимости разных комбинаций
    private void setCostCombinations() {
        int count = 0;
        for (int t = 0; t < transport.length; t++)
            for (int f = 0; f < food.length; f++, count++) {
                costCombinations.add(new ArrayList<>());
                costCombinations.get(count).add(0, t);
                costCombinations.get(count).add(1, f);
                costCombinations.get(count).add(2, getCostTravelAgency() + transport[t].getCost() + food[f].getTotalCost());
            }
    }

    // Вывести всю информацию о путешествии
    protected void getInformation(String name, int count){
        printLine(91);
        System.out.format("\n| %-35s| %-50s |", "Тип путевки:", name);
        printLine(91);
        System.out.format("\n| %-35s| %-50s |", "Стоимость путевки:", getCostTravelAgency() + " $");
        System.out.format("\n| %-35s| %-50s |", "Продолжительность:", getCountDays() + " дн.");
        System.out.format("\n| %-35s| %-50s |", "Мест для посещения:", count);
        printLine(91);
    }

    // Информация отдельно по транспорту и еде
    public void getCombinations(){
        System.out.format("\n| %-87s |", "Возможные комбинации:");
        printLine(91);
        for(int i = 0; i < transport.length; i++){
            for(int j = 0; j < food.length; j++) {
                messageCombinations(transport[i], food[j], getCountDays(), getCostTravelAgency());
                printLine(91);
            }
        }
        System.out.println("\n");
    }

    // Напечатать линию
    private void printLine(int length){
        System.out.println();
        for(int i = 0; i < length; i++)
            System.out.print("-");
    }

    // Абстрактные методы
    protected   abstract String  getName();
    protected   abstract int     getCount();

    // Конструктор
    public Travel(int countDays, int costTravelAgency, Transport[] transport, Food[] food){
        this.countDays          = countDays;
        this.costTravelAgency   = costTravelAgency;
        this.transport          = transport;
        this.food               = food;
        setCostCombinations();  // Подсчитать возможные комбинации
    }
}
