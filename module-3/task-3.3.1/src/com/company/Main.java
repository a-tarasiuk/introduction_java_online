package com.company;

import java.util.Scanner;

public class Main {
    public static void getChoice(int choice, String s){
        switch (choice){
            case 1: methodCase1(s); break;
            case 2: methodCase2(s); break;
            case 3: methodCase3(s); break;
            case 4: break;
        }
    }

    public static void methodCase1(String s){
        System.out.println("\nВсего абзацев: " + s.split("\n").length + "\nАбзацы, отсортированные по количеству предложений по возрастанию:");
        sortItem(s);
    }

    public static void methodCase2(String s){
        int count = s.split("[!?.]").length;                        //количество предложений
        int i = 0;                                                        //счетчик

        System.out.print("\nВсего предложений - " + count + ":\n");

        for(String s1 : s.split("[!?.]") ) {                        //выбираем предложения
            i++;
            s1 = s1.trim();
            sortWords(s1);
        }
    }

    public static void methodCase3(String s){
        int[][] index;                                                     //в index[i-слово][0] запишется индекс, по которому находится слово из массива words
                                                                           //в index[i-слово][1] запишется количество вхождений символа (вводится из клавиатуры) в слове
        String[] word = s.split("\\p{P}?[ \\t\\n\\r.]+");           //записываем каждое слово в массив String
        index = new int[word.length][3];
        System.out.println("Размер index: " + index.length);

        System.out.print("\nВведите символ: ");
        Scanner in = new Scanner(System.in);
        char ch = in.next(".").charAt(0);                           //принимаем из клавиатуры нужный символ
        in.close();

        System.out.println("\nВсего лексем в тексте: " + word.length);
        for(int i = 0; i < word.length; i++){                              //берем каждое слово
            int count = 0;                                                 //количество вхождений введенного с клавиатуры символа в слове
            index[i][0] = i+1;                                             //порядковый номер массива index
            index[i][1] = i;                                               //порядкоый номер слова word
            for(char sign : word[i].toCharArray()){                        //берем каждую букву слова и записываем её в переменную sign
                if(sign == ch) count++;
                index[i][2] = count;
            }
            //System.out.println("В слове: " + word[i] + " содержится введенных символов: " + count);
        }
        sortLexeme(index, word);
    }

    //сортировка слов предложения по возрастанию (исходя из количества букв в слове)
    public static void sortWords(String str){
        sort(str.split("\\p{P}?[ \\t\\n\\r]+"));                        //разбиваем предложения по словам
    }

    //сортировка абзацев по количеству предложений
    public static void sortItem(String str){
        sort(str.split("\n"));                                          //разбиваем текст на абзацы
    }

    //сортировка массива int
    public static void sortLexeme(int[][] lexeme, String[] word){
        sort(lexeme, word);
    }

    //сортировка
    public static void sort(String[] s){
        boolean sorted = false;
        String buf;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < s.length - 1; i++) {
                if (s[i].length() > s[i + 1].length()) {
                    sorted = false;

                    buf = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = buf;
                }
            }
        }
        printAnswer(s);
    }

    public static void sort(int[][] index, String[] word){
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < index.length - 1; i++) {
                if (index[i][2] < index[i + 1][2]) {
                    sorted = false;

                    index[i][2] = index[i][2] + index[i+1][2] - (index[i+1][2] = index[i][2]);  //меняем кол-во вхождений буквы в лексему
                    index[i][1] = index[i][1] + index[i+1][1] - (index[i+1][1] = index[i][1]);  //меняем порядковые номера
                }
            }
        }

        //выбор в index слов по количеству вхождений символа
        for(int i = 0, j; i < index.length; i++) {
            j = i;
            while (true){
                if(j < index.length && index[i][2] == index[j][2])  //записыпаем границы массива, в которых у слов есть одинаковое кол-во вхождений символа
                    j++;
                else {
                    sortChar(word, index, i, j);
                    i = j;
                    break;
                }
            }
        }

    }

    public static String[] sortChar(String[] word, int[][] index, int start, int end){
        for (int j = start; j < end; j++) {
            for (int i = j + 1; i < end; i++) {
                if (word[index[i][1]].compareTo(word[index[j][1]]) < 0) {
                    String k = word[index[j][1]];
                    word[index[j][1]] = word[index[i][1]];
                    word[index[i][1]] = k;
                }
            }
            System.out.println(index[j][0] + ". " + word[index[j][1]] + "\t - Кол-во вхождений символа: " + index[j][2]);
        }
        return word;
    }

    public static void printAnswer(String[] s){
        for(int i = 0; i < s.length; i++)
            System.out.println((i+1) + ". " + s[i].trim());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
	    String str = "Первое предложение. Второе предложение!\n" +
                     "Вася, который час? Сколько будет два плюс три? Тактовая частота процессора.\n" +
                     "Мороз и солнце; день чудесный! Два предложение! Три предложение! Четыре предложение. Пять предложение. Шестое тоже.\n" +
                     "Очень коротко и очень емко. Это гениально. Кто помнит Букварь, знает, какие там были  рассказы.";
	    System.out.print("Исходный текст:\n" + str + "\n\nВыберите одно из действий:" +
                         "\n1. Отсортировать абзацы по количеству предложений" +
                         "\n2. В каждом предложении отсортировать слова по длине" +
                         "\n3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства - по алфавиту" +
                         "\n4. Выйти из программы" +
                         "\nВаш выбор: ");
        Scanner in = new Scanner(System.in);

        while (true){
            int choice = in.nextInt();
            if(choice > 0 & choice < 5) {
                getChoice(choice, str);
                break;
            }
            else System.out.print("[ОШИБКА] Сделайте правильный выбор: ");
        }

    }
}
