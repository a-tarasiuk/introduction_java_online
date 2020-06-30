package com.company.data;

import com.company.variable.GeneralMenu;

public enum ItemsMenuAdministrator implements GeneralMenu {
    BACK("Back"),
    VIEW_STUDENTS("View students [...]"),
    EDIT_STUDENT("Edit the student"),
    ADD_NEW_STUDENT("Add new student");

    private final String item;

    ItemsMenuAdministrator(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
