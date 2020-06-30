package com.company.user;

import com.company.variable.Prefixes;

public class User implements Prefixes {
    private final String LOGIN;          // Логин пользователя
    private final String PASSWORD;       // Пароль пользователя
    private final String EMAIL;          // Почта пользователя
    private final String ACCESS_LEVEL;   // Уровень доступа (простой пользователь, администратор)

    public User(String login, String password, String email, String accessLevel){
        this.LOGIN = login;
        this.PASSWORD = password;
        this.EMAIL = email;
        this.ACCESS_LEVEL = accessLevel;
    }

    public String getLogin(){
        return this.LOGIN;
    }

    public String getPassword(){
        return this.PASSWORD;
    }

    public String getEmail(){
        return this.EMAIL;
    }

    public String getAccessLevel(){
        return this.ACCESS_LEVEL;
    }

    @Override
    public String toString(){
        return  PREFIX_LOGIN + LOGIN +
                PREFIX_PASSWORD + PASSWORD +
                PREFIX_EMAIL + EMAIL +
                PREFIX_ACCESS_LEVEL + ACCESS_LEVEL +
                POSTFIX;
    }
}
