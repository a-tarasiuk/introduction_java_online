package com.company.menu;

import com.company.data.Variables;
import com.company.item.ItemsMenuMain;
import com.company.item.ItemsMenuSearch;
import com.company.item.ItemsMenuSort;
import com.company.message.MsgMenu;
import com.company.note.NoteCreator;

import java.util.Scanner;

public class Menu extends MsgMenu {
    private NoteCreator noteCreator;

    public Menu() {
        noteCreator = new NoteCreator();
    }

    public void show(){
        msgWelcome();

        while (true){
            switch (getSelect(ItemsMenuMain.values())){
                case "Exit":
                    noteCreator.writeToFile();
                    msgExitFromProgram();
                    return;
                case "View all notes":
                    noteCreator.showAll();
                    break;
                case "Add new note":
                    noteCreator.addNewNote();
                    break;
                case "Search by...":
                    menuSearch();
                    break;
                case "Sort by...":
                    menuSort();
                    break;
            }
        }
    }

    private void menuSearch(){
        while (true){
            switch (getSelect(ItemsMenuSearch.values())){
                case "Back":
                    return;
                case "Search by date":
                    noteCreator.menuSearchBy(ItemsMenuSearch.BY_DATE);
                    break;
                case "Search by theme":
                    noteCreator.menuSearchBy(ItemsMenuSearch.BY_THEME);
                    break;
                case "Search by mail":
                    noteCreator.menuSearchBy(ItemsMenuSearch.BY_MAIL);
                    break;
                case "Search by message":
                    noteCreator.menuSearchBy(ItemsMenuSearch.BY_MESSAGE);
                    break;
                case "Search by keyword":
                    noteCreator.menuSearchBy(ItemsMenuSearch.BY_KEYWORD);
                    break;
            }
        }
    }

    private void menuSort(){
        while (true){
            switch (getSelect(ItemsMenuSort.values())){
                case "Back":
                    return;
                case "Sort by date":
                    noteCreator.menuSortBy(ItemsMenuSort.BY_DATE);
                    break;
                case "Sort by theme":
                    noteCreator.menuSortBy(ItemsMenuSort.BY_THEME);
                    break;
                case "Sort by mail":
                    noteCreator.menuSortBy(ItemsMenuSort.BY_MAIL);
                    break;
                case "Sort by message":
                    noteCreator.menuSortBy(ItemsMenuSort.BY_MESSAGE);
                    break;
                case "Sort by date & theme":
                    noteCreator.menuSortBy(ItemsMenuSort.BY_DATE_AND_THEME);
                    break;
                default:
                    msgErrorWrongChoice();
            }
        }
    }

    private <T extends Variables> String getSelect(Variables[] value){
        int choiceUser;

        // проверка на верный диапазон
        while (true){
            // сначала выводим сообщение в консоль
            msgChooseOneOfTheActions();
            // вывод на экран пунктов меню
            for(int i = 0; i < value.length; i++)
                System.out.println(i + ". " + value[i].getItem());
            // вывод предложения о вводе
            msgSelectChoice();
            // выбор пользователя
            choiceUser = new Scanner(System.in).nextInt();
            if(choiceUser >= 0 && choiceUser < value.length)
                break;
            else
                msgErrorWrongChoice();
        }
        return value[choiceUser].getItem();
    }
}
