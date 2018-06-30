package com.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xly on 2018/6/16.
 */

//AOP校验参数userName不能为空
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNameCheck {

}
