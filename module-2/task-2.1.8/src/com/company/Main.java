package com.company;

public class Main {

    public static void main(String[] args) {

        int     a[] = new int[(int)(Math.random()*100)],
                b[] = new int[a.length - 1],
                min = 0;

        for(int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.println("a[" + i + "] = " + a[i]);
        }

        min = a[0];

        for (int i = 0; i < a.length; i++)
            if(min > a[i]) min = a[i];

        System.out.println("min = " + min);

        for(int i = 0, j = 0; i < a.length; i++, j++) {
                if (a[i] != min) {
                    b[j] = a[i];
                }
                else j--;

        }

        for (int i = 0; i < b.length; i++)
            System.out.println("b[" + i + "] = " + b[i]);

    }
}
