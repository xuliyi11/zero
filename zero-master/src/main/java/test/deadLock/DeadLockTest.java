package test.deadLock;

/**
 * 死锁测试
 */
public class DeadLockTest {
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread1 对 lock1 上锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("Thread1 对 lock2 上锁");
                }

            }
        }
    }
    class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("Thread2 对 lock2 上锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("Thread2 对 lock1 上锁");
                }

            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        Thread thread1 = new Thread(deadLockTest.new Thread1());
        Thread thread2 = new Thread(deadLockTest.new Thread2());
        thread1.start();
        thread2.start();
    }

}
