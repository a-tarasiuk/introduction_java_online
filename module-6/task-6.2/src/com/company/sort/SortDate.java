package com.company.sort;

import com.company.note.Note;
import java.util.Comparator;

public class SortDate implements Comparator<Note> {

    public int compare(Note a, Note b){
        return a.getDate().compareTo(b.getDate());
    }
}
