package com.company;

class Student{
    private String  surnameAndInitials = "";        //фамилия и инициалы
    private int     numberOfGroup = 0;              //номер группы
    private int     progress[] = new int[5];          //успеваемость

    private int     rangeOfEnglishLettersL = 0;     //диапазон английский маленьких букв в ASCII
    private int     rangeOfEnglishLettersB = 0;     //диапазон английский БОЛЬШИХ букв в ASCII
    private int     sizeSurname = 0;                //длина фамилии

    //генерируем Фамилию и инициалы студента
    private void getSurnameAndInitials(){
        sizeSurname = (int)(Math.random() * 10);    //генерируем длину фамилии
        surnameAndInitials += getBigLetter();       //Генерируем первую большую букву фамилии
        for(int i = 0; i < sizeSurname; i++){       //заполняем маленькими буквами фамилию
            rangeOfEnglishLettersL = getRandom(97,122);
            surnameAndInitials += (char)rangeOfEnglishLettersL;
        }
        surnameAndInitials += " " + getBigLetter() + "." + getBigLetter() + ".";    //добавляем инициалы
    }

    //генерируем Большую букву
    private char getBigLetter(){
        rangeOfEnglishLettersB = getRandom(65,90);
        return (char)(rangeOfEnglishLettersB);  //добавляем пробел после фамии и Большую буквы имени с точкой;
    }

    //генерируем случайное число в заданом диапазоне [min, max] включительно
    private int getRandom(int min, int max){
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    //генерируем номер группы
    private void genGroup(){
        this.numberOfGroup = (int)(Math.random() * 10);
    }

    //генерируем оценку
    private void genProgress(){
        for(int i = 0; i < progress.length; i++)
            this.progress[i] = getRandom(8,10);
    }

    public int[] getProgress(){
        return this.progress;
    }

    public void getStudent(){
        System.out.printf("%n%-10s%-17s%-10s%-5s%-10s", "Студент:", this.surnameAndInitials, "№ группы:", this.numberOfGroup, "Оценки:");
        for(int i = 0; i < progress.length; i++)
            System.out.printf("%-4s", progress[i]);
    }

    //конструктор
    Student(){
        getSurnameAndInitials();
        genGroup();
        genProgress();
    }
}

public class Main {

    public static void main(String[] args) {
        boolean flag;                           //установится true, если оценки студента будут только 9 и 10

	    Student[] st = new Student[10];
        for(int i = 0; i < st.length; i++)
            st[i] = new Student();

        System.out.println("# Все студенты:");
        for(int i = 0; i < st.length; i++)
            st[i].getStudent();

        System.out.println("\n\n# Студенты, имеющиее оценки только 9 и 10:");
        for(int i = 0; i < st.length; i++){
            flag = false;                       //устанавливает значение фалага по умолчанию в false перед каждой проверкой
            for(int j : st[i].getProgress())    //если у студента есть хоть одна оценка ниже 9, то flag = false, следовательно он не подходит
                if(!(flag = ((j < 9) ? false : true)))  break;
            if(flag) st[i].getStudent();
        }

    }
}
