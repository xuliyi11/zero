package com.test.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //创建线程 A
        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程A子线程执行完成");
            }
        };

        Thread threadA = new Thread(runnableA);

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B子线程执行完成");
            }
        };
        Thread threadB = new Thread(runnableB);
        //执行线程B
        threadB.start();
        //执行线程 A
        threadA.start();

    }
}
