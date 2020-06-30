package com.company.data;

import com.company.variable.GeneralMenu;

public enum ItemsMenuUser implements GeneralMenu {
    BACK("Back"),
    VIEW_STUDENTS("View students [...]");

    private final String item;

    ItemsMenuUser(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
