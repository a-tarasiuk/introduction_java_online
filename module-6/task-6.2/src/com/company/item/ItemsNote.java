package com.company.item;

public enum ItemsNote {
    DATE("Date"),
    THEME("Theme"),
    MAIL("Mail"),
    MESSAGE("Message");

    private String item;

    ItemsNote(String item){
        this.item = item;
    }

    //@Override
    public String getItem() {
        return item;
    }
}
