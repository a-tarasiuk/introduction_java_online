package com.company.book;

import com.company.data.BookTypes;
import com.company.data.PathDatabase;
import com.company.variable.VariablesBook;
import com.company.menu.MenuAuthorization;
import com.company.message.MsgWorkWithBook;
import com.company.sender.EmailSender;

import java.util.Scanner;

public class Book extends MsgWorkWithBook implements VariablesBook {

    private String  BOOK_TYPE;                  // Тип книги (бумажный, электронный экземпляр)
    private String  URL;                        // электронный адрес книги
    private String  AUTHOR;                     // Автор
    private String  NAME_BOOK;                  // Название книги
    private String  DESCRIPTION;                // Описание
    private int     YEAR_OF_PUBLICATION;        // Год публикации
    private int     NUMBER_OF_PAGES;            // Количество страниц

    // параметр withNotice - с уведомлением (true - отсылать на всем пользователям на почту уведомление о книге)
    public Book(String bookType, boolean withNotice){
        this.BOOK_TYPE = bookType;
        createBook();
        if(withNotice) {
            EmailSender sender = new EmailSender(MenuAuthorization.getAllMailsFromDatabase(PathDatabase.ACCOUNTS.toString()));
            sender.send("THEME: New Book Offer!", this, null);
        }
    }

    public Book(String BOOK_TYPE, String AUTHOR, String NAME_BOOK, int YEAR_OF_PUBLICATION, int NUMBER_OF_PAGES, String DESCRIPTION, String URL){
        this.BOOK_TYPE = BOOK_TYPE;
        this.AUTHOR = AUTHOR;
        this.NAME_BOOK = NAME_BOOK;
        this.YEAR_OF_PUBLICATION = YEAR_OF_PUBLICATION;
        this.NUMBER_OF_PAGES = NUMBER_OF_PAGES;
        this.DESCRIPTION = DESCRIPTION;
        this.URL = URL;
    }

    private void createBook(){
        if(BOOK_TYPE == BookTypes.ELECTRONIC.getItem())
            setUrl();
        setAuthor();
        setNameBook();
        setNumberOfPages();
        setYearOfPublication();
        setDescription();
        msgBookWasCreated();
    }

    public void setBookType(String bookType) {
        this.BOOK_TYPE = bookType;
    }

    private void setUrl(){
        this.URL = "www." + getCorrectString(msgEnterUrl());
    }

    public void setUrl(String url) {
        this.URL = url;
    }

    private void setAuthor(){
        this.AUTHOR = getCorrectString(msgEnterAuthor());
    }

    public void setAuthor(String author) {
        this.AUTHOR = author;
    }

    private void setNameBook(){
        this.NAME_BOOK = getCorrectString(msgEnterNameBook());
    }

    public void setNameBook(String nameBook) {
        this.NAME_BOOK = nameBook;
    }

    private void setNumberOfPages(){
        this.NUMBER_OF_PAGES = getCorrectInt(msgEnterNumberOfPages());
    }

    public void setNumberOfPages(int numberOfPages) {
        this.NUMBER_OF_PAGES = numberOfPages;
    }

    private void setYearOfPublication(){
        this.YEAR_OF_PUBLICATION = getCorrectInt(msgEnterYearOfPublication());
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.YEAR_OF_PUBLICATION = yearOfPublication;
    }

    public void setDescription(){
        this.DESCRIPTION = getCorrectString(msgEnterDescription());
    }

    public void setDescription(String description) {
        this.DESCRIPTION = description;
    }

    public String getBookType(){
        return this.BOOK_TYPE;
    }

    public String getDescription(){
        return this.DESCRIPTION;
    }

    public String getAuthor(){
        return this.AUTHOR;
    }

    public String getNameBook(){
        return this.NAME_BOOK;
    }

    public int getYearOfPublication(){
        return this.YEAR_OF_PUBLICATION;
    }

    public int getNumberOfPages(){
        return this.NUMBER_OF_PAGES;
    }

    public String getUrl(){
        return this.URL;
    }

    public static String getCorrectString(String msg){
        String string;
        while (true){
            System.out.print(msg);
            string = new Scanner(System.in).nextLine();
            if(string != null && !string.isEmpty()) break;
            else msgInvalidInput();
        }
        return string;
    }

    public static int getCorrectInt(String msg){
        int value;
        while (true){
            System.out.print(msg);
            value = new Scanner(System.in).nextInt();
            if(value > 0) break;
            else msgInvalidInput();
        }
        return value;
    }

    // метод возвращает информацию о книге в объекте типа StringBuilder
    public StringBuilder toStringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_BOOK_TYPE).append(BOOK_TYPE).append("\n");
        sb.append(PREFIX_AUTHOR).append(AUTHOR).append("\n");
        sb.append(PREFIX_NAME_BOOK).append(NAME_BOOK).append("\n");
        sb.append(PREFIX_YEAR_OF_PUBLICATION).append(YEAR_OF_PUBLICATION).append("\n");
        sb.append(PREFIX_NUMBER_OF_PAGES).append(NUMBER_OF_PAGES).append("\n");
        sb.append(PREFIX_DESCRIPTION).append(DESCRIPTION).append("\n");
        if(URL != null)
            sb.append(PREFIX_URL).append(URL).append("\n");
        else
            sb.append(PREFIX_URL).append("-").append("\n");
        return sb;
    }

    @Override
    public String toString(){
        return String.format(msgFormat(), BOOK_TYPE, AUTHOR, NAME_BOOK, YEAR_OF_PUBLICATION, NUMBER_OF_PAGES, DESCRIPTION, URL);
    }
}
