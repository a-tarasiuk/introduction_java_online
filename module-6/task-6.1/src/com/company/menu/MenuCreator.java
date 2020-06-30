package com.company.menu;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MenuCreator {
    private final MenuAuthorization menuAuthorization;
    private final MenuBooks menuBooks;

    public MenuCreator() throws IOException, NoSuchAlgorithmException {
        menuAuthorization = new MenuAuthorization();
        menuBooks = new MenuBooks(menuAuthorization.getCookies());
    }

    public void runProgram() throws IOException {
        menuBooks.menuCall();
    }
}
