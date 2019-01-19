package com.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultThreadPoolExecutor extends ThreadPoolExecutor {


    /**
     * 默认线程池
     * @param corePoolSize
     * @param maximumPoolSize
     * @param queueSize
     * @param keepAliveTime
     */
    public DefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, int queueSize, long keepAliveTime) {
        super(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(queueSize <= 0 ? 10: queueSize),
                Executors.defaultThreadFactory(),
                new AbortPolicy()
        );
    }

}
