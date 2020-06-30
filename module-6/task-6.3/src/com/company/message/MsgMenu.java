package com.company.message;

public class MsgMenu {
    public final void msgWelcome(){
        System.out.println("Welcome to the application \"Archive\".");
    }

    public final void msgFirstMessage(){
        System.out.println("\nDefault user data you can use when logging in:" +
                "\n\nACCESS LEVEL: USER" +
                "\nLOGIN: user" +
                "\nPASSWORD: user" +
                "\n\nACCESS LEVEL: ADMINISTRATOR" +
                "\nLOGIN: admin" +
                "\nPASSWORD: admin");
    }

    public final void msgGoodByu(){
        System.out.println("\n\t(Exit) Good byu!");
    }
}
