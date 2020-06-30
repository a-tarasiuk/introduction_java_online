package com.company;
import java.util.Scanner;

/*
Логика программы:
1) Выводится приветственное сообщение из метода runWelcome()
2) После правильного выбора запускается поток на выполнение счетчика, счетчик начинает отсчет.
В это время можно выбрать действия, согласно меню.
3) Главный поток (класс Main) завершается только после выполнения дочернего потока (класс DecimalCounter).
Проверка осуществляется в классе Main с помощью метода join()
 */

class DecimalCounter extends Thread {
    private int     counter,                //счетчик
                    maxValue,               //максимальное значение счетчика
                    minValue;               //минимальное значение счетчика

    //Увеличить значение
    public void increaseCounter(){
        this.counter = (this.counter == this.maxValue) ?  getMessageStop() : this.counter++;
        System.out.print("Увеличили значение на единицу. ");
        getCounter();
    }

    //уменьшить значение
    public void decreaseCounter(){
        this.counter = (this.counter == this.minValue) ? getMessageStop() : --this.counter;
        System.out.print("Уменьшили значение на единицу. ");
        getCounter();
    }

    //Получить значение счетчика
    public int getCounter(){
        System.out.println("Текущее значение счетчика: " + this.counter);
        return this.counter;
    }

    //получить минимальное значение
    public int getMinValue(){
        System.out.println("Минимальное значение счетчика: " + this.minValue);
        return this.minValue;
    }

    //получить максимальное значение
    public int getMaxValue(){
        System.out.println("Максимальное значение счетчика: " + this.maxValue);
        return this.maxValue;
    }

    //задать минимальное значение
    public void setMinValue(int minValue){
        this.minValue = minValue;
    }

    //задать максимальное значение
    public void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }

    //вывод сообщения
    public int getMessageStop(){
        System.out.print("\n[END] Завершено выполнение счетчика.\nИсходные данные:\n");
        getMinValue();
        getMaxValue();
        if(!isInterrupted()) System.out.print("\nСделайте Ваш выбор: ");    //если поток не завершен, вывести сообщение
        /*
        Ниже проверяем. Например, если текущее значение счетчика 10, а минимальное 8. Когда вользователь будет минусовать значение
        счетчика, он достигнет в итоге минимального допустимого порога (minValue).
        И вот тут идет сравнение:
        - если текущее значение счетчика больше максимального порога, то текущее значение = максимальному
        - если текущее значение меньше минимума, то текущее значение = минимуму, чтобы нельзя было уйти "в минус"
         */
        return this.counter = (this.counter > this.maxValue) ? this.maxValue : this.minValue;
    }

    //Выводим сообщение об успешном запуске счетчика и соотв. значения
    public void getMessageRun(){
        System.out.println("\n[Ok] Счётчик запущен.");
        getMinValue();
        getMaxValue();
        getCounter();
    }

    //инициализация maxValue и minValue произвольными значениями
    public void setRandomValues(){
        while (true) {
            this.minValue = (int) (Math.random() * (100 + 1));
            this.maxValue = (int) (Math.random() * (100 + 1));
            if(this.maxValue > this.minValue) {
                this.counter = this.minValue;
                getMessageRun();
                start();                                //запускаем поток на выполнение (т.е. запуск метода run())
                break;
            }
        }
    }

    //запускаем счетчик
    public void run(){
        try {
            if(!isInterrupted()){                       //проверяем, не нужно ли завершить поток, если нет, входим в цикл for
                for(; this.counter < this.maxValue + 1; this.counter++) {
                    Thread.sleep(1000);
                }
            } else {                                    //инача бросаем исключение
                throw new InterruptedException();
            }
        } catch (InterruptedException e){
            System.out.println("Дочерний поток исполнения прерван.");
        }
        getMessageStop();
    }

    //конструктор - инициализация счетчика значениями по умолчанию
    DecimalCounter(){
        this.maxValue = 10;
        this.minValue = this.counter = 0;
    }

    /*
    //конструктор - инициализация значениями с клавиатуры
    DecimalCounter(int maxValue, int minValue){
        this.maxValue = maxValue;
        this.minValue = minValue;
        getMessageRun();
        start();
    }
     */
}

public class Main {
    //вывод приветствия
    public static void messageWelcome(){
        System.out.print(
            "\nВыберите действие:\n" +
            "1. Запустить счетчик (значения по умолчанию)\n" +
            "2. Задать значения счетчика\n" +
            "3. Запустить счетчик с рандомными значениями\n" +
            "4. Получить значение счетчика\n" +
            "5. Увеличить значение счетчика на единицу\n" +
            "6. Уменьшить значение счетчика на единицу\n" +
            "7. Вывести минимальное значение\n" +
            "8. Вывести максимальное значение\n" +
            "9. Выход\n");
    }

    //проверка на корректность выбора
    public static int getChoice(int[] validKeys){
        int     key = 0;                                        //выбор пользователя
        Scanner in = new Scanner(System.in);
        while (true){
            key = in.nextInt();
            for(int i = 0; i < validKeys.length; i++)
                if (key == validKeys[i]) return key;
            getMessageError();
        }
    }

    //case1
    public static DecimalCounter case1(){
        DecimalCounter obj = new DecimalCounter();
        obj.getMessageRun();
        obj.start();                                            //в этот момент запускается второй поток (т.е. запускается метод run())
        return obj;
    }

    //case2
    public static DecimalCounter case2(){
        int key = 0;
        DecimalCounter obj = new DecimalCounter();
        Scanner in = new Scanner(System.in);
        getMessageSetMinValue();
        obj.setMinValue(in.nextInt());
        while (true){
            getMessageSetMaxValue();
            key = in.nextInt();
            if(key > obj.getMinValue()) {
                obj.setMaxValue(key);
                obj.getMessageRun();
                obj.start();
                return obj;
            }
        }
    }

    //case3
    public static DecimalCounter case3(){
        DecimalCounter obj = new DecimalCounter();
        obj.setRandomValues();                      //в этот момент запускается второй поток (т.е. запускается метод run()), т.к. в методе setRandomValues() прописан метод start()
        return obj;
    }

    //case4
    public static void case4(DecimalCounter obj){
        objIsNull(obj);
    }

    //case5
    public static void case5(DecimalCounter obj){
        if(obj != null) obj.increaseCounter();
        else getMessageErrorInitialization();
    }

    //case6
    public static void case6(DecimalCounter obj){
        if(obj != null) obj.decreaseCounter();
        else getMessageErrorInitialization();
    }

    //case7
    public static void case7(DecimalCounter obj){
        if(obj != null) obj.getMinValue();
        else getMessageErrorInitialization();
    }

    //case8
    public static void case8(DecimalCounter obj){
        if(obj != null) obj.getMaxValue();
        else getMessageErrorInitialization();
    }

    //case9
    public static void case9(DecimalCounter obj){
        if(obj != null) obj.interrupt();                             //этот метод прерывает выполнение потока (проверяется в методе run() методом isInterrupted()
    }

    //проверка, инициализирован ли объекк
    public static void objIsNull(DecimalCounter obj){
        if(obj != null) obj.getCounter();
        else getMessageErrorInitialization();
    }

    public static void getMessageSetMinValue(){
        System.out.print("Введите минимальное значение: ");
    }

    public static void getMessageSetMaxValue(){
        System.out.print("Введите максимальное значение: ");
    }

    //сообщение "Ваш выбор"
    public static void getMessageYourChoice(){
        System.out.print("\nВаш выбор: ");
    }

    //ошибка инициализации - нужно запустить счетчик
    public static void getMessageErrorInitialization(){
        System.out.println("[Ошибка] Объект не инициализирован! Запустите счетчик!");
    }

    //сообщение об ошибке ввода с клавиатуры
    public static void getMessageError(){
        System.out.print("\n[Error] Ошибка ввода.\nПовторите ввод: ");
    }

    public static void main(String[] args) {
        int[] validKeys = {1, 2, 3, 4, 5, 6, 7, 8, 9};     //допустимые числа для ввода вользователем
        boolean choice = true;
        DecimalCounter obj = null;
        messageWelcome();
        try {
            while (choice) {
                getMessageYourChoice();
                switch (getChoice(validKeys)) {
                    case 1:
                        obj = case1();
                        break;
                    case 2:
                        obj = case2();
                        break;
                    case 3:
                        obj = case3();
                        break;
                    case 4:
                        case4(obj);
                        break;
                    case 5:
                        case5(obj);
                        break;
                    case 6:
                        case6(obj);
                        break;
                    case 7:
                        case7(obj);
                        break;
                    case 8:
                        case8(obj);
                        break;
                    case 9:
                        case9(obj);
                        choice = false;
                        break;
                }
            }
            /*
            если не проверить obj на null (будет, если поток obj не запущен, т.е. если счетчик не запущен - не создан онбъект класса),
            то выдаст Exception in thread "main" java.lang.NullPointerException.
            join() ожидает, завершен ли предыдущий поток. А если он и не был запущен? То и ждать его завершения незачем.
            Поэтому без if выдаст то самое исключение выше.
             */
            if(obj != null) obj.join();
        } catch (InterruptedException e){
            System.out.println("Главный поток исполнения прерван.");
        }

    }
}
