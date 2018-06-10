package com.exception;

/**
 * Created by xly on 2018/3/27.
 */
public class ParamValidException extends RuntimeException {

    public ParamValidException(String message){
        super(message);
        System.out.println(message);
    }

}
