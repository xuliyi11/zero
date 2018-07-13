package com.aop.redisAop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.redis.ZeroRedis;
import com.utils.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by xly on 2018/6/30.
 */
@Component
@Aspect
public class RedisAop {

    @Resource(name = "redisUtils")
    private ZeroRedis redisUtils;

    @Pointcut(value = "@annotation(redisAnnotation)",argNames = "redisAnnotation")
    private void con(RedisAnnotation redisAnnotation){

    }

    @Around( value = "con(redisAnnotation)", argNames = "pjp,redisAnnotation")
    public Object redisAop(ProceedingJoinPoint pjp,RedisAnnotation redisAnnotation) throws Throwable {
        Signature signature = pjp.getSignature();
        if (!(signature instanceof MethodSignature)){
            return pjp.proceed();
        }

        Method method = ((MethodSignature) signature).getMethod();
        String methodName = method.getName();
        Object objectType = method.getReturnType();

        String args = JSONObject.toJSONString(pjp.getArgs());

        String redisKey = StringUtils.isBlank(redisAnnotation.key()) ?  "zero_" +  methodName + "_" + args : redisAnnotation.key();

        int expireTime = redisAnnotation.expireTime() == 300 ? 300  : redisAnnotation.expireTime();

        String redisValue = redisUtils.get(redisKey);

        if (StringUtils.isBlank(redisValue)){

            Object obj = pjp.proceed();
            try {
                redisUtils.set(redisKey,JSONObject.toJSONString(obj));
            } catch (Exception e) {
                throw  new RuntimeException("Exception ：aop 设置缓存失效，失效原因：" , e );
            }

        }else {

            return JSON.parseObject(redisValue,((MethodSignature) signature).getReturnType());

        }

        return null;
    }
}
