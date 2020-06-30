package com.company.data;

import com.company.variable.GeneralMenu;

public enum  ItemsMenu implements GeneralMenu {
    EXIT("Exit"),
    AUTHORIZATION("Authorization"),
    REGISTRATION("Registration (for new users)");

    private final String item;

    ItemsMenu(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
