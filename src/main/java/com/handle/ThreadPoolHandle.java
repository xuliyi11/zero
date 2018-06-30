package com.handle;

import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xly on 2018/6/16.
 */
//线程池控制器
public class ThreadPoolHandle extends ThreadPoolExecutor {

    //实现线程池接口
    public ThreadPoolHandle(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    //线程过期时间和排队策略写死
    public ThreadPoolHandle(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

}
