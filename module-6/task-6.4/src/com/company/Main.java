package com.company;

import com.company.port.Port;

/**
 * Консольное приложение будет выполняться бесконечно, пока не остановить вручную.
 */

public class Main {

    public static void main(String[] args) {
        Port port = new Port();
        port.start();
    }
}
