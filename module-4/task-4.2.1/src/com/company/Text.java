package com.company;

public class Text {
    private String title = "";  //заголовок текста
    private String text = "";   //сам текст

    //get-методы
    public String getTitle(){
        return this.title;
    }

    public String getText(){
        return this.text;
    }

    //set-методы
    public void setText(Word word){
        this.text += " " + word.getValue();
    }

    public void setText(Sentence sentence){
        this.text += " " + sentence.getValue();
    }

    //конструкторы
    public Text(Word word){
        this.title = word.getValue();
    }

    public Text(Sentence sentence){
        this.text += sentence.getValue();
    }
}
