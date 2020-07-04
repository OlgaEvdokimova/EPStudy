package com.company;

public class Main {

    public static void main(String[] args) {
        //1
        String name = "Olga";
        System.out.println("Всем привет! Меня зовут " + name);
        System.out.println();
        //2
        double x = 0.25;
        double y = 0.9;
        System.out.println(10 * x + y);
        System.out.println((20 - y) * x);
        System.out.println(33 - (y + x));
        System.out.println();
        //3
        double a = 5;
        double b = 3;
        System.out.println("Average is " + (a + b) / 2);
        System.out.println();
        //4
        double A = 200;
        double discountA = 15;
        double AWithDiscount = A - A * discountA / 100;
        double B = 30;
        double result;
        result = (10 * AWithDiscount) + (2 * B);
        System.out.println("Final sum " + result);
        System.out.println();
        //5
        int n = -10;
        if (n > 0){
            System.out.println("Module of " + n + "is " + n);
        } else if (n < 0){
            System.out.println("Module of " + n + " is " + (-n));
        }
        System.out.println();
        //6
        double sum = 81;
        double firstDiscount = 3;
        double sumWithFirstDiscount = sum - sum * firstDiscount / 100;
        double secondDiscount = 5;
        double sumWithSecondDiscount = sum - sum * secondDiscount / 100;
        double thirdDiscount = 7;
        double sumWithThirdDiscount = sum - sum * thirdDiscount / 100;
        if (sum > 20 && sum <= 50){
            System.out.println(sumWithFirstDiscount);
        } else if (sum > 50 && sum <= 80){
            System.out.println(sumWithSecondDiscount);
        }else if ( sum > 80){
            System.out.println(sumWithThirdDiscount);
        } else {
            System.out.println(sum);
        }



    }
}






















