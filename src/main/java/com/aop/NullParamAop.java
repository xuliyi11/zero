package com.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by xly on 2018/4/17.
 */
@Aspect
@Order(1)
@Component
public class NullParamAop {

    @Pointcut("execution(* com.controller..*.*(..)))")
    private void controller(){

    }

    @Around("controller()")
    public Object checkNullParam(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature =(MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args =joinPoint.getArgs();
        Parameter[] parameters= method.getParameters();
        for (int i=0;i<parameters.length;i++){
            if (!check(parameters[i],args[i])){
                throw new Exception("---------参数异常-------");
            }
        }
        return joinPoint.proceed(args);
    }

    private boolean check(Parameter parameter,Object object){
        if (parameter.getDeclaredAnnotation(SkipNullCheck.class)!= null){
            return true;
        }
        if (object == null){
            return false;
        }
        if (parameter.getType() == String.class){
            if (String.class.isAssignableFrom(object.getClass())){
                return StringUtils.isNoneBlank((CharSequence)object);
            }else {
                return false;
            }
        }
        return true;
    }
}
