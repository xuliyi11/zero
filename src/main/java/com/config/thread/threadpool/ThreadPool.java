package com.config.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPool {

    public int corePoolSize;
    private int maxPoolSize;
    private long keepAliveTime;
    private TimeUnit unit;


    public ThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
          }

    public ThreadPoolExecutor getThreadPool() {

        return new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,new ArrayBlockingQueue<Runnable>(3));

    }

}
