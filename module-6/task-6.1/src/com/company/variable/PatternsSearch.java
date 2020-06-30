package com.company.variable;

public interface PatternsSearch {
    String SEARCH_LOGIN_PATTERN = "^(LOGIN:)";
    String SEARCH_PASSWORD_PATTERN = "^(PASSWORD:)";
    String SEARCH_EMAIL_PATTERN = "^(EMAIL:)";
    String SEARCH_ACCESS_LEVEL_PATTERN = "^(ACCESS_LEVEL:)";
    String SEARCH_ANY_CHARACTERS = "(.*?)";                     // любой набор символов
    String SEARCH_BEFORE_COLON = "(.*?:)";                      // любой набор символов ДО ДВОЕТОЧИЯ
}
