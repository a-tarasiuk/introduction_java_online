package com.company.menu;

import com.company.encryption.Encryption;
import com.company.data.*;
import com.company.variable.Prefixes;
import com.company.variable.VariablesUsers;
import com.company.variable.PatternsCorrect;
import com.company.variable.PatternsSearch;
import com.company.message.MsgAuthorization;
import com.company.user.User;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAuthorization extends Path implements VariablesUsers, PatternsSearch, PatternsCorrect, Prefixes {
    private String TRUE_LOGIN;
    private String TRUE_EMAIL;
    private String TRUE_ACCESS_LEVEL;
    private final ArrayList<String> USER_COOKIES;
    private final MsgAuthorization msg;

    MenuAuthorization() {
        super(PathDatabase.ACCOUNTS);
        USER_COOKIES = new ArrayList<>();
        msg = new MsgAuthorization();
    }

    protected ArrayList<String> getCookies() throws IOException, NoSuchAlgorithmException {
        System.out.println(msg.msgWelcome());
        while (true){
            switch (Actions.getUserSelect(ItemsAuthorization.values())){
                case "Exit":
                    System.out.println(msg.msgExitFromProgram());
                    return null;
                case "Authorization":
                    menuItemAuthorization();
                    return USER_COOKIES;
                case "Registration (for new users)":
                    menuItemRegistration();
                    break;
            }
        }
    }

    /***********************************************[Пункты меню]******************************************************/

    // menu item - authorization
    private void menuItemAuthorization() throws IOException, NoSuchAlgorithmException {
        getAuthorization();
    }

    // menu item - registration
    private void menuItemRegistration() throws IOException, NoSuchAlgorithmException {
        addNewUserInDatabase();
    }

    /******************************************[Пункт меню - Авторизация]**********************************************/

    // получить из консоли корректно введенный логин
    private void getAuthorization() throws IOException, NoSuchAlgorithmException {
        String login;
        while (true){
            msg.msgEnterYourUserData(UserData.LOGIN.toString());
            login = new Scanner(System.in).nextLine();
            if(isCorrectLogin(login) && isContainedUserInDatabase(login)) {
                USER_COOKIES.add(TRUE_LOGIN);
                USER_COOKIES.add(TRUE_EMAIL);
                USER_COOKIES.add(TRUE_ACCESS_LEVEL);
                System.out.println(msg.msgAuthorizationWasSuccessful());
                break;
            }
        }
    }

    /**********************************[Пункт меню - Регистрация нового пользователя]**********************************/

    // записать нового пользователя в базу данных
    private void addNewUserInDatabase() throws IOException, NoSuchAlgorithmException {
        FileWriter fw = new FileWriter(FULL_PATH_TO_DATABASE, true);
        fw.write(createNewUser().toString());
        fw.close();
        System.out.println(msg.msgRegistrationWasSuccessful());
    }

    /***********************************************[Действия]*********************************************************/
    // создать нового пользователя
    private User createNewUser() throws NoSuchAlgorithmException, IOException {
        return new User(createNewLogin(), createNewPassword(), createNewEmail(), createNewAccessLevel());
    }

    // создаем новый логин
    private String createNewLogin() throws IOException {
        String login;
        while (true){
            msg.msgEnterYourUserData(UserData.LOGIN.toString());
            login = new Scanner(System.in).nextLine();
            if(isCorrectLogin(login) && !isContainedLoginInDatabase(login))
                return login;
        }
    }

    // создаем новый пароль
    private String createNewPassword() throws NoSuchAlgorithmException {
        String password;
        while (true){
            msg.msgEnterYourUserData(UserData.PASSWORD.toString());
            password = new Scanner(System.in).nextLine();
            if(isCorrectPassword(password))
                return Encryption.encrypt(password);
            else msg.msgIncorrectLoginPassword();
        }
    }

    // создаем корректную почту
    private String createNewEmail(){
        String email;
        while (true){
            msg.msgEnterYourUserData(UserData.EMAIL.toString());
            email = new Scanner(System.in).nextLine();
            if(email.matches(CORRECT_EMAIL_PATTERN))
                return email;
            else msg.msgIncorrectEmail();
        }
    }

    // задаем уровень доступа пользователя (пользователь, администратор)
    private String createNewAccessLevel(){
        msg.msgChooseAccessLevel();
        return Actions.getUserSelect(AccessLevels.values());
    }

    /*****************************************[Проверка данных на валидность]******************************************/

    // проверка логина на специальные символы
    private boolean isCorrectLogin(String login){
        boolean isCorrect = login.matches(CORRECT_LOGIN_PATTERN);
        if(!isCorrect) msg.msgLoginContainSpecialCharacters();
        return isCorrect;
    }

    // проверка пароль на валидность
    private boolean isCorrectPassword(String string){
        boolean isCorrect = string.matches(CORRECT_PASSWORD_PATTERN);
        if(!isCorrect) msg.msgPasswordContainSpaceCharacters();
        return isCorrect;
    }

    /* Метод - проверка пользователя (логин и пароль) на наличие в базе данных.
     * Аргументы:
     * - login - искомый логин;
     */
    private boolean isContainedUserInDatabase(String login) throws IOException, NoSuchAlgorithmException {
        // делаем построчное считывание из файла
        FileReader fr = new FileReader(FULL_PATH_TO_DATABASE);
        BufferedReader br = new BufferedReader(fr);

        // считываем первую строку строку
        TRUE_LOGIN = br.readLine();

        // null будет если файл пустой либо достигнут конец файла
        while (TRUE_LOGIN != null){
            if(TRUE_LOGIN.matches(SEARCH_LOGIN_PATTERN + login)){
                String TRUE_PASSWORD = br.readLine();
                if(TRUE_PASSWORD.matches(SEARCH_PASSWORD_PATTERN + Encryption.encrypt(getPasswordFromConsole()))) {
                    TRUE_EMAIL = br.readLine();
                    TRUE_ACCESS_LEVEL = br.readLine();
                    return true;
                }
                else {
                    System.out.println(msg.msgIncorrectPassword());
                    return false;
                }
            }
            TRUE_LOGIN = br.readLine();
        }
        System.out.println(msg.msgLoginNotFound());
        return false;
    }

    // get password
    private String getPasswordFromConsole(){
        String password;
        while (true){
            msg.msgEnterYourUserData(UserData.PASSWORD.toString());
            password = new Scanner(System.in).nextLine();
            // если пароль корректный
            if(isCorrectPassword(password)) return password;
        }
    }

    // проверка, правильный ли пароль от логина
    private boolean isContainedLoginInDatabase(String login) throws IOException {
        String line;

        // делаем построчное считывание из файла
        FileReader fr = new FileReader(FULL_PATH_TO_DATABASE);
        BufferedReader br = new BufferedReader(fr);

        // считываем первую строку строку
        line = br.readLine();

        while (line != null){
            if(isContainedLoginInLine(line, login)) {
                msg.msgUserAlreadyExist(login);
                return true;
            }
            // считываем далее каждую строку строку
            line = br.readLine();
        }
        return false;
    }

    /* Метод - проверка, содержится ли логин в строке.
     * Используются регулярные выражения.
     * Метод matches() возвращает true или false, если слово совпало с регулярным выражением.
     * Разберем регулярное выражение:
     * ^ - начало строки;
     * login - искомый логин;
     * : - конкретный символ двоеточия (должен предваряться двойными наклонными черточками)
     * . - любой символ
     * * - ноль или более раз (значит, что любой символ, который следует после двоеточия, может повторяться 0 или более раз)
     */
    private boolean isContainedLoginInLine(String line, String login){
        return line.matches(SEARCH_LOGIN_PATTERN + login);
    }

    public static ArrayList<String> getAllMailsFromDatabase(String fullPathToDatabase){
        String line;
        ArrayList<String> mails = new ArrayList<>();

        try (BufferedReader buffed = new BufferedReader(new FileReader(fullPathToDatabase))){
            while (buffed.ready()) {
                line = buffed.readLine();
                if(line.matches(SEARCH_EMAIL_PATTERN + SEARCH_ANY_CHARACTERS))
                    mails.add(getStringAfterColon(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mails;
    }

    private static String getStringAfterColon(String string) {
        return string.replaceAll(SEARCH_BEFORE_COLON, "");
    }
}
