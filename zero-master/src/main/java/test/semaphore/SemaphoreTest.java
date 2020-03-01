package test.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private Semaphore semaphore = new Semaphore(310);

    class SharedThread implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行 开始");
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("任务执行 结束");
        }

    }

    public static void main(String[] args) {

        SemaphoreTest semaphoreTest = new SemaphoreTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
        executorService.execute(semaphoreTest.new SharedThread());
    }

}
