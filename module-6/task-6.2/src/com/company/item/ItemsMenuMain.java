package com.company.item;

import com.company.data.Variables;

public enum ItemsMenuMain implements Variables {
    EXIT("Exit"),
    VIEW_ALL_NOTES("View all notes"),
    ADD_NEW_NOTE("Add new note"),
    SEARCH_BY("Search by..."),
    SORT_BY("Sort by...");

    private String item;

    ItemsMenuMain(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
