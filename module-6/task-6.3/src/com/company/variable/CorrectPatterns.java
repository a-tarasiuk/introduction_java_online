package com.company.variable;

public interface CorrectPatterns {
    String CORRECT_COURSE_PATTERN = "[1-5]{1}";
    String CORRECT_NAME_PATTERN = "[a-zA-Zа-яА-Я]+?";
    String CORRECT_SURNAME_PATTERN = "[a-zA-Zа-яА-Я]+?";
    String CORRECT_AGE_PATTERN = "^(1[7-9]|[2-3][0-5])$";
    String CORRECT_FACULTY_PATTERN = "[а-яА-Я\\w\\s]+?";

    String CORRECT_LOGIN_PATTERN = "[^\\W]+?";
    String CORRECT_PASSWORD_PATTERN = "[^\\s]+?";
    String CORRECT_EMAIL_PATTERN = ".+@.+\\..+";    // в программе не используется, но можно подключить
}
