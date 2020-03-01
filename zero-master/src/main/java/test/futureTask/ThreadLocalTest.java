package test.futureTask;

import com.alibaba.fastjson.JSONObject;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
              new Thread(() -> {
                  threadLocal.set(123);
                  System.out.println(JSONObject.toJSON("当前线程id为："+Thread.currentThread().getId()+"线程中数据为："+threadLocal.get()));
              }
              ).start();
             Thread.sleep(1000);
        }
    }
}
