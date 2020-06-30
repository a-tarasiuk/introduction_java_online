package com.company.data;

import com.company.variable.VariablesMenu;

public enum ItemsPageView implements VariablesMenu {
    BACK("Back to the menu"),
    NEXT_PAGE("Next page"),
    PREVIOUS_PAGE("Previous page");

    private String item;

    ItemsPageView(String item){
        this.item = item;
    }

    @Override
    public String getItem() {
        return item;
    }
}
