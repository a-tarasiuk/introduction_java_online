package com.company;

import java.util.Scanner;

public abstract class File {
    private String      name;
    private TypeFile    typeFile;

    Scanner scanner = new Scanner(System.in);

    // вернуть название файла
    protected String getName(){
        return name;
    }

    // вернуть тип файла
    protected String getTypeFile(){
        return typeFile.getType();
    }

    // создать
    protected abstract void create();

    // переименовать
    protected void rename(){
        scanner.nextLine();
        System.out.print("\nВведите новое имя для файла - " + getName() + this.getTypeFile() + ": ");
        while (true){
            this.name = scanner.nextLine();
            if(this.name.length() == 0)
                System.out.print("\nОшибка - Имя файла не может быть пустым. Повторите ввод: ");
            else break;
        }
    }

    // дополнить
    protected abstract void add();

    // удалить
    protected abstract void delete();

    // конструктор
    protected File(String name, TypeFile typeFile){
        this.name = name;
        this.typeFile = typeFile;
        System.out.println("Создан файл:\n- " + getName() + getTypeFile());
    }
}

enum TypeFile{
    TXT(".txt"),
    JPG(".jpg"),
    DOC(".doc"),
    PDF(".pdf");

    String type;

    public String getType(){
        return type;
    }

    TypeFile(String type){
        this.type = type;
    }
}
