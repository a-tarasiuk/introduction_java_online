package com.company.message;

public class MsgActions {
    // for method getCorrectData();
    public final void msgEnter(){
        System.out.print("Enter: ");
    }

    public final void msgIncorrectData(){
        System.out.println("\n\t(Error) Incorrect data!");
    }

    // for method getChoice();
    public final void msgChooseOneOfTheActions(){
        System.out.println("\n# Choose one of the actions:");
    }

    public final void msgSelectChoice(){
        System.out.print("\nSelect choice: ");
    }

    public final void msgWrongChoice(){
        System.out.println("\n\t(Error) Select the correct item!");
    }

    public final void msgUserNotFound(String login){
        System.out.println("\n\t(Error) User \"" + login + "\" not found! Try again!");
    }

    public final void msgUserAlreadyExist(String name){
        System.out.println("\n\t(Error) A user with the name \"" + name + "\" already exists. Set a different name.");
    }

    public final void msgAuthorizationWasSuccessfully(){
        System.out.println("\n\t(Ok) Authorization was successfully!" );
    }

    public final void msgWrongPassword(){
        System.out.println("\n\t(Error) Wrong password! Try again!");
    }

    public final void msgListOfAllStudents(){
        System.out.println("\n# List of all students:");
    }

    public final void msgWelcome(){
        System.out.println("\n# Welcome to the menu for administrators!");
    }

    public final void msgStudentNamesContaining(String name){
        System.out.println("\n# Found student names containing \"" + name + "\":");
    }
}
