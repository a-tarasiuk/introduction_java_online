package com.company;

// К О Л Е С О

public class Wheel {
    private static int RADIUS_DEFAULT = 14;
    private int radius;

    //получить размер колеса
    public int getRadius(){
        return this.radius;
    }

    //установить размер колеса
    public void setRadius(int radius) {
        if(radius < 14 || radius > 22)
            throw new IllegalArgumentException("Радиус колеса должен быть в пределах от 14 до 22 дюймов");
        else
            this.radius = radius;
    }

    //пустой конструктор, задающий радиус колеса
    public Wheel(){
        this.radius = RADIUS_DEFAULT;
    }

    //конструктор, радиус колеса задает пользователь
    public Wheel(int radius){
        if(radius < 14 || radius > 22)
            throw new IllegalArgumentException("Радиус колеса должен быть в пределах от 14 до 22 дюймов");
        else
            this.radius = radius;
    }
}
