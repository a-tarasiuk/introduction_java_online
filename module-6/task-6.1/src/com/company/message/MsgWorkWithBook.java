package com.company.message;

public class MsgWorkWithBook {

    public String msgFormat(){
        return "%-30s %-30s %-30s %-20s %-20s %-40s %-40s";
    }

    public String msgEnterAuthor(){
        return "\nPlease, enter name of the author: ";
    }

    public String msgEnterNameBook(){
        return "\nPlease, enter name of the book: ";
    }

    public String msgEnterNumberOfPages(){
        return "\nPlease, enter number of pages: ";
    }

    public String msgEnterYearOfPublication(){
        return "\nPlease, enter year of publication: ";
    }

    public String msgEnterDescription(){
        return "\nPlease, enter a description: ";
    }

    public String msgSelectBookType(){
        return "\nPlease, select book type";
    }

    public String msgEnterUrl(){
        return "\nPlease, enter URL: www.";
    }

    public void msgBookWasCreated(){
        System.out.println("\n\t... (OK) Book was created successful!");
    }

    public void msgBookInformation(){
        System.out.format("%-5s" + msgFormat(),
                "ID", "Book type:", "Author:", "Name of the book:", "Year of publication:", "Number of pages:", "Description:", "URL:");
    }

    public static void msgInvalidInput(){
        System.out.println("\n\t... (ERROR) Invalid input. Try again!");
    }

    public void msgNotFound(){
        System.out.println("\n\t... (ERROR) Not Found!");
    }

    public void msgShowingPagesNow(int nowPage, int numberOfAllPages){
        System.out.println("\nShowing " + nowPage + " out of " + numberOfAllPages + " pages now.");
    }

    public void msgTotalBooks(int totalBooks){
        System.out.println("\nTotal books: " + totalBooks);
    }

    public String msgWhichBookToDelete(){
        return "\nPlease, enter the number of the book you want to delete: ";
    }

    public String msgWhichBookToChangeDescription(){
        return "\nPlease, enter the number of the book you want to change description: ";
    }

    public void msgFileNotFound(){
        System.out.println("\n\t... (ERROR) File Not Found!");
    }

    public void msgEndOfDatabase(){
        System.out.println("\n\n\t...(INFO) End of database!");
    }


    public void msgInformationAboutBook(StringBuilder sb) {
        System.out.println("\n\t... (INFO) Information about this book:\n" + sb);
    }

    public void msgBookSuccessfullyDeleted(int id){
        System.out.println("\n\t... (OK) Book with id: " + id + " successfully deleted!");
    }

    public void msgDescriptionWasChanged(String oldDescription, String newDescription) {
        System.out.println("\n... (INFO) Description successfully changed!" +
                "\n- Old Description: " + oldDescription +
                "\n- New Description: " + newDescription);
    }

    public String msgSubjectDescriptionWasChanged(){
        return "THEME: Description was changed. Look at this!";
    }
}
