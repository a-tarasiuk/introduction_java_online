package com.company;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

class Train{
    private String  destination = "";               //пункт назначения
    private int     numberTrain;                    //номер поезда
    private long    departureTime;                  //время отправления (в миллисекундах, отсчет с 1 января 1970 года)

    //генерируем случайное число в заданом диапазоне [min, max] включительно
    private long getRandom(long min, long max){
        return (long)((Math.random() * (max - min + 1)) + min);
    }

    //Генерируем случайную дату, которая равна случайному диапазону из: (текущая дата) + (текущая дата + 1 месяц)
    private void setDepartureTime(){
        Date date = new Date();
        departureTime = getRandom(date.getTime(), date.getTime() + 2592000000l);    //2592000000 - количество миллисекунд в месяце
    }

    //генерируем номер поезда
    private void setNumberTrain(){
        numberTrain = (int)(Math.random() * 100);
    }

    //генерируем название пункта назначения
    private void setDestination(){
        destination = "New York";                       //нужно для проверки сортировки (пункт 3), если пункты назначения одинаковые
        /*                                              //тут генерируем разные пункты назначения
        for(int i = 0; i < getRandom(5,10); i++){
            destination += (char)(getRandom(65,90));
        }
         */
    }

    //печать информации о номере поезда, пункте назначения, времени отправления
    public void getInformationAboutTrain(){
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd hh:mm");
        System.out.printf("%-15s%-5s%-20s%-15s%-20s%-40s%n", "Номер поезда:", numberTrain, "Пункт назначения:", destination, "Время отправления:", s.format(departureTime));
    }

    public int getNumberTrain(){
        return numberTrain;
    }

    public String getDestination(){
        return destination;
    }

    public long getDepartureTime() { return departureTime; }

    //конструктор
    Train(){
        setDepartureTime();
        setNumberTrain();
        setDestination();
    }

}

public class Main {
    //генерируем поезда
    public static Object[] genTrains(Object[] obj, int[] value){
        for(int i = 0; i < obj.length; i++) {
            obj[i] = new Train();
            value[i] = i+1;
        }
        return obj;
    }

    //Вывод начального меню
    public static void start(){
        System.out.print("\nВыберите действие:\n" +
                "0. Выход\n" +
                "1. Отсортировать табло по номерам поездов (по возрастанию)\n" +
                "2. Отсортировать табло по номерам поездов (по убыванию)\n" +
                "3. Отсортировать табло по пункту назначения (алфавитный порядок)\n" +
                "4. Получить информацию по номеру поезда (номер поезда вводится пользователем)\n" +
                "5. Вывести табло на экран\n" +
                "Ваш выбор: ");
    }

    public static void switchCase(Train[] t, int select, int[] value){
        switch (select){
            case 0: break;
            case 1: case1(t); break;
            case 2: case2(t); break;
            case 3: case3(t); break;
            case 4: case4(t, value, select); break;
            case 5: case5(t); break;
        }
    }

    //Получение пункта меню
    //select -  напечатанное пользователем значение, values - массив допустимых для выбора значений
    public static int getSelect(int select, int[] values){
        Scanner in = new Scanner(System.in);
        while (true){
            select = in.nextInt();

            for(int i : values)
                if(select == i | select == 0) return select;

            System.out.print("\n[ОШИБКА] Выбор не существует. Сделайте правильный выбор!\n" + "Ваш выбор: ");
        }
    }

    //case1
    public static void case1(Train[] obj){
        Arrays.sort(obj, (a, b) -> a.getNumberTrain() - b.getNumberTrain());
        printUp(obj);
    }

    public static void case2(Train[] obj){
        Arrays.sort(obj, (a, b) -> a.getNumberTrain() - b.getNumberTrain());
        printDown(obj);
    }

    public static void case3(Train[] obj){
        bubbleSort(obj);
        printUp(obj);
    }

    public static void case4(Train[] obj, int[] value, int select){
        System.out.println("\nИмеющиеся номера поездов:");
        for(int i = 0; i < obj.length; i++) {
            System.out.println((i + 1) + ". Номер поезда: " + obj[i].getNumberTrain());
            value[i] = obj[i].getNumberTrain();
        }
        System.out.print("Введите номер поезда, информацию о котором необходимо получить: ");
        //получаем номер поезда с клавиатуры
        select = getSelect(select, value);
        //печатаем информацию
        for(int i = 0; i < value.length; i++)
            if(select == value[i]) obj[i].getInformationAboutTrain();

    }

    public static void case5(Train[] obj){
        for(int i = 0; i < obj.length; i++)
            obj[i].getInformationAboutTrain();
    }

    //сортировка
    public static void bubbleSort(Train[] obj){
        Train replase;                                                                                                  //нужно для обмена ссылками объектов
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < obj.length - 1; i++) {
                if (obj[i].getDestination().toLowerCase().compareTo(obj[i + 1].getDestination().toLowerCase()) == 0) {  //если пункты назначения одинаковые
                    if(obj[i].getDepartureTime() > obj[i + 1].getDepartureTime()){                                      //то сравниваем и сортируем по времени отправления
                        sorted = false;
                        replase = obj[i];
                        obj[i] = obj[i + 1];
                        obj[i + 1] = replase;
                    }
                } else {                                                                                                //если пункты назначения разные, то сортируем в алфавитном порядке
                    if (obj[i].getDestination().toLowerCase().compareTo(obj[i + 1].getDestination().toLowerCase()) > 0) {
                        sorted = false;
                        replase = obj[i];
                        obj[i] = obj[i + 1];
                        obj[i + 1] = replase;
                    }
                }
            }
        }
    }

    //печать по возрастанию
    public static void printUp(Train[] obj){
        for(int i = 0; i < obj.length; i++)
            obj[i].getInformationAboutTrain();
    }
    //печать по убыванию
    public static void printDown(Train[] obj){
        for(int i = obj.length - 1; i >= 0; i--)
            obj[i].getInformationAboutTrain();
    }

    public static void main(String[] args) {
        int     select = 0,
                value[];

        Train[] t = new Train[5];
        value = new int[5];

        genTrains(t, value);
        start();
        select = getSelect(select, value);
        switchCase(t, select, value);
    }
}
