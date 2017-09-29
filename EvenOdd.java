package com.sudharsan.examples;

import java.util.Queue;


public class EvenOdd {
    private static Object object = new Object();

    private static int count = 1;

    public static void main(final String[] args) {

        final Thread odd = new Thread(new Odd(), "Odd Thread");
        final Thread even = new Thread(new Even(), "Even Thread");

        odd.start();
        even.start();
    }
    static class Odd implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                while (true) {
                    if (count % 2 != 0) {
                        System.out.println("Count by : " + Thread.currentThread().getName() + " " + count );
                        count++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notify();


                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Even implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                while(true) {
                    if (count % 2 == 0) {
                        System.out.println("Count by : " + Thread.currentThread().getName() + " " + count );
                        count++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        object.notify();


                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
