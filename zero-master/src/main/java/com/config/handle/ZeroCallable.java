package com.config.handle;

import java.util.concurrent.Callable;

public class ZeroCallable<T> implements Callable<T> {

    private QueryParamObj queryParamObj; //请求参数
    private Handle handle; //处理的handle
    private T result; //返回结果

    public ZeroCallable(QueryParamObj queryParamObj, Handle handle, T result) {
        this.queryParamObj = queryParamObj;
        this.handle = handle;
        this.result = result;
    }

    @Override
    public T call() throws Exception {
        handle.execute(result,queryParamObj);
        return result;
    }
}
