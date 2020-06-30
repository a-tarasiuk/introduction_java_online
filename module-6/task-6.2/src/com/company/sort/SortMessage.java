package com.company.sort;

import com.company.note.Note;

import java.util.Comparator;

public class SortMessage implements Comparator<Note> {
    public int compare(Note a, Note b){
        return a.getMessage().toLowerCase().compareTo(b.getMessage().toLowerCase());
    }
}
