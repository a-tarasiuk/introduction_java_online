package com.company.message;

public class MsgMenu {
    protected static void msgWelcome(){
        System.out.println("\nWelcome to the app \"Note\"!");
    }

    protected static void msgChooseOneOfTheActions(){
        System.out.println("\nChoose one of the actions:");
    }

    protected static void msgSelectChoice(){
        System.out.print("\nSelect choice: ");
    }

    protected static void msgExitFromProgram(){
        System.out.println("\n\t... Exit from program!");
    }

    // Errors
    protected static void msgErrorWrongChoice(){
        System.out.println("\n\t[ERROR]\n\tWrong choice!");
    }
}
