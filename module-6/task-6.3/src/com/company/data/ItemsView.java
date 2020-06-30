package com.company.data;

import com.company.variable.GeneralMenu;

public enum  ItemsView implements GeneralMenu {
    BACK("Back"),
    VIEW_ALL_STUDENTS("View all students"),
    VIEW_BY_NAME("View student by name"),
    VIEW_BY_SURNAME("View student by surname"),
    VIEW_BY_AGE("View student by age"),
    VIEW_BY_FACULTY("View student by faculty");

    private final String item;

    ItemsView(String item){
        this.item = item;
    }

    @Override
    public String getItem(){
        return item;
    }
}
