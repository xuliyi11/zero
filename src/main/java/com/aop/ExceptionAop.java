package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(900)
public class ExceptionAop {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(ExceptionAop.class);

    private static final String RAVEN_SYSTEM_WARNING = "raven_system_warning";

   @Around("execution(* com.controller..*.*(..))")
    public Object executeExceptionUmp(ProceedingJoinPoint joinPoint) throws Throwable {

       // Logger.error("ExceptionAop executeExceptionUmp start...");
        //方法详细信息
        Signature signature = joinPoint.getSignature();

        if (signature == null) {
            return null;
        }

        //包名 方法名
        String declaringTypeNam = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (NullPointerException e) {
            Logger.error("ExceptionAop executeExceptionUmp businessAlarm start...");
           /* Profiler.businessAlarm(RAVEN_SYSTEM_WARNING, System.currentTimeMillis(), "【各位，raven exception，请及时处理，这是一个空指针异常】，异常方法："
                    + declaringTypeNam + "_" + methodName);*/
            Logger.error("ExceptionAop executeExceptionUmp businessAlarm end...");
        }

        return result;
    }

}
