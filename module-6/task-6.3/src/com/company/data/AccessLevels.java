package com.company.data;

import com.company.variable.GeneralMenu;

public enum AccessLevels implements GeneralMenu {
    ADMINISTRATOR("Administrator"),
    USER("User");

    private String item;

    AccessLevels(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
