package com.company;

//предложение
public class Sentence {
    private String value = "";

    public String getValue(){
        return this.value;
    }

    public void addValue(Word word){
        value += (value == "") ? word.getValue() : " " + word.getValue();
    }

    public Sentence(String s){
        this.value += s;
    }
}
