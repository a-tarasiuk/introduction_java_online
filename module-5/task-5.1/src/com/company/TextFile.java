package com.company;

public class TextFile extends File{
    private String      text;

    private String getText(){
        return text;
    }

    @Override
    protected void create(){
        System.out.println("\nВведите содержимое текстового файла - " + super.getName() +  super.getTypeFile() + ":");
        if(text == null)
            text = scanner.next();
        else
            System.out.println("Ошибка - Необходимо вызывать метод add().");
    }

    @Override
    protected void add(){
        System.out.println("\nВведите текст, который необходимо добавить в текстовый файл с именем - " + super.getName() + super.getTypeFile() + ":");
        text = text.concat(scanner.next());
    }

    @Override
    protected void delete(){
        text = null;
        System.out.println("\nФайл с именем - " + super.getName() + super.getTypeFile() + " успешно удален!");
    }

    @Override
    public String toString(){
        return "\nИнформация о файле:" +
                "\n- Имя файла: " + super.getName() +
                "\n- Тип файла: " + super.getTypeFile() +
                "\n- Содержимое файла:\n" + getText();
    }

    public TextFile(String name, TypeFile typeFile) {
        super(name, TypeFile.TXT);
    }
}
