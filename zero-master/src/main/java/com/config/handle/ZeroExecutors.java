package com.config.handle;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Component
public class ZeroExecutors {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZeroExecutors.class);

    //存储任务
    private List<ZeroCallable> zeroCallables = new ArrayList<>();

    //线程池
    private ThreadPoolExecutor threadPoolExecutor;

    public ZeroExecutors(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    /**
     * 添加任务
     *
     * @param queryParamObj
     * @param result
     * @param handle
     */
    public void addCallables(QueryParamObj queryParamObj,Object result, Handle handle) {
        ZeroCallable zeroCallable = new ZeroCallable(queryParamObj,handle,result);
        zeroCallables.add(zeroCallable);
    }

    public void executeTask(int timeOut) {
        for (ZeroCallable zeroCallable : zeroCallables) {
            Future future =  threadPoolExecutor.submit(zeroCallable);
            try {
                future.get(timeOut, TimeUnit.MILLISECONDS);
                System.out.println("future.get方法执行时间:"+System.currentTimeMillis());
            } catch (Exception e) {
                LOGGER.error("任务执行超时，超时任务为："+ JSONObject.toJSONString(zeroCallable),e);
            }
        }
    }

}
