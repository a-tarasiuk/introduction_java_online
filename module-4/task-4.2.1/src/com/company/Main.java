package com.company;

public class Main {

    public static void main(String[] args) {
        //создаем слово (вызывается конструктор)
        Word word = new Word("Заголовок");

        //создаем фразу (вызывается конструктор)
        Sentence sentence = new Sentence("Фраза при создании");

        //создаем заголовок, который равен слову word (вызывается конструктор)
        Text text = new Text(word);

        //создаем слова
        Word word1 = new Word("Первое");
        Word word2 = new Word("Второе");
        Word word3 = new Word("Третье");

        //создаем фразу из слов
        sentence.addValue(word1);
        sentence.addValue(word2);
        sentence.addValue(word3);

        //создаем предложение из фразы
        text.setText(sentence);
        //добавляем в предложение слово
        text.setText(word1);

        //выводим результат
        System.out.println("Заголовок: " + text.getTitle() + "\nТекст: " + text.getText());

    }
}
