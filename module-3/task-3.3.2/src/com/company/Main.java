package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String myText = "<notes>\n" +
                        "\t<note id = \"1\">\n" +
                            "\t\t<to>Вася</to>\n" +
                            "\t\t<from>Света</from>\n" +
                            "\t\t<heading>Напоминание</heading>\n" +
                            "\t\t<body>Позвони мне завтра!</body>\n" +
                        "\t</note>\n" +
                        "\t<note id = \"2\">\n" +
                            "\t\t<to>Петя</to>\n" +
                            "\t\t<from>Маша</from>\n" +
                            "\t\t<heading>Важное напоминание</heading>\n" +
                            "\t\t<body></body>\n" +
                        "\t</note>\n" +
                    "</notes>\n";
        String myRegex = "(<([</]?)[\\w \\=\"\\\0-9]*>)([А-Яа-яёЁ ]*)";

        //Объект Pattern представляет откомпилированное регулярное выражение
        Pattern p = Pattern.compile(myRegex);
        //Объект Matcher представляет конкретный экземпляр этого регулярного выражения, примененный к заданному тексту
        Matcher m = p.matcher(myText);

        while (m.find()){
            if(m.group(2).length() == 0) {  //если тег не содержит текста
                System.out.printf("%-5s%-20s%-20s", "Тег:", m.group(1),"Тип: Открывающий");
                if(m.group(3).length() != 0) System.out.printf("%-30s", "Содержимое тега: " + m.group(3));
                System.out.println();
            }
            else
                System.out.printf("%-5s%-20s%-20s%n", "Тег", m.group(1),"Тип: Закрывающий");
        }

    }
}
