package com.test.threadpoolexecutors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,2,2, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(4));
    public static void main(String[] args) {
        for (int i= 0;i<2;i++){
            //threadPool.submit()
            threadPool.execute(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
