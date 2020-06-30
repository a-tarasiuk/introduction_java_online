package com.company;

// КЛИЕНТ

import java.util.ArrayList;

public class Client extends Actions {
    private String              name = "";                      // имя клиента
    private ArrayList<Account>  accounts = new ArrayList<>();

    /* SET */
    public void addAccount(){
        accounts.add(new Account());
    }

    /* GET */
    public String getName(){
        return this.name;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    @Override
    public String toString(){
        String output = "\nКлиент: " + this.name + ":";
        for(int i = 0; i < accounts.size(); i++)
            output += "\n-" + accounts.get(i).toString();
        return output;
    }

    /* CONSTRUCTOR */
    Client(){
        int max = 1 + (int)(Math.random() * (10 + 1));      // максимальное кол-во счетов у клиента
        this.name = EnterName();                            // создаем рандомное имя клиенту
        for(int i = 0; i < max; i++)
            addAccount();
    }
}
