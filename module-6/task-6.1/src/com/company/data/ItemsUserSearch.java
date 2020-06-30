package com.company.data;

import com.company.variable.VariablesMenu;

public enum ItemsUserSearch implements VariablesMenu {
    BACK_TO_THE_MENU("Back to the menu"),
    SEARCH_BY_BOOK_TYPE("Search by book type"),
    SEARCH_BY_AUTHOR("Search by author"),
    SEARCH_BY_NAME_BOOK("Search by name book"),
    SEARCH_BY_DESCRIPTION("Search by description"),
    SEARCH_BY_YEAR_OF_PUBLICATION("Search by year of publication"),
    SEARCH_BY_NUMBER_OF_PAGES("Search by number of pages"),
    SEARCH_BY_URL("Search by url");

    private String item;

    ItemsUserSearch(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
