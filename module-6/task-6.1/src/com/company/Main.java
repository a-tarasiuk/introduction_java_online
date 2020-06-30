package com.company;

import com.company.menu.MenuCreator;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * При первом запуске зарегистрируйтесь как новый пользователь и обязательно введите корректный e-mail,
 * на который придет уведомление при смене описания к книге.
 *
 * Данные авторизации администратора + описание приведены в классе EmailSender.java
 */

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MenuCreator menuCreator = new MenuCreator();
        menuCreator.runProgram();
    }
}
