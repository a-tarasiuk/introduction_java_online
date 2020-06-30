package com.company;

public class Main {

    public static double getMaxSum(double b[]){
        double maxSum = 0.0;
        for(int i = 0, j = b.length - 1; i < j; i++, j--){
            maxSum = Math.max(maxSum, b[i] + b[j]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int N = (int)(Math.random() * 100);
        double a[] = new double[N];

        //заполняем массив
        for(int i = 0; i < a.length; i++) {
            a[i] = Math.random();
            System.out.println("A[" + i + "] = " + a[i]);
        }

        System.out.println("Answer:" + getMaxSum(a));

    }
}
