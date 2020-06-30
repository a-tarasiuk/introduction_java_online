package com.company.data;

import com.company.variable.VariablesMenu;

public enum ItemsAuthorization implements VariablesMenu {
    EXIT("Exit"),
    AUTHORIZATION("Authorization"),
    REGISTRATION("Registration (for new users)");

    private String item;

    ItemsAuthorization(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
