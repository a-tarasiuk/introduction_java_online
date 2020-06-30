package com.company.data;

import com.company.variable.VariablesMenu;

public enum  AccessLevels implements VariablesMenu {
    USER("User"),
    ADMINISTRATOR("Administrator");

    private String item;

    AccessLevels(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return this.item;
    }
}
