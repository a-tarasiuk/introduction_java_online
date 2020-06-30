package com.company.constructor;

public class Message {
    public void messageYourChoice(){
        System.out.print("\nВаш выбор: ");
    }

    public void messageWhatFlowers(){
        System.out.println("\nБукет из каких цветов вы желаете создать:");
    }

    public void messageHowMuch(){
        System.out.print("\nСколько цветов будет в букете: ");
    }

    public void messageWhatPack(){
        System.out.println("\nВыберите упаковку для букета:");
    }

    public void messageErrorChoice(){
        System.out.println("\n\t...(Ошибка) Введеное неверное количество! Повторите ввод.");
    }
}
