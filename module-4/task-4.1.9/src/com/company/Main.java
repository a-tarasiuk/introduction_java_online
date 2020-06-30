package com.company;

import java.util.*;

class Book{
    {
        id_auto_generate++;
    }
    private static  int     id_auto_generate;
    private         int     id = id_auto_generate;

    private         String  title,                                          //название книги
                            author,                                         //автор(ы)
                            publishingOffice,                               //издательство
                            bindingType;                                    //тип переплета
    private         int     yearOfPublishing,                               //год издательства
                            numberOfPages,                                  //количество страниц
                            price;                                          //цена

    public int getId(){
        return this.id;
    }

    /*
    public String getTitle(){
        return this.title;
    }

    public String getBindingType(){
        return this.bindingType;
    }

    public int getNumberOfPages(){
        return this.numberOfPages;
    }

    public int getPrice() {
        return this.price;
    }
     */

    public String getAuthor(){
        return this.author;
    }

    public String getPublishingOffice(){
        return this.publishingOffice;
    }

    public int getYearOfPublishing(){
        return this.yearOfPublishing;
    }

    public String toString(){
        return String.format("ID: %03d | Название книги: %17s | Автор(ы): %14s | Издательство: %14s | Тип переплета: %17s | Год издательства: %5d | Кол-во страниц: %5d | Цена ($): %5d", id, title, author, publishingOffice, bindingType, yearOfPublishing, numberOfPages, price);
    }

    Book(String title, String author, String publishingOffice, String bindingType, int yearOfPublishing, int numberOfPages, int price) {
        this.title = title;
        this.author = author;
        this.publishingOffice = publishingOffice;
        this.bindingType = bindingType;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
}

class Library{
    private String nameLibrary;
    private ArrayList<Book> libraryList = new ArrayList<>();

    void addBookToLibrary(Book c){
        libraryList.add(c);
    }

    //список авторов
    List<Book> getAllAuthors(){
        return new ArrayList<>(libraryList);
    }

    //список книг заданного автора
    void getBookByAuthor(String author){
        for(Book b : libraryList)
            if(b.getAuthor() == author) System.out.println(b);
    }

    //список книг заданного издательства
    void getBookByPublishingOffice(String publishingOffice){
        for(Book b : libraryList)
            if(b.getPublishingOffice() == publishingOffice) System.out.println(b);
    }

    //список книг, выпущенных после заданного года
    void getBookByYear(int after){
        for(Book b : libraryList)
            if(b.getYearOfPublishing() >= after) System.out.println(b);
    }

    Library(String nameLibrary){
        this.nameLibrary = nameLibrary;
    }

}

public class Main {// write your code here
    //------------------------------------------------------------------------------------------------------------------
    protected static void case1(Library lib){
        for(int i = 0; i < lib.getAllAuthors().size(); i++)
            System.out.println(lib.getAllAuthors().get(i));
    }

    protected static void case2(Library lib, Scanner s){
        int     qt = 0;

        List<Book> getAllAuthor = lib.getAllAuthors();
        System.out.println("Всего книг в библиотеке: " + getAllAuthor.size());
        System.out.println("Список доступных авторов:");

        for(int i = 0; i < getAllAuthor.size(); i++){
            qt = 1;         //кол-во книг автора (по умолчанию значение равно 1, т.к. одна книга автора уже имеется в любом случае)
            for(int j = i+1; j < getAllAuthor.size(); j++){
                //проверяем по порядку, если автор следующей книги равен текущему, то его удаляем из List, но увеличиваем qt, чтобы знать, сколько у его книг
                if(getAllAuthor.get(i).getAuthor().equals(getAllAuthor.get(j).getAuthor())) {
                    qt++;
                    getAllAuthor.remove(j);
                    j--;
                }
            }
            System.out.println("(" + (i) + ") " + getAllAuthor.get(i).getAuthor() + " (кол-во книг данного автора - " + qt + ")");
        }
        System.out.println("\nВведите порядковый номер автора, чьи книги необходимо вывести на экран.");
        int choice = getChoice(getAllAuthor.size(), s);
        lib.getBookByAuthor(getAllAuthor.get(choice).getAuthor());
    }

    protected static void case3(Library lib, Scanner s){
        int qt;

        List<Book> getAllBooks = lib.getAllAuthors();
        System.out.println("Всего книг в библиотеке: " + getAllBooks.size());
        System.out.println("Список издательств:");

        for(int i = 0; i < getAllBooks.size(); i++){
            qt = 1;         //кол-во книг автора (по умолчанию значение равно 1, т.к. одна книга автора уже имеется в любом случае)
            for(int j = i+1; j < getAllBooks.size(); j++){
                //проверяем по порядку, если издательство следующей книги равно текущему, то его удаляем из List, но увеличиваем qt, чтобы знать, сколько книг издательтва
                if(getAllBooks.get(i).getPublishingOffice().equals(getAllBooks.get(j).getPublishingOffice())) {
                    qt++;
                    getAllBooks.remove(j);
                    j--;
                }
            }
            System.out.println("(" + (i) + ") " + getAllBooks.get(i).getPublishingOffice() + " (кол-во книг данного издательства - " + qt + ")");
        }

        System.out.println("\nВведите порядковый номер издательства, чьи книги необходимо вывести на экран.");
        int choice = getChoice(getAllBooks.size(), s);
        lib.getBookByPublishingOffice(getAllBooks.get(choice).getPublishingOffice());
    }

    protected static void case4(Library lib, Scanner s){
        int qt = 0;
        List<Book> getAllBooks = lib.getAllAuthors();

        System.out.println("Доступные годы издательства:");

        for(int i = 0; i < getAllBooks.size(); i++){
            qt = 1;
            for(int j = i+1; j < getAllBooks.size(); j++){
                if(getAllBooks.get(i).getYearOfPublishing() == getAllBooks.get(j).getYearOfPublishing()) {
                    qt++;
                    getAllBooks.remove(j);
                    j--;
                }
            }
            System.out.println("(" + (i) + ") " + getAllBooks.get(i).getYearOfPublishing() + " (кол-во книг данного года издательства - " + qt + ")");
        }

        System.out.println("\nВведите порядковый номер года, чтобы вывести список книг, изданных после заданного года.");

        int choice = getChoice(getAllBooks.size(), s);
        lib.getBookByYear(getAllBooks.get(choice).getYearOfPublishing());
    }
    //------------------------------------------------------------------------------------------------------------------
    //maxValue - максимальное значение
    public static int getChoice(int maxValue, Scanner s){ //проверка диапазона ввода
        boolean flag = true;
        int     key = 0;
        while (flag){
            getMessageChoice();
            key = s.nextInt();
            if(flag = key < 0 || key > maxValue - 1 ? true : false) getMessageWrongChoice();
        }
        return key;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void getMessageWelcome(){
        System.out.println("Найти и вывести:" +
                "\n1. Весь список" +
                "\n2. Список книг заданного автора" +
                "\n3. Список книг, выпущенных заданным издательством" +
                "\n4. Список книг, выпущенных после заданного года (включительно)");
    }

    public static void getMessageChoice(){
        System.out.print("Выбор: ");
    }

    public static void getMessageWrongChoice(){
        System.out.println("Неверный ввод. Повторите выбор!");
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int     key = 0;
        boolean flag = true;
        //создаем библиотеку
        Library lib = new Library("Gold Library");

        //добавляем книги
        lib.addBookToLibrary(new Book("Первая книга", "Петров В.В.", "Медиа-Групп", "Интегральный", 2019, 400, 300));
        lib.addBookToLibrary(new Book("Вторая книга", "Иванов В.В.", "Цельсий", "7Б", 2018, 400, 299));
        lib.addBookToLibrary(new Book("Третья книга", "Сидоров В.В.", "Консул", "Французский", 2017, 700, 499));
        lib.addBookToLibrary(new Book("Четвертая книга", "Громов В.В.", "Бизон", "Навивка на болты", 2020, 122, 78));
        lib.addBookToLibrary(new Book("Пятая книга", "Петров В.В.", "Бизон", "Навивка на болты", 2020, 122, 78));
        lib.addBookToLibrary(new Book("Шестая книга", "Митин В.В.", "Бизон", "Навивка на болты", 2020, 122, 78));
        lib.addBookToLibrary(new Book("Седьмая книга", "Петров В.В.", "Юрида", "Навивка на болты", 2020, 877, 32));

        //ввод с клавиатуры пользователем
        getMessageWelcome();
        Scanner s = new Scanner(System.in);

        //проверка диапазона ввода
        switch (getChoice(4 + 1, s)){
            case 1 : case1(lib); break;
            case 2 : case2(lib, s); break;
            case 3 : case3(lib, s); break;
            case 4 : case4(lib, s); break;
        }
    }
}
