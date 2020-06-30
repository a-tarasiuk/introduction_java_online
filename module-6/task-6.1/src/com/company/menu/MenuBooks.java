package com.company.menu;

import com.company.book.Book;
import com.company.variable.VariablesBook;
import com.company.data.*;
import com.company.variable.PatternsSearch;
import com.company.message.MsgWorkWithBook;
import com.company.sender.EmailSender;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MenuBooks extends Path implements VariablesBook, PatternsSearch {
    private String ACCESS_LEVEL;
    private final MsgWorkWithBook msg;

    MenuBooks(ArrayList<String> USER_COOKIES) {
        super(PathDatabase.BOOKS);
        getSeparateCookies(USER_COOKIES);
        msg = new MsgWorkWithBook();
    }

    // получаем строку вида "ACCESS_LEVEL:XXX" и заменяем все, что следует до двоеточия (включительно) на "".
    private void getSeparateCookies(ArrayList<String> USER_COOKIES) {
        for(String data : USER_COOKIES) {
            if(data.matches(SEARCH_ACCESS_LEVEL_PATTERN + SEARCH_ANY_CHARACTERS))
                ACCESS_LEVEL = data.replaceAll(SEARCH_BEFORE_COLON, "");
        }
    }

    // метод, который в зависимости от ACCESS_LEVEL вызывает соответствующее меню
    public void menuCall() {
        if(ACCESS_LEVEL.equals(AccessLevels.ADMINISTRATOR.getItem()))
            menuForAdministrator();
        else
            menuForUser();
    }

    private void menuForAdministrator() {
        while (true){
            switch (Actions.getUserSelect(ItemsAdministrator.values())){
                case "Exit":
                    return;
                case "View all books":
                    bookOutput();
                    break;
                case "Add book":
                    addBookToDatabase(false);
                    break;
                case "Delete book":
                    deleteBookFromDatabase();
                    break;
                case "Change book description":
                    changeDescription();
                    break;
            }
        }
    }

    private void menuForUser(){
        while (true){
            switch (Actions.getUserSelect(ItemsUser.values())){
                case "Exit":
                    return;
                case "View all books":
                    bookOutput();
                    break;
                case "Search book by":
                    searchBookBy();
                    break;
                case "Offer a book":
                    addBookToDatabase(true);
                    break;
            }
        }
    }

    private void searchBookBy(){
        while (true){
            switch (Actions.getUserSelect(ItemsUserSearch.values())){
                case "Back to the menu":
                    return;
                case "Search by book type":
                    searchBy(ItemsUserSearch.SEARCH_BY_BOOK_TYPE);
                    break;
                case "Search by author":
                    searchBy(ItemsUserSearch.SEARCH_BY_AUTHOR);
                    break;
                case "Search by name book":
                    searchBy(ItemsUserSearch.SEARCH_BY_NAME_BOOK);
                    break;
                case "Search by description":
                    searchBy(ItemsUserSearch.SEARCH_BY_DESCRIPTION);
                    break;
                case "Search by year of publication":
                    searchBy(ItemsUserSearch.SEARCH_BY_YEAR_OF_PUBLICATION);
                    break;
                case "Search by number of pages":
                    searchBy(ItemsUserSearch.SEARCH_BY_NUMBER_OF_PAGES);
                    break;
                case "Search by url":
                    searchBy(ItemsUserSearch.SEARCH_BY_URL);
                    break;
            }
        }
    }

    private void searchBy(ItemsUserSearch item) {
        if(item.equals(ItemsUserSearch.SEARCH_BY_BOOK_TYPE))
            displayByBookType(Actions.getUserSelect(BookTypes.values()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_AUTHOR))
            displayByAuthor(Book.getCorrectString(msg.msgEnterAuthor()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_NAME_BOOK))
            displayByNameBook(Book.getCorrectString(msg.msgEnterNameBook()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_DESCRIPTION))
            displayByDescription(Book.getCorrectString(msg.msgEnterDescription()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_YEAR_OF_PUBLICATION))
            displayByYearOfPublication(Book.getCorrectInt(msg.msgEnterYearOfPublication()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_NUMBER_OF_PAGES))
            displayByNumberOfPages(Book.getCorrectInt(msg.msgEnterNumberOfPages()));
        else if(item.equals(ItemsUserSearch.SEARCH_BY_URL))
            displayByUrl("www.".concat(Book.getCorrectString(msg.msgEnterUrl())));
    }

    private void displayByBookType(String search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getBookType().equals(search)) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByAuthor(String search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getAuthor().equals(search)) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByNameBook(String search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getNameBook().equals(search)) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByDescription(String search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getDescription().equals(search)) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByYearOfPublication(int search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getYearOfPublication() == search) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByNumberOfPages(int search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getNumberOfPages() == search) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void displayByUrl(String search){
        boolean notFound = true;                    // имеется ли параметр поиска в БД?
        msg.msgBookInformation();
        for(int i = 0 ; i < getBooksFromDatabase().size(); i++) {
            if (getBooksFromDatabase().get(i).getUrl().equals(search)) {
                notFound = false;
                print(i);
            }
        }
        notFound(notFound);
    }

    private void notFound(boolean notFound){
        if(notFound)
            msg.msgNotFound();
    }

    // постраничный вывод
    private void bookOutput() {
        int step = 10;
        int numberOfNowPage = 1;
        msg.msgBookInformation();
        for(int min = 0; min < getBooksFromDatabase().size(); min++) {
            if(min % 10 == 0 && min != 0) {
                msg.msgShowingPagesNow(numberOfNowPage, getBooksFromDatabase().size() / 10 + 1);
                switch (Actions.getUserSelect(ItemsPageView.values())){
                    case "Back to the menu":
                        return;
                    case "Next page":
                        msg.msgBookInformation();
                        numberOfNowPage++;
                        break;
                    case "Previous page":
                        msg.msgBookInformation();
                        if(min != step) {
                            numberOfNowPage--;
                            min -= step * 2;
                        }
                        else min = 0;
                }
            }
            print(min);
        }
        msg.msgEndOfDatabase();
    }

    // запись книг в ArrayList
    private ArrayList<Book> getBooksFromDatabase() {
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader buffed = new BufferedReader(new FileReader(FULL_PATH_TO_DATABASE))){
            while (buffed.ready()) {
                books.add(new Book(getPrefix(buffed.readLine()),
                        getPrefix(buffed.readLine()),
                        getPrefix(buffed.readLine()),
                        Integer.parseInt(getPrefix(buffed.readLine())),
                        Integer.parseInt(getPrefix(buffed.readLine())),
                        getPrefix(buffed.readLine()),
                        getPrefix(buffed.readLine())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private String getPrefix(String line) {
        String result = null;
        try {
            if(line.matches(PREFIX_BOOK_TYPE + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_AUTHOR + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_NAME_BOOK + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_YEAR_OF_PUBLICATION + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_NUMBER_OF_PAGES + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_DESCRIPTION + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
            else if(line.matches(PREFIX_URL + SEARCH_ANY_CHARACTERS))
                result = getStringAfterColon(line);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    private String getStringAfterColon(String string) {
        return string.replaceAll(SEARCH_BEFORE_COLON, "");
    }

    // добавить книгу в БД
    private void addBookToDatabase(boolean withNotice){
        System.out.println(msg.msgSelectBookType());
        Book book = new Book(Actions.getUserSelect(BookTypes.values()), withNotice);
        writeToDatabase(book.toStringBuilder(), true);
    }

    private void deleteBookFromDatabase() {
        msg.msgTotalBooks(getCountBooks());
        ArrayList<Book> books = getBooksFromDatabase();
        int idForDelete = getIdAcceptableLimits(msg.msgWhichBookToDelete());
        clearFile(FULL_PATH_TO_DATABASE);

        // записываем все, кроме удаляемой книги
        for(int i = 0; i < books.size(); i++)
            if(i != idForDelete)
                writeToDatabase(books.get(i).toStringBuilder(), true);

        msg.msgBookSuccessfullyDeleted(idForDelete + 1);
    }

    // методы выполняет очистку файла без его удаления
    private void clearFile(String path) {
        try (PrintWriter pwOb = new PrintWriter(new FileWriter(path, false), false);) {
            pwOb.flush();
        } catch (FileNotFoundException e) {
            msg.msgFileNotFound();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // получить из консоли id книги в пределах существующих id
    private int getIdAcceptableLimits(String message) {
        int id;
        while (true) {
            System.out.print(message);
            id = new Scanner(System.in).nextInt();
            if(isLimit(id)) return id - 1;
            else MsgWorkWithBook.msgInvalidInput();
        }
    }

    // получить количество книг в БД
    private boolean isLimit(int id) {
        return id > 0 && id <= getCountBooks();
    }

    private int getCountBooks(){
        return getBooksFromDatabase().size();
    }

    /* Запись в базу данных объекта StringBuilder.
     * Аргументы метода:
     * - sb - объект типа StringBuilder;
     * - append - значение типа boolean (true - дозапись в конец файла БД, false - перезапись файла).
     */
    private void writeToDatabase(StringBuilder sb, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FULL_PATH_TO_DATABASE, append))) {
            bw.write(sb.toString());
        } catch (FileNotFoundException e) {
            msg.msgFileNotFound();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeDescription(){
        int id_book;
        String oldDescription;
        EmailSender sender;

        msg.msgTotalBooks(getCountBooks());
        ArrayList<Book> books = getBooksFromDatabase();
        id_book = getIdAcceptableLimits(msg.msgWhichBookToChangeDescription());
        msg.msgInformationAboutBook(books.get(id_book).toStringBuilder());

        oldDescription = books.get(id_book).getDescription();
        books.get(id_book).setDescription();

        msg.msgDescriptionWasChanged(oldDescription, books.get(id_book).getDescription());

        // очищаем файл БД, чтобы записать новые данные
        clearFile(FULL_PATH_TO_DATABASE);

        // записываем все, кроме удаляемой книги
        for(int i = 0; i < books.size(); i++)
            writeToDatabase(books.get(i).toStringBuilder(), true);

        sender = new EmailSender(MenuAuthorization.getAllMailsFromDatabase(PathDatabase.ACCOUNTS.toString()));
        sender.send(msg.msgSubjectDescriptionWasChanged(), books.get(id_book), oldDescription);
    }

    private void print(int id){
        System.out.format("\n%-4s %s", (id + 1) + ".",  getBooksFromDatabase().get(id).toString());
    }
}
