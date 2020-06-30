package com.company.variable;

public interface PatternsCorrect {
    String CORRECT_LOGIN_PATTERN = "(.+[^(.*!@#$%^&_=\\-\\s)])";
    String CORRECT_PASSWORD_PATTERN = "(.+[^\\s])";
    String CORRECT_EMAIL_PATTERN = ".+@.+\\..+";
}
