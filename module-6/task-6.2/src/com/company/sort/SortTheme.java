package com.company.sort;

import com.company.note.Note;
import java.util.Comparator;

public class SortTheme implements Comparator<Note> {
    public int compare(Note a, Note b){
        return a.getTheme().toLowerCase().compareTo(b.getTheme().toLowerCase());
    }
}
