package com.aop.redisAop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xly on 2018/6/30.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisAnnotation {


    //自定义Redis key，默认 ""
    String key() default "";


    //自定义缓存过期时间，默认 300s
    int expireTime() default  300;


}
