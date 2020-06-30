package com.company.finalProduct;

import com.company.factoryComponentPack.*;
import com.company.factoryComponentSweet.*;
import com.company.factoryPack.FactoryBox;
import com.company.factoryPack.FactoryPack;
import com.company.factoryPack.FactoryPackage;
import com.company.factorySweet.*;
import com.company.message.Message;
import com.company.pack.Pack;
import com.company.sweet.Sweet;
import com.company.typeElements.*;

import java.util.Scanner;

public class Constructor extends Message {
    private Sweet sweet;            // объект сладости
    private Pack pack;              // объект упаковки
    private Types typeElement;      // выбранный тип сладости/упаковки
    private int countSweet;         // количество сладостей

    public void start(){
        msgWelcome();

        /* если пользователь не выбрал тип сладости, то выходим из программы */
        if(!createTypeSweet()) {
            msgExit();
            return;
        }
        createComponentSweet();
        createCountSweet();
        if(createTypePack())
            createComponentPack();
        else
            msgWarningWithoutPack();

        yourOrder(sweet, countSweet, pack);
    }

    /* выбираем количество сладостей */
    public void createCountSweet(){
        while (true){
            msgHowMuchSweet();
            countSweet = new Scanner(System.in).nextInt();
            if(countSweet <= 0) msgErrorChoice();
            else break;
        }
    }

    /* выбираем тип сладости */
    public boolean createTypeSweet(){
        msgChoiceSweet();
        typeElement = choiceEnum(TypeSweet.values(), false);

        if(typeElement == null)
            return false;
        else {
            FactorySweet factorySweet = creatorFactorySweet(typeElement.getName());
            sweet = factorySweet.create();
        }

        msgChooseNow(sweet.getDescription());

        return true;
    }

    /* выбираем начинку сладостей */
    public void createComponentSweet(){
        msgChooseComponentSweet();

        while (true) {
            typeElement = choiceEnum(TypeFilling.values(), false);

            if(typeElement == null)
                break;
            else {
                FactoryComponentSweet factoryComponentSweet = creatorFactoryComponentSweet(typeElement.getName());
                sweet = factoryComponentSweet.create();
            }

            msgChooseNow(sweet.getDescription());
        }
    }

    public boolean createTypePack(){
        msgChoicePack();
        typeElement = choiceEnum(TypePack.values(), false);

        if(typeElement == null)
            return false;
        else {
            FactoryPack factoryPack = creatorFactoryPack(typeElement.getName());
            pack = factoryPack.create();
        }

        msgChooseNow(pack.getDescription());

        return true;
    }

    public void createComponentPack(){
        msgChooseComponentPack();
        typeElement = choiceEnum(TypeColour.values(), true);

        FactoryComponentPack factoryComponentPack = creatorFactoryComponentPack(typeElement.getName());
        pack = factoryComponentPack.create();

        msgChooseNow(pack.getDescription());
    }

    /* Возвращает тип (Sweet либо Pack), выбранный пользователем.
    * За что отвечает boolean withoutZero:
    * - если withoutZero = true, то в пункте меню будет отсутствовать пункт "0. Ничего не выбирать";
    * - если withoutZero = false, то в пункте меню будет присутствовать пункт "0. Ничего не выбирать".
    */
    private <T extends Types> Types choiceEnum(T[] type, boolean withoutZero){
        int minValue = 1;
        int choice;

        if(!withoutZero) {
            minValue = 0;
            msgNothingChoice();
        }

        for(int i = 0; i < type.length; i++)
            System.out.println((i + 1) + ". " + type[i].getName() + " (цена за единицу - " + type[i].getCost() + " BYN);");

        while (true){
            msgYourChoice();
            choice = new Scanner(System.in).nextInt();
            if(choice < minValue || choice > type.length)
                msgErrorChoice();
            else if (choice == 0)
                return null;
            else
                return type[choice - 1];
        }
    }

    /* Создатель Сладостей */
    private FactorySweet creatorFactorySweet(String component){
        if(component.equalsIgnoreCase(TypeSweet.CANDY.getName()))
            return new FactoryCandy();
        else if(component.equalsIgnoreCase(TypeSweet.CHOCOLATE.getName()))
            return new FactoryChocolate();
        else if(component.equalsIgnoreCase(TypeSweet.WAFFLES.getName()))
            return new FactoryWaffles();
        else
            throw new RuntimeException("Компонента - " + component + " не существует!");
    }

    /* Создатель компонентов Сладостей */
    private FactoryComponentSweet creatorFactoryComponentSweet(String component){
        if(component.equalsIgnoreCase(TypeFilling.CACAO.getName()))
            return new FactoryCacao(sweet);
        else if(component.equalsIgnoreCase(TypeFilling.NUTS.getName()))
            return new FactoryNuts(sweet);
        else if(component.equalsIgnoreCase(TypeFilling.SUGAR.getName()))
            return new FactorySugar(sweet);
        else if(component.equalsIgnoreCase(TypeFilling.SESAME.getName()))
            return new FactorySesame(sweet);
        else
            throw new RuntimeException("Компонента - " + component + " не существует!");
    }

    /* создатель Упаковок */
    private FactoryPack creatorFactoryPack(String component){
        if(component.equalsIgnoreCase(TypePack.BOX.getName()))
            return new FactoryBox();
        else if(component.equalsIgnoreCase(TypePack.PACKAGE.getName()))
            return new FactoryPackage();
        else
            throw new RuntimeException("Компонента - " + component + " не существует!");
    }

    /* Создатель компонентов Упаковок */
    private FactoryComponentPack creatorFactoryComponentPack(String component){
        if(component.equalsIgnoreCase(TypeColour.BLACK.getName()))
            return new FactoryBlack(pack);
        else if(component.equalsIgnoreCase(TypeColour.BLUE.getName()))
            return new FactoryBlue(pack);
        else if(component.equalsIgnoreCase(TypeColour.PINK.getName()))
            return new FactoryPink(pack);
        else if(component.equalsIgnoreCase(TypeColour.RED.getName()))
            return new FactoryRed(pack);
        else if(component.equalsIgnoreCase(TypeColour.WHITE.getName()))
            return new FactoryWhite(pack);
        else
            throw new RuntimeException("Компонента - " + component + " не существует!");
    }
}
