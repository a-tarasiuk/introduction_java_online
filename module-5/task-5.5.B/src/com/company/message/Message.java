package com.company.message;

import com.company.pack.Pack;
import com.company.sweet.Sweet;

public class Message {

    public void msgExit(){
        System.out.println("\n\t... Выход из программы.");
    }

    public void msgWelcome(){
        System.out.println("Добро пожаловать!"
                + "\nДавайте создадим подарок!"
                + "\nПодарок состоит из сладостей и упаковки.");
    }

    public void msgYourChoice(){
        System.out.print("\nВаш выбор: ");
    }

    public void msgErrorChoice(){
        System.out.println("\n\t... (Ошибка) Неверный ввод, повторите ввод!");
    }

    public void msgNothingChoice(){
        System.out.println("0. Ничего не выбирать");
    }

    public void msgChoiceSweet(){
        System.out.println("\nКакие сладости добавим в набор:");
    }

    public void msgChooseNow(String string){
        System.out.println("\n\t... Вы выбрали - " + string + ".");
    }

    public void msgChooseComponentSweet(){
        System.out.println("\nТеперь выберите начинку (можно выбирать несколько вариантов):");
    }

    public void msgHowMuchSweet(){
        System.out.print("\nВведите количество выбранной сладости (шт.): ");
    }

    public void msgChoicePack(){
        System.out.println("\nХорошо, теперь выбираем упаковку:");
    }

    public void msgChooseComponentPack(){
        System.out.println("\nТеперь выберите цвет упаковки:");
    }

    public void msgWarningWithoutPack(){
        System.out.println("\n\t... (Информация) Подарок будет без упаковки!");
    }

    public void yourOrder(Sweet sweet, int countSweet, Pack pack){
        int totalCost = 0;
        System.out.println("\nВаш заказ:");
        if(sweet != null) {
            totalCost += sweet.getCost() * countSweet;
            System.out.println("\nСладость: " + sweet.getDescription() +
                    "\nКоличество: " + countSweet + " шт." +
                    "\nЦена: " + totalCost + " BYN.");
        }
        if(pack != null) {
            totalCost += pack.getCost();
            System.out.println("\nУпаковка: " + pack.getDescription() +
                    "\nЦена: " + pack.getCost() + " BYN.");
        }

        System.out.println("\nОбщая стоимость: " + totalCost + " BYN.");
    }
}
