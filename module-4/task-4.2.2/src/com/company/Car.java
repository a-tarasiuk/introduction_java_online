package com.company;

public class Car extends Thread{
    /*------------------------------------------------- Переменные ---------------------------------------------------*/
    private         String  carBrand;                   //марка машины
    private static  int     MIN_FUEL = 0;               //минимальный объем топлива в баке
    private static  int     MAX_TANK;                   //объем топливного бака
    private         int     NOW_FUEL;                   //текущий объем топлива
    private         int     DISTANCE_TO_TRAVEL;         //расстояние, которое необходимо проехать
    private static  int     DISTANCE_STEP = 1;          //шаг пройденного километража
    private static  int     MIN_DISTANCE_TO_TRAVEL = 0; //минимальное расстояние, которое можно проехать

    /*------------------------------------------------- Композиция ---------------------------------------------------*/
    //создаем мотор
    private Motor motor;

    //создаем 4 колеса
    private Wheel[] wheel = new Wheel[]{new Wheel(20), new Wheel(20), new Wheel(20), new Wheel(20)};

    //сообщения + switch-case
    Messages messages = new Messages();
    /*-------------------------------------------------- GET-методы --------------------------------------------------*/
    //получить марку машины
    public String getCarBrand(){
        return this.carBrand;
    }

    //получить текущий объем топлива в баке
    public int getNowFuel(){
        return this.NOW_FUEL;
    }

    //получить объем топливного бака
    public int getMaxTank(){
        return this.MAX_TANK;
    }

    //получить все датчики
    public void getAllSensors(){
        System.out.println("\n[ПРИБОРНАЯ ПАНЕЛЬ]");
        System.out.format("%-50s %s\n", "\t- Марка автомобиля: ", getCarBrand());
        this.motor.getMileage();
        System.out.format("%-50s %d %s\n", "\t- Максимальный уровень топлива: ", getMaxTank(), "(л)");
        System.out.format("%-50s %d %s\n", "\t- Текущий уровень топлива: ", getNowFuel(), "(л)");
    }
    /*---------------------------------------------- Методы-действия -------------------------------------------------*/

    public void run(){
        try {
            if(!isInterrupted()){   //проверяем, не нужно ли завершить поток, если нет, идем дальше
                this.whenTheCarIsDriving();
            }
            else throw new InterruptedException();      //иначе бросаем исклчение
        } catch (InterruptedException e){
            System.out.println("Дочерний поток исполнения прерван.");
        }
    }

    //запустить двигатель
    public void startMotor(){
        motor.startMotor();
    }

    //заглушить двигатель
    public void stopMotor(){
        motor.stopMotor();
    }

    //запуск машины (проверка некоторых датчиков)
    public void letsGo() {
        //проверка колес на радиус (должне быть одинаковым на каждом колесе)
        for(int i = 0; i < this.wheel.length; i++){
            if(this.wheel[0].getRadius() != this.wheel[i].getRadius()){
                throw new IllegalArgumentException("[ИНФОРМАЦИЯ]\n- Радиус колес должен быть одинаковым!");
            }
        }

        //Двигатель уже заведен?
        if(motor.getMotorStatus()){
            System.out.println("[ИНФОРМАЦИЯ]\n- Машина начала движение.");
            this.start();
        }

        //Бак пуст?
        if(this.NOW_FUEL == 0)
            System.out.println("[ОШИБКА]\n- Бак пуст! Необходимо заправиться! Движение невозможно!");
    }

    //когда машина начала движение
    public void whenTheCarIsDriving() throws InterruptedException {
        int fuelConsumption = 1;    //расход топлива (в литрах) на 1 км
        for(; this.NOW_FUEL > 0; this.NOW_FUEL -= fuelConsumption){
            Thread.sleep(1000);
            //проверяем, не превышен ли лимит километража двигателя
            if(this.motor.increaseMileage(this.DISTANCE_STEP)){
                continue;
            }
            else {
                break;
            }
        }
        this.motor.stopMotor();
        this.getAllSensors();
    }

    //заправиться
    public void toRefuel(int value){
        if(this.NOW_FUEL + value > MAX_TANK) {
            System.out.println("Превышен уровень допустимомго топливного бака (" + this.MAX_TANK + " л.)");
            System.out.println("Можно заправить максимум на " + (this.MAX_TANK- this.NOW_FUEL) + " л.");
        }
        else {
            this.NOW_FUEL += value;
            System.out.println("Машина успешно заправлена на " + value + " л. Текущий уровень топлива: " + this.getNowFuel());
        }
    }

    //поменять колесо
    public void replaceWheel(){
        int keys[]                  = {1, 2, 3, 4};                             //доступные типы колес
        int replacementWheelNumber;                                             //номер колеса для замены
        int replacementWheelRadius;                                             //радиус колеса для замены

        //проверяем, чтобы двигатель был заглушен перед заменой колеса, т.к. на ходу нельзя заменить колесо
        if(motor.getMotorStatus()) System.out.println("[ПРЕДУПРЕЖДЕНИЕ]\n- Перед заменой необходимо заглушить двигатель!");
        else {
            System.out.println("\nДоступные для замены колеса:");
            System.out.println("1. Переднее левое (диаметр - " + wheel[0].getRadius() + ")");
            System.out.println("2. Переднее правое (диаметр - " + wheel[1].getRadius() + ")");
            System.out.println("3. Заднее левое (диаметр - " + wheel[2].getRadius() + ")");
            System.out.println("4. Заднее правое (диаметр - " + wheel[3].getRadius() + ")");

            messages.getMessageChoice();
            replacementWheelNumber = messages.getChoice(keys) - 1;

            System.out.println("Введите радиус колеса (от 14 до 22 дюймов):");
            System.out.println("[ИНФОРМЦИЯ]\n- Радиус нового колеса должен быть равен текущему.");
            messages.getMessageChoice();

            //радиус нового колеса для замены может быть только таким, какое колесо стоит сейчас
            replacementWheelRadius = messages.getChoice(wheel[replacementWheelNumber].getRadius());

            wheel[replacementWheelNumber].setRadius(replacementWheelRadius);
            System.out.println("[УСПЕШНО]\n- Произведена замена колеса.");
        }
    }
    /*------------------------------------------------- Конструктор --------------------------------------------------*/
    Car(String carBrand, int NOW_FUEL, int MAX_TANK, int DISTANCE_TO_TRAVEL, int MAX_MILEAGE){
        if(carBrand == null || carBrand.equals(""))
            throw new IllegalArgumentException("Марка машине не должна быть пустым значением!");
        else
            this.carBrand = carBrand;

        if(NOW_FUEL > MAX_TANK)
            throw new IllegalArgumentException("[ERROR] Текущий объем топлива не может быть больше максимального объёма бака!");
        else
            this.MAX_TANK = MAX_TANK;

        if (NOW_FUEL < MIN_FUEL)
            throw new IllegalArgumentException("[ERROR] Неверный объем стартового топлива (не может быть отрицательным)!");
        else if(NOW_FUEL > MAX_TANK)
            throw new IllegalArgumentException("[ERROR] Неверный объем стартового топлива (не может быть больше объема бака)!");
        else {
            this.NOW_FUEL = NOW_FUEL;
        }

        motor = new Motor(MAX_MILEAGE);

        if(DISTANCE_TO_TRAVEL < this.MIN_DISTANCE_TO_TRAVEL)
            throw new IllegalArgumentException("[ERROR] Расстояние не может быть отрицательным!");
        else this.DISTANCE_TO_TRAVEL = DISTANCE_TO_TRAVEL;
    }
    /*---------------------------------------------------- Конец -----------------------------------------------------*/


}
