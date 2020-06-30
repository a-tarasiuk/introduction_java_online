package com.company.data;

import com.company.variable.VariablesMenu;

public enum ItemsAdministrator implements VariablesMenu {
    EXIT("Exit"),
    VIEW_ALL_BOOKS("View all books"),
    ADD_BOOK("Add book"),
    DELETE_BOOK("Delete book"),
    ADD_DESCRIPTION("Change book description");

    private String item;

    ItemsAdministrator(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
