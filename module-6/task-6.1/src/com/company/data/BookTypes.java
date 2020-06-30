package com.company.data;

import com.company.variable.VariablesMenu;

public enum  BookTypes implements VariablesMenu {
    PAPER("Paper version"),
    ELECTRONIC("Electronic version");

    private String item;

    BookTypes(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
