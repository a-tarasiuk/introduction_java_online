package com.company.sort;

import com.company.note.Note;

import java.util.Comparator;

public class SortMail implements Comparator<Note> {
    public int compare(Note a, Note b){
        return a.getMail().toLowerCase().compareTo(b.getMail().toLowerCase());
    }
}
