package com.company;

class CaseSnake{
    private String[] newStr;        //новый String с новым размером (с учетом нижнего пробела)

    public void getString(String str[]){
        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < str[i].length(); j++)
                System.out.print(str[i].charAt(j));
            System.out.println();
        }
    }

    public void getString(char ch[]){
        for(int i = 0; i < ch.length; i++)
            System.out.print(ch[i]);
        System.out.println();
    }


    public void toSnakeCase(String str[]){
        char    ch,         //сюда помещаем символ для проверки его регистра (верхний\нижний)
                array[];    //массив, в который будет заноситься одно предложение, например "CamelCase" или "AaaaAaaa"
        int     size = 0;   //размер массива array[]

        for(int i = 0; i < str.length; i++){
            size = str[i].length() + 1;     // +1, потому, что нужно добавить символ нижнее подчеркивание "_"
            array = new char[size];         //создаем массив символов на каждое предложение, например "CamelCase" или "AaaaAaaa"
            for(int j = 0, k = 0; j < str[i].length(); j++, k++){   // j - для нумерации элементов str, k - для нумерации массива array[]
                ch = str[i].charAt(j);

                if(Character.isUpperCase(ch)) { //если символ в верхнем регистре
                    ch += 32;        //переводим его в нижний
                    if(k == 0) {     //если это начало массива, просто записываем символ
                        array[k] = ch;
                    }
                    else {           //иначе (если это второй уже символ в верхнем регистре), то добавляем перед ним символ нижнего подчеркивания
                        array[k] = '_';
                        array[k+1] = ch;
                        k++;
                    }
                }
                else array[k] = ch; //иначе (если символ в нижнем регистре) записываем его сразу в array[]
            }
            //getString(array);
            connect(i, array);
        }
    }

    public void connect(int i, char ch[]){
        for(int j = 0; j < ch.length; j++) {
            newStr[i] += ch[j];
        }
    }

    public void setNewSize(String str[]){
        /*Сейчас, во время инициализации массива строк, эти строки заполняются по умолчанию значением "null" и  при
        * записи далее любого символа в строку, строка будет выгляеть так "nullЛюбыеСимволыТут". И чтобы этого не было,
        * (чтобы в начале строке небыло текста "null", сделаем строки пустыми методом setAll*/
        newStr = new String[str.length];
        java.util.Arrays.setAll(newStr, i -> "");
    }

    public void getNewString(){
        System.out.println("\nСтроки в snake_case:");
        for(int i = 0; i < newStr.length; i++){
            for(int j = 0; j < newStr[i].length(); j++)
                System.out.print(newStr[i].charAt(j));
            System.out.println();
        }
    }

}

public class Main {

    public static void main(String[] args) {
        String  str[] = {"CamelCase", "AaaaAaaa", "DerTeww", "NameSpace"};

        CaseSnake cs = new CaseSnake();
        cs.setNewSize(str);
        System.out.println("Названия переменных в CamelCase:");
        cs.getString(str);
        cs.toSnakeCase(str);
        cs.getNewString();
    }
}
