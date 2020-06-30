package com.company.message;

public class MsgBase {
    protected static String msgChooseOneOfTheActions(){
        return "\nChoose one of the actions:";
    }

    protected static String msgSelectChoice(){
        return "\nSelect choice: ";
    }

    protected static String msgWrongChoice(){
        return "\n\t...(ERROR) Select the correct item!";
    }

    protected static String msgNowSelectMenuItem(String string){
        return "\n\t...(INFO) Now Select MenuCreator Item - " + string + ".";
    }
}
