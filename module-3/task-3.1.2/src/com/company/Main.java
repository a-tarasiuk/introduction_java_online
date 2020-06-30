package com.company;

public class Main {
    /* метод - getCh
    проверяем совпадение содержимого массивов
    true - если там содержится в массиве b слово "word"
    false - если там не слово "word"
    */
    public static boolean getCh(char chWord[], char b[]){
        for(int i = 0; i < chWord.length; i++)
            if(chWord[i] != b[i]){
                return false;
            }
        return true;
    }

    /* Методе - add
    Метод записывает в новую строку слово letter, где:
    newStr - новая строка, в которую нужно записать
    chLetter - массив символов, который нужно записать в строку newStr
     */
    public static String add(String newStr, char[] chLetter){
        for(int j = 0; j < chLetter.length; j++)
            newStr += chLetter[j];
        return newStr;
    }

    public static void main(String[] args) {
        char    chWord[] = {'w', 'o', 'r', 'd'},
                chLetter[] = {'l', 'e', 't', 't', 'e', 'r'},
                ch[] = new char[chWord.length]; //служит для записи слова из str, начинающегося на букву 'w'
        String  str = "other word mom father word best word",
                newStr = "";
        System.out.println("Исходная строка:\n" + str);

        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == chWord[0] & i < str.length()) { //Если символ 'w',
                str.getChars(i, i + chWord.length, ch, 0); //то записываем следующие 3 символа из String, чтобы сравнить в методе, являются ли данные симоволы - word
                if (getCh(chWord, ch)) {   //Если совпало (см. описание метода getCh), то
                    //записываем "letter" вместо "word"
                    newStr = add(newStr, chLetter);
                    i += chWord.length - 1; //далее следующий элемент будет символ 'o' (в слове "word"), поэтому индекс i сдвигаем на 3 символа вперед (чтобы оставшееся "ord" не проверялось
                }
            }
            else newStr += str.charAt(i); //если символ не 'w', записываем его в новую строку
        }

        System.out.println("\nПосле замены word на letter:\n" + newStr);

    }
}
