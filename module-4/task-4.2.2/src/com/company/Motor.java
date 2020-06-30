package com.company;

// Д В И Г А Т Е Л Ь

public class Motor {
    /*private*/ boolean TURN_ON,                    //состояние двигателя (включен, выключен)
                    LOCK_MOTOR = false;         //блокировка двигателя (включается при максимальном пробеге)
    private int     MILEAGE,                    //пробег (текущий) в км.
                    MAX_MILEAGE;                //пробег (максимальный) в км.

    public void getMessageMotorIsBroken(){
        System.out.println("[ERROR] Причина остановки двигателя - Двигатель износился!");
    }

    //получить показателя двигателя
    public void getMileage(){
        System.out.format("%-50s %b\n", "\t- Состояние двигателя: ", this.TURN_ON);
        System.out.format("%-50s %b\n", "\t- Блокировка двигателя: ", LOCK_MOTOR);
        System.out.format("%-50s %d %s\n", "\t- Текущий пробег двигателя: ", this.MILEAGE, "(км)");
        System.out.format("%-50s %d %s\n", "\t- Максимальнодопустимый пробег двигателя: ", this.MAX_MILEAGE, "(км)");
    }

    //получить состояние двигателя (включен, выключен))
    public boolean getMotorStatus(){
        if(!this.TURN_ON) System.out.println("[ИНФОРМАЦИЯ]\n- Двигатель находится в выключенном состоянии.");
        return this.TURN_ON;
    }

    //увеличить текущий пробег
    public boolean increaseMileage(int value){
        if(this.MILEAGE < MAX_MILEAGE) {
            this.MILEAGE += value;
            //System.out.println("Пройденное расстояние: " + this.MILEAGE + " (км)");
            return true;
        }
        else {
            this.LOCK_MOTOR = true;
            this.stopMotor();
            getMessageMotorIsBroken();
            return false;
        }
    }

    //завести двигатель
    public void startMotor(){
        //если двигатель заведен
        if(this.TURN_ON){
            System.out.println("[ПРЕДУПРЕЖДЕНИЕ]\n- Двигатель уже заведен!");
        }
        //иначе (если двигатель заглушен)
        else {
            if(this.LOCK_MOTOR) getMessageMotorIsBroken();
            else this.TURN_ON = true;                                //завести двигатель
            System.out.println("[УСПЕШНО]\n- Завели двигатель!");
        }
    }

    //заглушить двигатель
    public void stopMotor(){
        this.TURN_ON = false;
        System.out.println("\n[УСПЕШНО]\n- Двигатель заглушен!");
    }

    //конструктор (с выключеным двигателем)
    Motor(int MAX_MILEAGE){
        this.TURN_ON = false;
        this.MAX_MILEAGE = MAX_MILEAGE;
        this.MILEAGE = 0;
    }
}
