package test.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    Lock lock = new ReentrantLock();
    Condition empty = lock.newCondition();

    public void get() throws InterruptedException {
        try{
            lock.lock();
            System.out.println(Thread.currentThread());
            empty.await();
            System.out.println(Thread.currentThread());
        }finally {
            lock.unlock();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
         new Thread(()->{
            try {
                conditionTest.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                conditionTest.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
