package test.BlockingQueue;

import org.apache.poi.ss.formula.functions.T;

public class Main {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(2);

        new Thread(() -> {
            myBlockingQueue.add(new Main());
            myBlockingQueue.add(new Main());
            myBlockingQueue.add(new Main());
            myBlockingQueue.add(new Main());
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myBlockingQueue.get();

        }).start();
    }
}
