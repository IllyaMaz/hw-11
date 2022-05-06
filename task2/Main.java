package com.company;

import java.util.Scanner;

public class Main {

static String result ="";
    public static void main(String[] args) throws InterruptedException {
        int n ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nuber");
        n=scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            thead(i);
            Thread.currentThread().sleep(15);
        }

        System.out.println(result);

    }

    private static void thead(int n){
        Thread fizz = new Thread(()->{
                if (n % 3==0 && n%15!=0) {
                    result+="fizz, ";
                }
        });

        Thread buzz = new Thread(()->{
                if (n % 5==0 && n%15!=0){
                    result+="buzz, ";
                }
        });
        Thread fizzBuzz = new Thread(() -> {
                if (n % 15 == 0){
                    result+="fizzbuzz, ";
                }
        });

        Thread number = new Thread(()->{
            if (n%3!=0&&n%5!=0){
                result+=n+", ";
            }
        });
        fizz.start();
        buzz.start();
        fizzBuzz.start();
        number.start();
    }
}
