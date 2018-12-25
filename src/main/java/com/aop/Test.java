package com.aop;

import com.aop.annotation.TestAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Test {

    @Around("@annotation(test)")
    public Object getMethodParam(ProceedingJoinPoint joinPoint, TestAnnotation test) throws Throwable {
        return DoGetMethodParam(joinPoint, test);
    }

    public Object DoGetMethodParam(ProceedingJoinPoint joinPoint, TestAnnotation test) throws Throwable {
        System.out.println(test.methodParam());
        return joinPoint.proceed();
    }
}
