package test.futureTask;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,2, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        Future future1 =  threadPoolExecutor.submit(new CallableTest1());
        Future future2 =  threadPoolExecutor.submit(new CallableTest2());
        Future future3 =  threadPoolExecutor.submit(new CallableTest3());
        Object o1 = future1.get(1000000000,TimeUnit.MILLISECONDS);
        Object o2 = future2.get(1000000,TimeUnit.MILLISECONDS);
        Object o3 = future3.get(1000000000,TimeUnit.MILLISECONDS);
        System.out.println(0);
    }

    static class CallableTest1 implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(10000000);
            System.out.println("执行 CallableTest 中 call()");
            return "执行 CallableTest 中 call()";
        }
    }

    static class CallableTest2 implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(10000000);
            System.out.println("执行 CallableTest 中 call()");
            return "执行 CallableTest 中 call()";
        }
    }
    static class CallableTest3 implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(100000000);
            System.out.println("执行 CallableTest 中 call()");
            return "执行 CallableTest 中 call()";
        }
    }
}
