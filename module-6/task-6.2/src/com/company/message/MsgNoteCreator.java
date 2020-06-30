package com.company.message;

public class MsgNoteCreator {
    // Creator notes
    protected static void msgEnterDate(){
        System.out.print("\nPlease, enter date: ");
    }

    protected static void msgEnterTheme(){
        System.out.print("\nPlease, enter a theme: ");
    }

    protected static void msgEnterMail(){
        System.out.print("\nPlease, enter a mail (example@host.com): ");
    }

    protected static void msgEnterMessage(){
        System.out.print("\nPlease, enter a message: ");
    }

    protected static void msgEnterKeyword(){
        System.out.print("\nPlease, enter a keyword: ");
    }

    // Errors
    protected static void msgIncorrectInput(){
        System.out.println("\n\t[ERROR]\n\tIncorrect input!");
    }

    protected static void msgNonexistentDate(){
        System.out.println("\n\t[ERROR]\n\tNonexistent date!");
    }

    protected static void msgNotFound(){
        System.out.println("\n\t[ERROR]\n\tNot found!");
    }

    // Information
    protected static void msgNotesNotFound(){
        System.out.println("\n\t[INFORMATION]\n\tNotes nof found!");
    }

    protected static void msgDateExample(){
        System.out.println("\n\t[INFORMATION]\n\tDate format: dd.mm.yyyy");
    }

    protected static void msgTotalNotes(int size){
        System.out.println("\n\t[INFORMATION]\n\tTotal notes: " + size);
    }

    protected static void msgMailShouldLookLike(){
        System.out.println("\n\t[INFORMATION]\n\tMail should look like: example@domain.com");
    }

    protected static void msgThemeMayContain(){
        System.out.println("\n\t[INFORMATION]\n\tTheme may contain only english (WITHOUT russian!) letters, numbers and a space character!");
    }

    protected static void msgMessageMayContain(){
        System.out.println("\n\t[INFORMATION]\n\tMessage may contain any characters!");
    }

    // Ok
    protected static void msgEnteredDataIsCorrect(){
        System.out.println("\n\t[OK]\n\tEntered data is correct!");
    }

    protected static void msgNoteSuccessfullyCreated(String note){
        System.out.println("\n\t[OK]\n\tNote successfully created! About this note:\n" + note);
    }
}
