package com.company;

public class Main {

    public static void main(String[] args) {
        // создаем директории
        Directory   root        = new Directory("root");
        Directory   home        = new Directory("home");
        Directory   user        = new Directory("user");
        Directory   documents   = new Directory("documents");
        Directory   txt       = new Directory("txt");
        Directory   photos      = new Directory("photos");
        root.add(home);
        root.add(user);
        user.add(documents);
        documents.add(txt);
        documents.add(photos);

        // создаем текстовый файл
        TextFile tf = new TextFile("Новый текстовый документ (1)", TypeFile.TXT );
        TextFile tf2 = new TextFile("Новый текстовый документ (2)", TypeFile.TXT );

        // добавляем текстовый файл в директорию
        // создаем 2 файла для наглядности структуры каталогов, которая выводится ниже
        // но изменять будем один файл
        txt.add(tf);
        txt.add(tf2);

        // получить структуру каталогов и файлов
        root.getStructure();

        // создаем текст в текстовом файле
        tf.create();

        // добавляем текст в текстовый файл
        tf.add();

        // вывести информацию о файле
        System.out.println(tf.toString());

        // переименовать файл
        tf.rename();

        // получить структуру каталогов и файлов
        root.getStructure();

        // удаляем файл
        tf.delete();
        txt.deleteFile(tf);

        // получить структуру каталогов и файлов
        root.getStructure();
    }
}
