package com.test.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static int i = 0;
    private static final ReentrantLock reentrantLock = new ReentrantLock(false);
    public static void main(String[] args) {
        Runnable a = Main::addI;
        Runnable b = Main::addI;
        Thread A = new Thread(a);
        Thread B = new Thread(b);

        A.start();
        B.start();

    }

    private static void addI() {
        reentrantLock.lock();
        for (int j = 0; j <= 1000000; j++) {
            i++;
            System.out.println(i);

        }
        reentrantLock.unlock();
    }
}
