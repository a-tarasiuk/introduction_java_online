package com.company.menu;

import com.company.action.Actions;
import com.company.data.ItemsMenu;
import com.company.data.Path;
import com.company.data.Patterns;
import com.company.message.MsgMenu;
import com.company.user.User;
import com.company.xml.XMLCreator;

public class Menu extends Actions {
    private final MsgMenu msg = new MsgMenu();

    public Menu(){
        msg.msgWelcome();
        msg.msgFirstMessage();
    }

    public void run(){
        while (true){
            switch (getChoice(ItemsMenu.values())){
                case "Exit":
                    msg.msgGoodByu();
                    return;
                case "Authorization":
                    authorization();
                    break;
                case "Registration (for new users)":
                    registration();
                    break;
            }
        }
    }

    protected void authorization() {
        User user = getUserDataByLogin();

        // сверяем введенный пароль с паролем, который соответствует логину
        if(getCorrectData(Patterns.PASSWORD).equals(user.getPassword())) {
            msgAuthorizationWasSuccessfully();
            startMenuType(user);
        }
        else
            msgWrongPassword();
    }

    protected void registration(){
        String accessLevel;
        String login;
        String password;

        XMLCreator xmlCreator = new XMLCreator(Path.ACCOUNTS);
        xmlCreator.createDocument();

        accessLevel = getAccessLevel();

        while (xmlCreator.isFoundExactSearch(login = getCorrectData(Patterns.LOGIN)))
            msgUserAlreadyExist(login);

        password = getCorrectData(Patterns.PASSWORD);

        xmlCreator.addChildrenElements(new User().setAccessLevel(accessLevel).setLogin(login).setPassword(password).createChildrenElements());
        xmlCreator.writeInXML();
    }
}