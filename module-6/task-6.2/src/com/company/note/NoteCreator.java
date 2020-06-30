package com.company.note;

import com.company.data.Path;
import com.company.data.Patterns;
import com.company.item.ItemsMenuSearch;
import com.company.item.ItemsMenuSort;
import com.company.message.MsgNoteCreator;
import com.company.sort.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class NoteCreator extends MsgNoteCreator implements Patterns, Path {
    private int LAST_POSITION;
    private ArrayList<Note> notes;

    public NoteCreator(){
        notes = new ArrayList<>();
        readFromFile();
    }

    // код считывания записей из текстового файла и загрузки в notes
    private void readFromFile(){
        String date = "";
        String theme = "";
        String mail = "";
        String message = "";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            while ((line = br.readLine()) != null){
                if(line.matches(PATTERN_NOTE))
                    continue;
                else if (line.matches(PATTERN_DATE + SEARCH_ANY_CHARACTERS)) {
                    date = deleteCharactersBeforeColon(line);
                    continue;
                } else if (line.matches(PATTERN_THEME + SEARCH_ANY_CHARACTERS)) {
                    theme = deleteCharactersBeforeColon(line);
                    continue;
                } else if (line.matches(PATTERN_MAIL + SEARCH_ANY_CHARACTERS)) {
                    mail = deleteCharactersBeforeColon(line);
                    continue;
                } else if (line.matches(PATTERN_MESSAGE + SEARCH_ANY_CHARACTERS)) {
                    message = deleteCharactersBeforeColon(line);
                    notes.add(getNewNote(date, theme, mail, message));
                    continue;
                }
            }
            LAST_POSITION = notes.size();   // записываем последнюю позицию, чтобы начать с её запись в файл
            msgTotalNotes(notes.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String deleteCharactersBeforeColon(String value){
        return value.replaceAll(SEARCH_BEFORE_COLON, "");
    }

    /**
     * Записать все записи из notes в файл.
     * можно было реализовать сначала очистку файла БД после считывания из БД информации, но я выбрал способ
     * записи последней позиции считывания, чтобы не тратить ресурсы на очистку файла БД.
     */
    public void writeToFile(){
        if(notes.size() != 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
                for(int i = LAST_POSITION; i < notes.size(); i++)
                    writer.write(notes.get(i).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showAll(){
        if(notes == null) {
            msgNotesNotFound();
            return;
        }
        for(Note note : notes)
            System.out.println(note.toString());
    }

    public void addNewNote(){
        Note note = getNewNote(null, createTheme(), createMail(), createMessage());
        msgNoteSuccessfullyCreated(note.toString());
        notes.add(note);
    }

    private Note getNewNote(String date, String theme, String mail, String message) {
        return new Note.Builder(date).theme(theme).mail(mail).message(message).build();
    }

    private String createTheme(){
        String theme;
        while (true) {
            msgThemeMayContain();
            msgEnterTheme();
            theme = new Scanner(System.in).nextLine();
            if(Pattern.matches(CORRECT_PATTERN_THEME, theme)) {
                msgEnteredDataIsCorrect();
                return theme;
            }
            else
                msgIncorrectInput();
        }
    }

    private String createMail(){
        String mail;
        while (true) {
            msgMailShouldLookLike();
            msgEnterMail();
            mail = new Scanner(System.in).nextLine();
            if(Pattern.matches(CORRECT_PATTERN_MAIL, mail)) {
                msgEnteredDataIsCorrect();
                return mail;
            }
            else
                msgIncorrectInput();
        }
    }

    private String createMessage(){
        String message;
        msgMessageMayContain();
        msgEnterMessage();
        message = new Scanner(System.in).nextLine();
        msgEnteredDataIsCorrect();
        return message;
    }

    private String createKeyword(){
        msgEnterKeyword();
        return new Scanner(System.in).nextLine();
    }

    public void menuSearchBy(ItemsMenuSearch item) {
        boolean wasFound = false;
        String value;
        if(item.equals(ItemsMenuSearch.BY_DATE)){
            byDate();
        }
        else if(item.equals(ItemsMenuSearch.BY_THEME)){
            value = createTheme();
            for(Note note : notes)
                if(searchPattern(value).matcher(note.getTheme()).find()){
                    wasFound = true;
                    System.out.println(note.toString());
                }
        }
        else if(item.equals(ItemsMenuSearch.BY_MAIL)){
            value = createMail();
            for(Note note : notes)
                if(searchPattern(value).matcher(note.getMail()).find()){
                    wasFound = true;
                    System.out.println(note.toString());
                }
        }
        else if(item.equals(ItemsMenuSearch.BY_MESSAGE)){
            value = createMessage();
            for(Note note : notes)
                if(searchPattern(value).matcher(note.getMessage()).find()){
                    wasFound = true;
                    System.out.println(note.toString());
                }
        }
        else if(item.equals(ItemsMenuSearch.BY_KEYWORD)){
            value = createKeyword();
            for(Note note : notes)
                if(searchPattern(value).matcher(note.toString()).find()) {
                    wasFound = true;
                    System.out.println(note.toString());
                }
        }

        wasFound(wasFound);
    }

    private Pattern searchPattern(String value){
        String regEx = "([.\\s\\S]*)";
        //поиск совпадений с шаблоном будет производиться без учета регистра символов.
        return Pattern.compile(regEx + "(" + value + ")" + regEx, Pattern.CASE_INSENSITIVE);
    }

    private void byDate(){
        boolean wasFound = false;

        for(Note note : notes)
            if(note.getDate().equals(getCorrectDate())) {
                wasFound = true;
                System.out.println(note.toString());
            }

        wasFound(wasFound);
    }

    private Date getCorrectDate() {
        ArrayList<String> currentDate = new ArrayList<>();
        String date;
        String day;
        String month;
        String year;

        while (true){
            msgDateExample();
            msgEnterDate();

            date = new Scanner(System.in).nextLine();

            currentDate.addAll(Arrays.asList(date.split("\\.")));

            // разбираем дату на день, месяц и год
            day = currentDate.get(0);
            month = currentDate.get(1);
            year = currentDate.get(2);

            // проверям, чтобы дата была в пределах (дней не больше чем в веденном месяце и т.п.)
            if(date.matches(CORRECT_PATTERN_DATE) && isCorrectDate(day, month, year)) {
                try {
                    return new SimpleDateFormat("dd.MM.yyyy").parse(date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }

            else
                msgIncorrectInput();
        }
    }

    private boolean isCorrectDate(String inputDay, String inputMonth, String inputYear){
        int day = 0;
        int month = 0;
        int year = 0;

        // преобразуем String to int
        try {
            day = Integer.parseInt(inputDay);
            month = Integer.parseInt(inputMonth);
            year = Integer.parseInt(inputYear);
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }

        if(month > 12) {
            msgNonexistentDate();
            return false;
        }
        else {
            Calendar myCalendar = (Calendar) Calendar.getInstance().clone();
            // устанавливаем месяц и год, чтобы узнать, сколько дней в данном месяце
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            return day < myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
    }

    private void wasFound(boolean wasFound){
        if(!wasFound)
            msgNotFound();
    }

    public void menuSortBy(ItemsMenuSort item){
        if(item.equals(ItemsMenuSort.BY_DATE)){
            Collections.sort(notes, new SortDate());
        }
        else if(item.equals(ItemsMenuSort.BY_THEME)){
            Collections.sort(notes, new SortTheme());
        }
        else if(item.equals(ItemsMenuSort.BY_MAIL)){
            Collections.sort(notes, new SortMail());
        }
        else if(item.equals(ItemsMenuSort.BY_MESSAGE)){
            Collections.sort(notes, new SortMessage());
        }
        else if(item.equals(ItemsMenuSort.BY_DATE_AND_THEME)){
            Collections.sort(notes, new SortDateAndTheme());
        }
        showAll();
    }
}
