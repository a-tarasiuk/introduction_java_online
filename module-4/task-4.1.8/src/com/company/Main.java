package com.company;

import java.util.*;

class Customer{
    {
        id_auto_generate++;
    }
    private static  int id_auto_generate;
    private         int     id = id_auto_generate;

    private         String  name,                                       //имя
                            surname,                                    //фамилия
                            patronymic,                                 //отчество
                            address;                                    //адрес проживания
    private         int     numberCreditCard,                           //номер кредитной карты
                            numberBankAccount;                          //номер счета в банке

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getPatronymic(){
        return this.patronymic;
    }

    public String getAddress(){
        return this.address;
    }

    public int getNumberCreditCard(){
        return this.numberCreditCard;
    }

    public int getNumberBankAccount(){
        return this.numberBankAccount;
    }

    public String toString(){
        return String.format("ID: %03d | %10s %10s %10s | Адресс: %15s | Номер кредитной карты: %10d | Номер банковского счета: %10d", id, name, surname, patronymic, address, numberCreditCard, numberBankAccount);
    }

    Customer(String name, String surname, String patronymic, String address, int numberCreditCard, int numberBankAccount) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.numberCreditCard = numberCreditCard;
        this.numberBankAccount = numberBankAccount;
    }
}

class Bank{
    private String nameBank;
    private ArrayList<Customer> customerList = new ArrayList<>();

    void addCustomerToBank(Customer c){
        customerList.add(c);
    }

    //сортировка по имени
    List<Customer> getCustomerByName(){
        List<Customer> lc = new ArrayList<>(customerList);
        Collections.sort(lc, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2){
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });
        return lc;
    }

    //сортировка по фамилии
    List<Customer> getCustomerBySurname(){
        List<Customer> lc = new ArrayList<>(customerList);
        Collections.sort(lc, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2){
                return c1.getSurname().compareToIgnoreCase(c2.getSurname());
            }
        });
        return lc;
    }

    //сортировка по отчеству
    List<Customer> getCustomerByPatronymic(){
        List<Customer> lc = new ArrayList<>(customerList);
        Collections.sort(lc, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2){
                return c1.getPatronymic().compareToIgnoreCase(c2.getPatronymic());
            }
        });
        return lc;
    }

    //сортировка по номерам кредитных карт в заданном диапазоне
    List<Customer> getCustomerFromDiapasonCreditCard(int start, int end){
        List<Customer> lc = new ArrayList<>();
        for(Customer c : customerList){
            if(c.getNumberCreditCard() >= start && c.getNumberCreditCard() <= end) lc.add(c);
        }
        return lc;
    }

    Bank(String nameBank){
        this.nameBank = nameBank;
    }

}

public class Main {// write your code here

    public static void main(String[] args) {
        //создаем банк
        Bank b = new Bank("Gold Status Bank");

        //добавляем клиентов
        b.addCustomerToBank(new Customer("Вадим", "Вадимов", "Вадимович", "РБ, г.Брест", 47000345, 12345));
        b.addCustomerToBank(new Customer("Игорь", "Петров", "Щелкович", "РБ, г.Кобрин", 47023231, 45678));
        b.addCustomerToBank(new Customer("Анна", "Анниковка", "Анникович", "Украина, г.Киев", 46271845, 45362));
        b.addCustomerToBank(new Customer("Петр", "Петров", "Петрович", "РФ, г.Москва", 19192831, 90000));
        b.addCustomerToBank(new Customer("Азиков", "Юкович", "Азец", "РФ, г.Москва", 24567811, 70000));

        System.out.println("Сортировка по имени:");
        List<Customer> sortByName = b.getCustomerByName();
        for(Customer c : sortByName) System.out.println(c);

        System.out.println("\nСортировка по фамилии:");
        List<Customer> sortBySurname = b.getCustomerBySurname();
        for(Customer c : sortBySurname) System.out.println(c);

        System.out.println("\nСортировка по отчеству:");
        List<Customer> sortByPatronymic = b.getCustomerByPatronymic();
        for(Customer c : sortByPatronymic) System.out.println(c);

        System.out.println("\nСортировка по номеру кредитной карты (в заданном диапазоне - от 1 до 30000000):");
        List<Customer> sortByDiapasonCreditCard = b.getCustomerFromDiapasonCreditCard(1, 30000000);
        for(Customer c : sortByDiapasonCreditCard) System.out.println(c);
    }
}
