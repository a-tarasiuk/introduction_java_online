package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Тактовая частота. Сервер для приложений. Оперативная память! Сколько будет выполняться программа?";
        int count = str.split("[!?.]").length;
        System.out.println("Исходная строка:\n" + str + "\nВ которой содержится предложений: " + count);
    }
}
