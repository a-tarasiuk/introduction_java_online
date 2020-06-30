package com.company.item;

import com.company.data.Variables;

public enum ItemsMenuSort implements Variables {
    BACK("Back"),
    BY_DATE("Sort by date"),
    BY_THEME("Sort by theme"),
    BY_MAIL("Sort by mail"),
    BY_MESSAGE("Sort by message"),
    BY_DATE_AND_THEME("Sort by date & theme");

    private String item;

    ItemsMenuSort(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
