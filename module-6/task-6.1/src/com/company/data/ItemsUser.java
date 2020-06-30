package com.company.data;

import com.company.variable.VariablesMenu;

public enum ItemsUser implements VariablesMenu {
    EXIT("Exit"),
    VIEW_ALL_BOOKS("View all books"),
    SEARCH_BOOKS("Search book by"),
    OFFER_BOOK("Offer a book");             // предложить книгу (отправляется администраторам на e-mail)

    private String item;

    ItemsUser(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
