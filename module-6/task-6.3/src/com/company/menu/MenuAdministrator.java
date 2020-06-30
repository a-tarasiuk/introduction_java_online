package com.company.menu;

import com.company.action.Actions;
import com.company.data.*;

public class MenuAdministrator extends Actions {

    public MenuAdministrator(){
        msgWelcome();
    }

    public void start(){
        while (true){
            switch (getChoice(ItemsMenuAdministrator.values())){
                case "Back":
                    return;
                case "View students [...]":
                    menuViewStudents();
                    break;
                case "Edit the student":
                    menuEditStudent();
                    break;
                case "Add new student":
                    menuAddNewStudent();
                    break;
            }
        }
    }

    private void menuEditStudent() {
        MenuEditStudents mes = new MenuEditStudents();
        mes.start();
    }
}
