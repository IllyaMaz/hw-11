package com.company;

public class Main {
    private static int point = 1;
    public static void main(String[] args) throws InterruptedException {

    Runnable oneSecond = new Runnable() {
        @Override
        public void run() {
        while (!Thread.currentThread().isInterrupted()) {

                System.out.println(point +" second plus");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            point++;
        }
        }
    };

    Runnable fiveSecondsLatter = new Runnable() {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                if (point % 5 == 0){
                    System.out.println("5 seconds latter");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

	Thread thread = new Thread(oneSecond);
    Thread thread1 = new Thread(fiveSecondsLatter);
    thread.start();
    thread1.start();
    }
}
