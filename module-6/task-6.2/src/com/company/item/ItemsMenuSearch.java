package com.company.item;

import com.company.data.Variables;

public enum ItemsMenuSearch implements Variables {
    BACK("Back"),
    BY_DATE("Search by date"),
    BY_THEME("Search by theme"),
    BY_MAIL("Search by mail"),
    BY_MESSAGE("Search by message"),
    BY_KEYWORD("Search by keyword");       // поиск по ключевому слову (найти записи, текстовое поле которых содержит определенное слово)

    private String item;

    ItemsMenuSearch(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
