package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by xly on 2018/6/16.
 */
@Aspect
@Component
public class UserNameCheckAop {

    //切入点
    @Pointcut("execution(* com.controller..*.*(..)))")
    private void controller(){

    }


}
