package com.config.handle;

public interface Handle<T,E> {
    /**
     *
     * @param result 返回的数据，注意线程安全
     * @param query 接口调用的参数
     */
    void execute(T result, E query) throws InterruptedException;
}
