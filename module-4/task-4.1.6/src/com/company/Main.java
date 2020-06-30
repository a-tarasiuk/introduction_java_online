package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ПЕРЕЧИСЛЕНИЯ
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//допустимые значения
enum FieldTime{
    HOUR, MINUTE, SECOND;

    private int field;

    int getField(){
        return field;
    }

    // Конструктор
    FieldTime(){
        //пустой конструктор нужен для проверки принимаемых значений в методе set()
    }
}
//значения допустимых значений из перечисления FieldTime
enum ValueFieldTime{
    MIN_HOUR(0), MAX_HOUR(23),
    MIN_MINUTE(0), MAX_MINUTE(59),
    MIN_SECOND(0), MAX_SECOND(59);

    private int field;

    int getField(){
        return field;
    }

    // Конструктор
    ValueFieldTime(int value){
        field = value;
    }
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
// КЛАСС TimeView
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
class TimeView extends Thread{
    private long                    TIME_IN_MILLISECONDS    = 0,
                                    HOUR                    = 0,
                                    MINUTE                  = 0,
                                    SECOND                  = 0;
    private Calendar                objCalendar             = null;
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // УСТАНОВКА ПОЛЬЗОВАТЕЛЕМ ЧАСОВ, МИНУТ, СЕКУНД
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //установка часов (c проверкой допустимых значений. Допустимые значения указаны в перечислении FieldTime)
    public void set(FieldTime ft, int value) throws ArrayIndexOutOfBoundsException {
        if(ft == FieldTime.HOUR){
            if(value < ValueFieldTime.MIN_HOUR.getField() || value > ValueFieldTime.MAX_HOUR.getField()) throw new ArrayIndexOutOfBoundsException();
            else {
                HOUR = value;
            }
        }
        else if(ft == FieldTime.MINUTE){
            if(value < ValueFieldTime.MIN_MINUTE.getField() || value > ValueFieldTime.MAX_MINUTE.getField()) throw new ArrayIndexOutOfBoundsException();
            else {
                MINUTE = value;
            }
        }
        else if(ft == FieldTime.SECOND){
            if(value < ValueFieldTime.MIN_SECOND.getField() || value > ValueFieldTime.MAX_SECOND.getField()) throw new ArrayIndexOutOfBoundsException();
            else {
                SECOND = value;
            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ПОЛУЧИТЬ ЗНАЧЕНИЯ
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public Calendar getObjectDate(){
        HOUR = objCalendar.get(Calendar.HOUR_OF_DAY);
        MINUTE = objCalendar.get(Calendar.MINUTE);
        SECOND = objCalendar.get(Calendar.SECOND);
        return objCalendar;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // СООБЩЕНИЯ
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void getMessageTime(){
        System.out.format("%s%02d:%02d:%02d", "\nТекущее время (чч:мм:сс): ", HOUR, MINUTE, SECOND);
    }

    public void getMessageArrayIndexOutOfBoundsException() {
        System.out.println("\u001B[31m" + "[Ошибка] Введенное число вне диапазона допустимых значений.  Устанавливаем значение в 0!"+ "\u001B[0m");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ПОТОК
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void run(){
        try {
            while(!isInterrupted()){
                SECOND++;
                if(SECOND > 59){
                    SECOND = 0;
                    MINUTE++;
                    if(MINUTE > 59){
                        MINUTE = 0;
                        HOUR++;
                        if(HOUR > 23){
                            SECOND = MINUTE = HOUR = 0;
                        }
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Дочерний поток исполнения прерван.");
        }
        //поток завершит своё выполнение в итоге, когда до конца выполнится метод run()
        System.out.println("Завершено успешно!");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // КОНСТРУКТОР
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    TimeView(){
        objCalendar = new GregorianCalendar();                  //создаем объект класса Date, чтобы получать время в миллисекундах
        objCalendar.setLenient(false);                          //для чего это - см. в описании к методам setHours(), setMinutes(), setSeconds()
        TIME_IN_MILLISECONDS = objCalendar.getTimeInMillis();   //получить время в миллисекундах
        start();                                                //запускаем поток. Попросту метод start() вызывает выполнение метода run()
    }

}

public class Main extends Thread {
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // МЕТОДЫ
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //получаем нажатие пользователя с клавиатуры
    public static int getKeyFromKeyboard(Scanner s){
        return s.nextInt();                                     //возвращаем нажатие пользователя
    }

    /* Принимаемые значения:
    1) key              - введенная с клавиатуры пользователем цифра;
    2) tv_in_methhod    - объект класса TimeView (созданный в классе Main);
    3) s                - объект Scanner, необходим для дальнейшего ввода числе с клавиатуры при задании часов, минут, секунд в case2, case3, case4, case5
     */
    public static void switchCase(int key, TimeView tv_in_methhod, Scanner s){
        if(key < 0 | key > 6) getWrongKeyMessage();
        else {
            switch (key){
                case 0: case0(tv_in_methhod);       break;
                case 1: case1(tv_in_methhod);       break;
                case 2: case2(tv_in_methhod);       break;
                case 3: case3(tv_in_methhod, s);    break;
                case 4: case4(tv_in_methhod, s);    break;
                case 5: case5(tv_in_methhod, s);    break;
                case 6: case6(tv_in_methhod, s);    break;
            }
        }
    }

    private static void case0(TimeView tv){
        tv.interrupt();
    }

    private static void case1(TimeView tv){
        tv.getMessageTime();
    }

    private static void case2(TimeView tv){
        tv.getObjectDate();
        tv.getMessageTime();
    }

    private static void case3(TimeView tv, Scanner s){
        case4(tv, s);
        case5(tv, s);
        case6(tv, s);
    }

    private static void case4(TimeView tv, Scanner s) throws ArrayIndexOutOfBoundsException {
        try{
            System.out.print("Введите часы (минимальное значение - 0, максимальное значение - 23): ");
            tv.set(FieldTime.HOUR, s.nextInt());
        } catch (ArrayIndexOutOfBoundsException a){
            tv.getMessageArrayIndexOutOfBoundsException();
            tv.set(FieldTime.HOUR, 0);
        }
    }

    private static void case5(TimeView tv, Scanner s){
        try{
            System.out.print("Введите минуты (минимальное значение - 0, максимальное значение - 59): ");
            tv.set(FieldTime.MINUTE, s.nextInt());
        } catch (ArrayIndexOutOfBoundsException a){
            tv.getMessageArrayIndexOutOfBoundsException();
            tv.set(FieldTime.MINUTE, 0);
        }
    }

    private static void case6(TimeView tv, Scanner s){
        try{
            System.out.print("Введите секунды (минимальное значение - 0, максимальное значение - 59): ");
            tv.set(FieldTime.SECOND, s.nextInt());
        } catch (ArrayIndexOutOfBoundsException a){
            tv.getMessageArrayIndexOutOfBoundsException();
            tv.set(FieldTime.SECOND, 0);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // СООБЩЕНИЯ
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void getStartMessage(){
        System.out.println("\n" +
                "0. Exit\n" +
                "1. Получить текущее время\n" +
                "2. Установить время, равное системному\n" +
                "3. Установить время (вручную)\n" +
                "4. Редактирование: часы\n" +
                "5. Редактирование: минуты\n" +
                "6. Редактирование: секунды");
    }

    public static void getChoiceMessage(){
        System.out.print("\nВаш выбор: ");
    }

    public static void getWrongKeyMessage(){
        System.out.println("\u001B[31m" + "\n[Error] Неверный выбор. Повторите ввод." + "\u001B[0m");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // MAIN
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws InterruptedException {
        TimeView    tv = new TimeView();
        Scanner     s = new Scanner(System.in);
        getStartMessage();
        while (true){
            getChoiceMessage();
            switchCase(getKeyFromKeyboard(s), tv, s);       //получаем нажатие клавиши и передаем в конструкцию switch-case
            if(tv.isInterrupted()) break;
        }
        tv.join();                                          //ждем окончание дочернего потока и только потом заверщаем главный поток
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // КОНЕЦ ПРОГРАММЫ
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
