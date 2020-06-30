package com.company;

public class Main {

    public static void main(String[] args) {
        int A, B, x, y, z, result;

        while (true) {
            A = (int) (Math.random() * 30 + 1);
            B = (int) (Math.random() * 30 + 1);
            x = (int) (Math.random() * 30 + 1);
            y = (int) (Math.random() * 30 + 1);
            z = (int) (Math.random() * 30 + 1);

            System.out.println("\n-------------------------------");
            System.out.println("\nДлина отверстия = " + A + "\nВысота отверстия = " + B);
            System.out.println("\nРазмеры кирпича:\n" + "длина = " + x + "\nвысота = " + y + "\nгрубина = " + z);

            if ( ((x<A) || (x<B)) && ((y<B) || (y<A)) ) {
                System.out.println("Влазит! (выполнилось 1 условие)");
                break;
            }
            else if ( ((x<A) || (x<B)) && ((z<B) || (z<A)) ){
                System.out.println("Влазит! (выполнилось 2 условие)");
                break;
            }
            else if ( ((z<A) || (z<B)) && ((y<B) || (y<A)) ){
                System.out.println("Влазит! (выполнилось 3 условие)");
                break;
            }
            else System.out.println("No!");
        }
    }
}
