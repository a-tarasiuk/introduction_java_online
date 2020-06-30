package com.company;

// О Б Л А С Т Ь

import java.util.ArrayList;
import java.util.Scanner;

public class Region {
    private String              name;                           // название области
    private int                 square;                         // площадь области (км. кв.)
    private int                 numberDistrict;                 // кол-во районов
    private ArrayList<District> district = new ArrayList<>();   // районы

    Scanner scanner = new Scanner(System.in);

    public int getNumberDistrict(){
        return numberDistrict;
    }

    public ArrayList<District> getDistrict(){
        return district;
    }

    public String getName(){
        return this.name;
    }

    public int getSquare(){
        square = 0;
        for(int i = 0; i < district.size(); i++)
            square += district.get(i).getSquare();
        return square;
    }

    public void addDistrict(){
        district.add(new District());
    }

    public void setNumberDistrict(){
        while (true){
            this.numberDistrict = scanner.nextInt();
            if (this.numberDistrict > 0)
                return;
            System.out.print("\n[ОШИБКА] Должен быть хотя бы один районный центр.\n" +
                    "Повторите ввод: ");
        }
    }

    Region(){
        while (true){
            this.name = scanner.nextLine();
            if (this.name.trim().length() != 0)
                return;
            System.out.print("\n[ОШИБКА] Название области не может быть пустым полем.\n" +
                    "Повторите ввод: ");
        }
    }
}
