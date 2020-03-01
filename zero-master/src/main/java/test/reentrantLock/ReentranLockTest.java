package test.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockTest {

    private Lock lock = new ReentrantLock(false);

    private void increat(int i){
        lock.lock();
        try {
            i++;
            System.out.println(i);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranLockTest lockTest = new ReentranLockTest();
        lockTest.increat(0);
    }
}
