package com.company;

import java.util.Scanner;

public class Main extends Messages {
    public static void mainMenu(Bank b, Scanner scanner){

        // 2. Создаем клиентов в банке
        for(int i = 0; i < 50; i++)
            b.addClient();

        // 3. Выводим информацию
        System.out.println("Создан банк: " + b.getName());

        while (true){
            int key = 0;
            messageMainMenu();
            System.out.print("Ваш выбор: ");
            key = scanner.nextInt();
            switch (key){
                case 0:
                    System.out.println("\n\tЗавершение программы...");
                    return;
                case 1:
                    b.blockId(scanner);
                    break;
                case 2:
                    b.unblockId(scanner);
                    break;
                case 3:
                    searchMenu(b, scanner);
                    break;
                case 4:
                    sortMenu(b, scanner);
                    break;
                case 5:
                    System.out.println("\n\tОбщая сумма по всем счетам составила: " + b.getAllBalance() + " USD.");
                    break;
                case 6:
                    System.out.println("\n\tОбщая сумма отрицательных балансов: " + b.getNegativeBalance() + " USD.");
                    break;
                case 7:
                    System.out.println("\n\tОбщая сумма положительных балансов: " + b.getPositiveBalance() + " USD.");
                    break;
                case 8:
                    b.getAllClientsInformation(b.getArrayListClient());
                    break;
                default:
                    System.out.println("\n\t- Неверный выбор. Повторите ввод...");
            }
        }
    }

    public static void sortMenu(Bank b, Scanner scanner){
        while (true){
            int key = 0;
            messageSortAccounts();
            System.out.print("Ваш выбор: ");
            key = scanner.nextInt();
            switch (key){
                case 0:
                    System.out.println("\n\tВозврат в главное меню...");
                    return;
                case 1:
                    b.ascendingId();
                    break;
                case 2:
                    b.descendingId();
                    break;
                case 3:
                    b.ascendingBalance();
                    break;
                case 4:
                    b.descendingBalance();
                    break;
                case 5:
                    b.ascendingName();
                    break;
                case 6:
                    b.sortByStatus(false);
                    break;
                case 7:
                    b.sortByStatus(true);
                    break;
                default:
                    System.out.println("\n\t- Неверный выбор. Повторите ввод...");
            }
        }
    }

    public static void searchMenu(Bank b, Scanner scanner){
        while (true){
            int key = 0;
            messageSearch();
            System.out.print("Ваш выбор: ");
            key = scanner.nextInt();
            switch (key){
                case 0:
                    System.out.println("\n\tВозврат в главное меню...");
                    return;
                case 1:
                    b.searchByID(scanner);
                    break;
                case 2:
                    b.searchByName(scanner);
                    break;
                default:
                    System.out.println("\n\t- Неверный выбор. Повторите ввод...");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. Создаем банк
        Bank b = new Bank();
        mainMenu(b, scanner);
    }
}
