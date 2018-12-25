package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(10)
public class TestAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAop.class);

    @Around("execution(* com.service.Impl.TestServiceImpl.*(..))")
    public Object test(ProceedingJoinPoint joinPoint) {


        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            LOGGER.error("吃掉异常");
        }
        return o;
    }

}
