package com.test.thread;

public class QueryOrderId implements Runnable {

    @Override
    public void run() {

        System.out.println("多线程实现 Runnable 接口" + Thread.currentThread());

    }

}
