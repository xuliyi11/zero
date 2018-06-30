package com.exception;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xly on 2018/6/10.
 */
public class MiddleWareException extends RuntimeException {
    /**
     * 中间件服务异常
     * @param message
     */
    public MiddleWareException(String message){
        super(message);
    }

}
