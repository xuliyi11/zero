package com.test.thread;

public class QueryOrderName extends  Thread {


    @Override
    public void run(){

        System.out.println("多线程继承 Thread 类"+Thread.currentThread());

    }
}
