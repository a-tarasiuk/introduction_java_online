package com.company;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Набор символов в коде ASCII занимает первые 127 значений
 * Набор символов в коде ISO-Latin-1 занимает первые 255 значений
 * Почему тип int преобразуется в char? Потому, что назначение типа char - представлять символы в Юникоде
 * стр. 84 - Java - Полное руководство, 10 издание (Герберт Шилдт)
 */

public class Main {

    public static void main(String[] args) {
        char a = 0;
        InputStreamReader scanner = new InputStreamReader(System.in);

        System.out.print("\nEnter symbol: ");

        try {
            a = (char) scanner.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Символ " + a + " - численное обозначение в памяти компьютера " + (int)a);
    }
}
