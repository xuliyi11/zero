package com.test.thread;

public class TestThread {

    public static void main(String[] args) {

        QueryOrderName queryOrderName =new QueryOrderName();

        //start 方法真正启动线程
        queryOrderName.start();


        Thread thread =new Thread(new QueryOrderId());

        //start 方法真正启动线程
        thread.start();


        Runnable runnable =new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread thread1 =new Thread(runnable);
        thread1.start();




    }

}
