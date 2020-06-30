package com.company.action;

import com.company.data.AccessLevels;
import com.company.data.ItemsView;
import com.company.data.Path;
import com.company.data.Patterns;
import com.company.menu.MenuAdministrator;
import com.company.menu.MenuUser;
import org.jdom2.Element;
import com.company.student.Student;
import com.company.user.User;
import com.company.xml.XMLCreator;
import java.util.List;

public class Actions extends CorrectData {

    public void menuViewStudents(){
        while (true){
            switch (getChoice(ItemsView.values())){
                case "Back":
                    return;
                case "View all students":
                    viewAllStudents();
                    break;
                case "View student by name":
                    viewByName();
                    break;
                case "View student by surname":
                    viewBySurname();
                    break;
                case "View student by age":
                    viewByAge();
                    break;
                case "View student by faculty":
                    viewByFaculty();
                    break;
            }
        }
    }

    protected String getAccessLevel(){
        while (true){
            Patterns.ACCESS_LEVEL.getMsg();
            switch (getChoice(AccessLevels.values())){
                case "Administrator":
                    return AccessLevels.ADMINISTRATOR.toString();
                case "User":
                    return AccessLevels.USER.toString();
            }
        }
    }

    protected void startMenuType(User user){
        if(user.getAccessLevel().equalsIgnoreCase(AccessLevels.ADMINISTRATOR.toString())){
            MenuAdministrator menuAdministrator = new MenuAdministrator();
            menuAdministrator.start();
        }
        else{
            MenuUser menuUser = new MenuUser();
            menuUser.start();
        }
    }

    // возвращаем данные (логин, пароль, уровень доступа) объекта User по введенному логину
    protected User getUserDataByLogin(){
        String login;
        String realPassword;
        String accessLevel;

        XMLCreator xmlCreator = new XMLCreator(Path.ACCOUNTS);
        xmlCreator.createDocument();

        // ищем логин в БД
        while (!xmlCreator.isFoundExactSearch(login = getCorrectData(Patterns.LOGIN)))
            msgUserNotFound(login);

        realPassword = xmlCreator.getValueByNameElement(Patterns.PASSWORD);
        accessLevel = xmlCreator.getValueByNameElement(Patterns.ACCESS_LEVEL);

        return new User().setLogin(login).setPassword(realPassword).setAccessLevel(accessLevel);
    }

    protected void menuAddNewStudent() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();

        String name = getCorrectData(Patterns.NAME);
        String surname = getCorrectData(Patterns.SURNAME);
        String age = getCorrectData(Patterns.AGE);
        String faculty = getCorrectData(Patterns.FACULTY);
        String course = getCorrectData(Patterns.COURSE);

        xmlCreator.addChildrenElements(new Student().setName(name).setSurname(surname).setAge(age).setFaculty(faculty).setCourse(course).createChildrenElements());
        xmlCreator.writeInXML();
    }

    protected void viewByName() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();
        Patterns type = Patterns.NAME;
        String name = getCorrectData(type);
        printElements(xmlCreator.getSearchElements(xmlCreator.getMainElements(), type, name));
    }

    protected void viewBySurname() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();
        Patterns type = Patterns.SURNAME;
        String surname = getCorrectData(type);
        printElements(xmlCreator.getSearchElements(xmlCreator.getMainElements(), type, surname));
    }

    protected void viewByAge() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();
        Patterns type = Patterns.AGE;
        String age = getCorrectData(type);
        printElements(xmlCreator.getSearchElements(xmlCreator.getMainElements(), type, age));
    }

    protected void viewByFaculty() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();
        Patterns type = Patterns.FACULTY;
        String faculty = getCorrectData(type);
        printElements(xmlCreator.getSearchElements(xmlCreator.getMainElements(), type, faculty));
    }

    protected void viewAllStudents() {
        XMLCreator xmlCreator = new XMLCreator(Path.STUDENTS);
        xmlCreator.createDocument();
        msgListOfAllStudents();
        printElements(xmlCreator.getMainElements());
    }

    protected void printElements(List<Element> elements) {
        int count = 0;
        System.out.println("\n# Found elements: " + elements.size());

        for (Element e1 : elements) {
            List<Element> children = e1.getChildren();
            System.out.println("\n№ " + (++count));
            for (Element e2 : children)
                System.out.format("%-10s: %-40s\n", e2.getName(), e2.getValue());
        }
    }
}
