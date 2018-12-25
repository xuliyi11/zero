package aspecttest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogTest {

    @Pointcut(value = "execution(* aspecttest.ProcessData.saveDB())")
    public void logTest() {

    }


    @Around(value = "logTest()")
    public void printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行 saveDB 方法前");

        joinPoint.proceed();

        System.out.println("执行 saveDB 方法后");

    }

}
