package com.exception;

/**
 * Created by xly on 2018/3/27.
 */
public class ParamValidException extends RuntimeException {

    /**
     * 参数异常
     * @param message
     */
    public ParamValidException(String message){
        super(message);
    }

}
