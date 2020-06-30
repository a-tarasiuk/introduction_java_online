package com.company.sort;

import com.company.note.Note;

import java.util.Comparator;
import java.util.Date;

public class SortDateAndTheme implements Comparator<Note> {
    @Override
    public int compare(Note a, Note b) {
        Date date1 = a.getDate();
        Date date2 = b.getDate();
        int returnValue = date1.compareTo(date2);

        if (returnValue != 0)
            return returnValue;

        return a.getTheme().compareTo(b.getTheme());
    }

}
