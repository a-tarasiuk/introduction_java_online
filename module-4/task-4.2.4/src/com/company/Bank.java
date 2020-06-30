package com.company;

// БАНК

import java.util.*;

public class Bank extends Actions{
    private String              name = "";                      // название Банка
    private ArrayList<Client>   clients = new ArrayList<>();
    private ArrayList<Client>   sorted;

    /* GET */
    public String getName(){
        return this.name;
    }

    public ArrayList<Client> getArrayListClient(){
        return clients;
    }

    // Сумма баланса на всех счетах одного клиента
    public int getAllBalance(){
        int value = 0;
        for(int i = 0; i < clients.size(); i++){
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++){
                value += clients.get(i).getAccounts().get(j).getBalance();
            }
        }
        return value;
    }

    // Сумма положительного баланса на всех счетах одного клиента
    public int getPositiveBalance(){
        int value = 0;
        for(int i = 0; i < clients.size(); i++){
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++)
                value += Math.max(clients.get(i).getAccounts().get(j).getBalance(), 0);
        }
        return value;
    }

    // Сумма отрицательного баланса на всех счетах одного клиента
    public int getNegativeBalance(){
        int value = 0;
        for(int i = 0; i < clients.size(); i++){
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++)
                value += Math.min(clients.get(i).getAccounts().get(j).getBalance(), 0);
        }
        return value;
    }

    // Вывод всей информации
    public void getAllClientsInformation(ArrayList<?> arrayList){
        System.out.println();
        for(int i = 0; i < arrayList.size(); i++)
            System.out.println((i+1) + ". " + arrayList.get(i).toString());
    }

    // Вывод всей информации по id
    public void getAllClientsInformation(ArrayList<Client> arrayList, int id){
        for(Client c : arrayList)
            for(Account a : c.getAccounts())
                if(a.getId() == id) {
                    System.out.println("\n\tИмя клиента: " + c.getName() + "\n\tВсего счетов: " + c.getAccounts().size() + "\n" + a.toString());
                    break;
                }
    }

    // Вывод всей информации по имени
    public void getAllClientsInformation(ArrayList<Client> arrayList, String name){
        for(Client c : arrayList)
            if (c.getName().equals(name)) {
                System.out.println(c.toString());
                return;
            }
        System.out.println("\n\tКлиента с именем \"" + name + "\" не существует.");
    }

    /* SET */
    // Добавить клиента
    public void addClient(){
        clients.add(new Client());
    }

    // Получить id введенного клиента
    public int getInput(Scanner scanner){
        int maxId = clients.get(clients.size() - 1).getAccounts().get(clients.get(clients.size() - 1).getAccounts().size() - 1).getId();
        int value;
        System.out.print("\n\tВведите ID (минимальный - 0; максимальный - " + maxId + "): ");

        while (true){
            value = scanner.nextInt();
            if(value < 1 || value > maxId)
                System.out.print("\tНеверный ID. Повторите ввод: ");
            else
                break;
        }
        return value;
    }

    // 1. Заблокировать счет
    public void blockId(Scanner scanner){
        int value = getInput(scanner);

        for(int i = 0; i < clients.size(); i++)
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++) {
                if (clients.get(i).getAccounts().get(j).getId() == value && clients.get(i).getAccounts().get(j).setBlock()) {
                    i = clients.size();
                    break;
                }
            }
    }

    // 2. Разблокировать счет
    public void unblockId(Scanner scanner){
        int value = getInput(scanner);

        for(int i = 0; i < clients.size(); i++)
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++) {
                if (clients.get(i).getAccounts().get(j).getId() == value && clients.get(i).getAccounts().get(j).setUnblock()) {
                    i = clients.size();
                    break;
                }
            }
    }

    // 3. Поиск счета
    // 3.1. Поиск счета по id
    public void searchByID(Scanner scanner){
        int value = getInput(scanner);

        getAllClientsInformation(clients, value);
    }

    // 3.2. Поиск счета по имени
    public void searchByName(Scanner scanner){
        scanner.nextLine(); // нужно, чтобы обрезать символы конца строки от предыдущих вводов из клавиатуры
        System.out.print("\n\tВведите имя клиента: ");
        String name = scanner.nextLine();
        getAllClientsInformation(clients, name);
    }

    // 4. Сортировка счетов:
    // 4.1. Сортировка по номеру счета по возрастанию (метод sort)
    public void ascendingId(){
        sorted = new ArrayList<>(clients);
        for(Client c : sorted)
            Collections.sort(c.getAccounts(), Comparator.comparing(Account::getId));

        getAllClientsInformation(sorted);
    }

    // 4.2. Сортировка по номеру счета по убыванию (метод reverse)
    public void descendingId(){
        sorted = new ArrayList<>(clients);
        for(Client c : sorted)
            Collections.sort(c.getAccounts(), Comparator.comparing(Account::getId, Comparator.reverseOrder()));

        getAllClientsInformation(sorted);
    }

    // 4.3. Сортировка баланса по возрастанию (метод sort)
    public void ascendingBalance(){
        sorted = new ArrayList<>(clients);
        for(Client c : sorted)
            Collections.sort(c.getAccounts());

        getAllClientsInformation(sorted);
    }

    // 4.4. Сортировка баланса по убыванию (метод reverse)
    public void descendingBalance(){
        sorted = new ArrayList<>(clients);
        for(Client c : sorted)
            Collections.sort(c.getAccounts(), Collections.reverseOrder());

        getAllClientsInformation(sorted);
    }

    //4.5. Сортировка по имени клиента по возрастанию (метод sort)
    public void ascendingName(){
        sorted = new ArrayList<>(clients);
        sorted.sort(Comparator.comparing(Client::getName));
        System.out.println(sorted);
    }

    // 4.6., 4.7. Сортировка по статусу блокировки
    public void sortByStatus(boolean status){
        for(int i = 0; i < clients.size(); i++)
            for(int j = 0; j < clients.get(i).getAccounts().size(); j++)
                if(clients.get(i).getAccounts().get(j).getStatus() == status) {
                    System.out.println(clients.get(i).getAccounts().get(j).toString());
                }
    }

    /* CONSTRUCTOR */
    Bank(){
        this.name = EnterName();
    }
}
