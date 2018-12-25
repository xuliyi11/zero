package com.aop;

import com.aop.annotation.DataSource;
import com.config.datasource.HandleDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;

import java.lang.reflect.Method;

@Aspect
public class DataSourceAop {

    @Around("@annotation(dataSource)")
    public Object getDataSourceType(ProceedingJoinPoint joinPoint, DataSource dataSource) throws Throwable {
        return execute(joinPoint, dataSource);
    }

    public Object execute(ProceedingJoinPoint joinPoint, DataSource dataSource) throws Throwable {

        System.out.println("----------:"+dataSource.dataSourceType());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        signature.getReturnType();

        String name = joinPoint.getSignature().getName();
        String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String declaringType = joinPoint.getSignature().getDeclaringTypeName();
        joinPoint.getSignature().getModifiers();
        joinPoint.getThis();
        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();


        HandleDataSource.putDataSourceType(dataSource.dataSourceType());

        return joinPoint.proceed();



    }

}
