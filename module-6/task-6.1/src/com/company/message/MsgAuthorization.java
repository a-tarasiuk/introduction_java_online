package com.company.message;

public class MsgAuthorization {
    public final String msgWelcome(){
        return "Welcome to the home library bookkeeping program!";
    }

    public final String msgExitFromProgram(){
        return "\n\t... (INFO) Exit from program.";
    }

    public final String msgAuthorizationWasSuccessful(){
        return "\n\t...(OK) MenuAuthorization was successful!";
    }

    public final String msgRegistrationWasSuccessful(){
        return "\n\t...(OK) Registration was successful!";
    }

    public final String msgIncorrectPassword(){
        return "\n\t...(ERROR) Incorrect password! Try again! :(";
    }

    public final String msgLoginNotFound(){
        return "\n\t...(ERROR) Login not found! :(";
    }

    public final void msgEnterYourUserData(String userData){
        System.out.print("\nPlease, enter your " + userData + ": ");
    }

    public final void msgChooseAccessLevel(){
        System.out.print("\nPlease, choose access level for new User:");
    }

    public final void msgIncorrectLoginPassword(){
        System.out.println("\n\t...(ERROR) Login or/and password is incorrect!");
    }

    public final void msgIncorrectEmail(){
        System.out.println("\n\t...(ERROR) Email is incorrect! Email must be of the form \"email@email.com\" :(");
    }

    public final void msgLoginContainSpecialCharacters(){
        System.out.println("\n\t...(ERROR) Login must not contain special characters and space character!");
    }

    public final void msgPasswordContainSpaceCharacters(){
        System.out.println("\n\t...(ERROR) Password must not contain space character!");
    }

    public final void msgUserAlreadyExist(String login){
        System.out.println("\n\t...(ERROR) User \"" + login + "\" already exist!");
    }

}
