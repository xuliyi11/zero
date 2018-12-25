package aspecttest;

public aspect LogAspect {

    /**
     * 定义切点,日志记录切点
     */
    //pointcut recordLog():call(* aspecttest.ProcessData.saveDB());

    /**
     * 定义前置通知!
     */
    //before():recordLog(){
     //   System.out.println("执行 saveDB 方法前");
   // }

    /**
     * 定义后置通知
     */
   // after():recordLog(){
   //     System.out.println("执行 saveDB 方法后");
   // }

}
