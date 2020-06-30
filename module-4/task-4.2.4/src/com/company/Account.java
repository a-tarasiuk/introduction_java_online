package com.company;

// СЧЕТ В БАНКЕ

public class Account implements Comparable<Account>{
    {
        id_auto_generate++;
    }
    private static  int     id_auto_generate;
    private         int     id = id_auto_generate;
    private         int     balance = 0;        // баланс счета
    private         boolean blocked = false;    // статус блокировки аккаунта (false - рабочий, true - заблокирован)

    @Override
    public String toString(){
        return "\tсчет №: " + id +
                " | blocked: " + blocked +
                " | balance: " + balance + " USD";
    }

    public int getId(){
        return this.id;
    }

    public boolean getStatus(){
        return this.blocked;
    }

    public int getBalance(){
        return this.balance;
    }

    public boolean setBlock(){
        if(this.blocked)
            System.out.println("\tОшибка! Невозможно повторно заблокировать счет. ");
        else {
            this.blocked = true;
            System.out.println("\tУспешно! Счет заблокирован!");
        }
        return this.blocked;
    }

    public boolean setUnblock(){
        if(!this.blocked)
            System.out.println("\tОшибка! Невозможно повторно разблокировать счет. ");
        else {
            this.blocked = false;
            System.out.println("\tУспешно! Счет разблокирован!");
        }
        return this.blocked;
    }

    @Override
    public int compareTo(Account compareAccount){
        int value = ((Account) compareAccount).getBalance();
        // в порядке возрастания
        return this.balance - value;
    }

    Account(){
        this.blocked = false;
        this.balance = (int)(Math.random() * (200 + 1) - 100);  // генерация баланса в диапазоне [-100;100]
    }
}
