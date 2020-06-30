package com.company;

    /*
        Необходимо заполнить:
            # carBrand - марка автомобиля
            # NOW_FUEL - начальный уровень топлива
            # MAX_TANK - максимальный объем топливного бака
            # DISTANCE_TO_TRAVEL - расстояние, которое необходимо проехать
            # MAX_MILEAGE - ресурс двигателя в км. (при создании объекта класса 'Motor' в классе 'Motor')
    */

public class Main{
    public static void main(String[] args) {
        boolean choice = true;
        int validKey[] = {0, 1, 2, 3, 4, 5, 6, 7};

        Car car = new Car("BMW", 20, 30, 20, 25);

        Messages m = new Messages();
        m.getMessageWelcome();

        try {
            while (choice){
                /* Для отслеживания статуса дочернего потока:
                System.out.println("\nИмя потока: " + car.getName() + "\nСтатус: " + car.getState());
                */

                m.getMessageChoice();

                switch (m.getChoice(validKey)){
                    case 0:
                        choice = false;
                        break;
                    case 1:
                        car.startMotor();
                        break;
                    case 2:
                        car.stopMotor();
                        break;
                    case 3:
                        car.letsGo();
                        break;
                    case 4:
                        System.out.print("На сколько литров заправиться: ");
                        car.toRefuel(m.getChoice(0));
                        break;
                    case 5:
                        car.replaceWheel();
                        break;
                    case 6:
                        System.out.format("%-50s %s\n", "\t- Марка автомобиля: ", car.getCarBrand());
                        break;
                    case 7:
                        car.getAllSensors();
                        break;
                }
            }
            //ожидаем завершения потока `car` (с помощью вызова метода `join()`)
            car.join();
        } catch (InterruptedException e){
            System.out.println("Главный поток исполнения прерван.");
        }
    }
}
