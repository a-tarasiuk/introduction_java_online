package com.company;

import com.company.menu.Menu;

/**
 * Ручное переопределение метода hashCode() и equals() хорошо описано в книге
 * "Джошуа Блох - Эффективное программирование (2 издание), глава 3, пункт 8 и 9.
 *
 * Вопрос: Почему при вызове boolean используется м-д valueOf()?
 * Ответ: м-д Boolean.valueOf(String) является статическим при вызове которого не происходит создание
 * нового экземпляра объекта, что сокращает системные затраты компьютера.
 * В то время как Boolean(String) создает экземпляр объекта boolean, что по времени больше, чем просто вызов
 * статического м-да valueOf().
 */

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();
    }
}


