package com.company;

import java.util.*;

class Airline{
    {
        id++;
    }
    private static  int                 id;                                 //номер рейса
    private         int                 flightNumber = id,
                                        departureTime;                      //время вылета (в минутах)
    private         String              destination,                        //пункт назначения
                                        typeOfAircraft;                     //тип самолета
    private         ArrayList<String>   daysOfTheWeek;                      //дни недели

    public String toString(){
        return String.format("Номер рейса: %5d | Время вылета: %5d:%02d | Пункт назначения: %20s | Тип самолета: %10s | Дни недели: %30s", flightNumber, (departureTime/60), (departureTime%60), destination, typeOfAircraft, daysOfTheWeek);
    }

    public String getDestination(){
        return this.destination;
    }

    public ArrayList<String> getDaysOfTheWeek(){
        return daysOfTheWeek;
    }

    public int getDepartureTime(){
        return departureTime;
    }
    /*
    public Collection<? extends Integer> getDepartureTime(){
        return Collections.singleton(this.departureTime);
    }

     */

    Airline(int departureTime, String destination, String typeOfAircraft, List<String> daysOfTheWeek){
        this.departureTime = departureTime;
        this.destination = destination;
        this.typeOfAircraft = typeOfAircraft;
        this.daysOfTheWeek = new ArrayList<>(daysOfTheWeek);
    }
}

class Airport{
    ArrayList<Airline> airportDataBase = new ArrayList<>();

    //добавить рейс
    public Airport addValue(Airline a){
        airportDataBase.add(a);
        return this;
    }

    //получить список рейсов
    public List<Airline> getAllAirlines(){
        return new ArrayList<>(airportDataBase);
    }
}

class Actions{
    Scanner s = new Scanner(System.in);

    protected int getChoice(int maxValue){ //проверка диапазона ввода
        boolean flag = true;
        int     key = 0;
        while (flag){
            getMessageGetChoice();
            key = s.nextInt();
            if(flag = key < 0 || key > maxValue ? true : false) getMessageWrongChoice();
        }
        return key;
    }

    protected void getMessageWelcome(){
        System.out.println("Найти и вывести:" +
                "\n0. Выход" +
                "\n1. Список рейсов для заданного пункта назначения" +
                "\n2. Список рейсов для заданного дня недели" +
                "\n3. Список рейсов для заданного дня недели, время вылета для которых больше заданного");
    }

    protected void getMessageGetChoice(){
        System.out.print("\nВаш выбор: ");
    }

    protected void getMessageWrongChoice(){
        System.out.println("Неверный выбор! Повторите ввод!");
    }
}


public class Main {
    public static void case1(Airport airport, Actions actions){
        int choice;
        ArrayList<String> allDestination = new ArrayList<>();

        //записываем сначала все пункты назначения (с повторения)
        for(int i = 0; i < airport.getAllAirlines().size(); i++){
            allDestination.add(airport.getAllAirlines().get(i).getDestination());
        }

        //удаляем дубликаты
        ArrayList<String> destinationWithoutDuplicates = removeDuplicates(allDestination);

        System.out.println("\nСписок доступных пунктов назначения:");
        for(int i = 0; i < destinationWithoutDuplicates.size(); i++)
            System.out.println(i + ". " + destinationWithoutDuplicates.get(i));

        choice = actions.getChoice(destinationWithoutDuplicates.size());
        for(int i = 0; i < airport.getAllAirlines().size(); i++){
            if(airport.getAllAirlines().get(i).getDestination().contains( destinationWithoutDuplicates.get(choice) ))
                System.out.println(i + ". " + airport.getAllAirlines().get(i));
        }
    }

    public static void case2(Airport airport, Actions actions){
        int     choice;
        ArrayList<String>   allDaysOfTheWeek = new ArrayList<>();

        //записываем сначала все дни недели (с повторениями)
        for(int i = 0; i < airport.getAllAirlines().size(); i++)
            allDaysOfTheWeek.addAll(airport.getAllAirlines().get(i).getDaysOfTheWeek());

        //удаляем дубликаты
        ArrayList<String>  daysOfTheWeekWithoutDuplicates = removeDuplicates(allDaysOfTheWeek);

        System.out.println("\nСписок доступных дней недели:");
        for(int i = 0; i < daysOfTheWeekWithoutDuplicates.size(); i++)
            System.out.println(i + ". " + daysOfTheWeekWithoutDuplicates.get(i));

        choice = actions.getChoice(daysOfTheWeekWithoutDuplicates.size());

        for(int i = 0; i < airport.getAllAirlines().size(); i++){
            if(airport.getAllAirlines().get(i).getDaysOfTheWeek().contains( daysOfTheWeekWithoutDuplicates.get(choice)))
                System.out.println(i + ". " + airport.getAllAirlines().get(i));
        }
    }

    public static void case3(Airport airport, Actions actions){
        int     choice_days,
                choice_departure;
        ArrayList<String>   allDaysOfTheWeek = new ArrayList<>();
        ArrayList<Integer>  allDepartureTime = new ArrayList<>();

        //записываем сначала все дни недели (с повторениями)
        for(int i = 0; i < airport.getAllAirlines().size(); i++)
            allDaysOfTheWeek.addAll(airport.getAllAirlines().get(i).getDaysOfTheWeek());

        //удаляем дубликаты из дней недели
        ArrayList<String>  daysOfTheWeekWithoutDuplicates = removeDuplicates(allDaysOfTheWeek);

        //выводим список доступных дней недели
        System.out.println("\nСписок доступных дней недели:");
        for(int i = 0; i < daysOfTheWeekWithoutDuplicates.size(); i++)
            System.out.println(i + ". " + daysOfTheWeekWithoutDuplicates.get(i));
        choice_days = actions.getChoice(daysOfTheWeekWithoutDuplicates.size());

        //сейчас записываем доступное время для заданных дней недели
        for(int i = 0; i < airport.getAllAirlines().size(); i++){
            if(airport.getAllAirlines().get(i).getDaysOfTheWeek().contains(daysOfTheWeekWithoutDuplicates.get(choice_days)))
                allDepartureTime.add(airport.getAllAirlines().get(i).getDepartureTime());
        }

        //удаляем дубликаты из времени для заданных дней недели
        ArrayList<Integer> departureTimeWithoutDuplicates = removeDuplicates(allDepartureTime);

        //сортируем значения (время) в departureTimeWithoutDuplicates по возрастанию, чтобы при выводе в консоль был удобочитаемый вид
        Collections.sort(departureTimeWithoutDuplicates);

        System.out.println("\nВыберите доступное время, после которого осуществляются вылеты:");
        for(int i = 0; i < departureTimeWithoutDuplicates.size(); i++)
            System.out.format("%d. %02d:%02d\n", i, (departureTimeWithoutDuplicates.get(i) / 60), (departureTimeWithoutDuplicates.get(i) % 60));
        choice_departure = actions.getChoice(departureTimeWithoutDuplicates.size());

        for(int i = 0; i < airport.getAllAirlines().size(); i++){
            if(
                    airport.getAllAirlines().get(i).getDaysOfTheWeek().contains(daysOfTheWeekWithoutDuplicates.get(choice_days)) &&
                    departureTimeWithoutDuplicates.get(choice_departure).compareTo(airport.getAllAirlines().get(i).getDepartureTime()) <= 0
            )
                System.out.println(i + ". " + airport.getAllAirlines().get(i));
        }
    }

    //метод удаления дубликатов (для любых типов)
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list){
        ArrayList<T> newArrayList = new ArrayList<T>();
        for(T element : list){
            if(!newArrayList.contains(element)) newArrayList.add(element);
        }
        return newArrayList;
    }

    public static void main(String[] args) {
        Actions actions = new Actions();
        Airport airportInMain = new Airport().
                addValue(new Airline(300, "г.Москва", "Боинг", Arrays.asList(new String[] {"Понедельник", "Вторник"}) )).
                addValue(new Airline(400, "г.Санкт-Петербург", "Боинг", Arrays.asList(new String[] {"Понедельник", "Вторник"}) )).
                addValue(new Airline(500, "г.Москва", "Боинг", Arrays.asList(new String[] {"Понедельник", "Среда"}) )).
                addValue(new Airline(300, "г.Санкт-Петербург", "Боинг", Arrays.asList(new String[] {"Понедельник", "Среда"}) )).
                addValue(new Airline(700, "г.Москва", "Боинг", Arrays.asList(new String[] {"Понедельник", "Вторник"}) )).
                addValue(new Airline(800, "г.Санкт-Петербург", "Боинг", Arrays.asList(new String[] {"Среда", "Четверг", "Пятница"}) )).
                addValue(new Airline(300, "г.Москва", "Боинг", Arrays.asList(new String[] {"Пятница", "Суббота"}) )).
                addValue(new Airline(500, "г.Казань", "Боинг", Arrays.asList(new String[] {"Воскресенье"}) )).
                addValue(new Airline(1100, "г.Казань", "Боинг", Arrays.asList(new String[] {"Воскресенье"}) ));



        actions.getMessageWelcome();

        switch (actions.getChoice(3)){
            case 0: break;
            case 1: case1(airportInMain, actions); break;
            case 2: case2(airportInMain, actions); break;
            case 3: case3(airportInMain, actions); break;
        }

        /*
        for(Airline s : airportInMain.getAllAirlines()){
            System.out.println(s);
        }
        */
    }
}
