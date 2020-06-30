package com.company.menu;

import com.company.action.Actions;
import com.company.data.ItemsMenuUser;

public class MenuUser extends Actions {
    public MenuUser(){
    }

    public void start() {
        while (true) {
            switch (getChoice(ItemsMenuUser.values())) {
                case "Back":
                    return;
                case "View students [...]":
                    menuViewStudents();
                    break;
            }
        }
    }
}
