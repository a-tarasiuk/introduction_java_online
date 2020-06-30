package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static String sec (int s){
        return String.format("%02dч. %02dмин. %02dсек.", s / 3600, s % 3600 / 60, s % 60);
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите количество секунд: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(sec(Integer.parseInt(br.readLine())));
    }
}
