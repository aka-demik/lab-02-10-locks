package com.easy;

public class Main {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1: start");
                synchronized (lock1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1: in lock 1");
                    synchronized (lock2) {
                        System.out.println("1: in lock 2");
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("2: start");
                synchronized (lock2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2: in lock 2");
                    synchronized (lock1) {
                        System.out.println("2: in lock 1");
                    }
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
