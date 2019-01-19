package com.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    private Object[] data;//数据对象
    private int count = 0;//当前数据对象中含有多少个数据
    private int addPosition = 0;//当前add数据的索引位置
    private int takePosition = 0;//当前take数据的索引位置

    private Lock lock = new ReentrantLock();// 线程锁

    private Condition addCondition = lock.newCondition();	// 添加条件
    private Condition takeCondition = lock.newCondition();	// 取出条件

    public BlockingQueue(int size) {
        data = new Object[size];
    }

    public void add(Object value) {
        lock.lock();// 线程加锁
        try {
            while (count == data.length) {// 队列已经满了
                try {
                    //System.out.println("add await thread:" + Thread.currentThread().getName());
                    addCondition.await();// 该条件判断如果线程检测到队列已满,则全部进入等待。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (addPosition == data.length) {// 判断如果add索引位置等于size,则索引位置需要从0开始算起
                addPosition = 0;
            }

            data[addPosition] = value;
            /*
             * 这里会有个疑问？会不会把当前的位置原有的值给覆盖？
             * 不会，因为当前只有一个线程进来,当add lock释放前,先去通知take取值
             */

            System.out.println("add:" + value + " add index:" + addPosition + " thread name:" + Thread.currentThread().getName());

            addPosition++;	//更新当前索引位置
            count++;

            takeCondition.signalAll();//唤醒take线程

        } finally {
            lock.unlock();//线程解锁
        }

    }

    public Object take() {

        lock.lock();
        Object value = null;
        try {
            while (count == 0) {
                try {
                    //System.out.println("take await thread:" + Thread.currentThread().getName());
                    takeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (takePosition == data.length) {
                takePosition = 0;
            }

            value = data[takePosition];
            System.out.println("take:" + value + " take index:" + takePosition + " thread name:" + Thread.currentThread().getName());

            takePosition++;
            count--;

            addCondition.signalAll();
        } finally {
            lock.unlock();
        }
        return value;
    }

    /*
     * Test main
     */
    public static void main(String[] args) {

        final BlockingQueue blockingQueue = new BlockingQueue(2);
        for (int i=0;i<3;i++){
            blockingQueue.add(i);
        }

        /*
         * 开启5个线程同时往阻塞队列里面赋值。
         * 因为阻塞队列里面size=1,所以开启5个线程每次只能有一个线程往里面add数据,其他4个线程必须在等待
         */
       /* for (int i = 0; i < 1000; i++) {
            final int index = i;
            new Thread(){
                public void run() {
                    double value = Math.random();
                    //
                    blockingQueue.add(index);
                };
            }.start();
        }*/

        /*
         * 为了在多线程并发情况下，观测add线程等待情况
         * 休眠5s之后开启新的线程从阻塞队列里面take
         */
       /* try {
            //Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(){
            public void run() {
                while (true) {
                    // 从阻塞队列里面取值
                    Object value = blockingQueue.take();
                }
            };
        }.start();*/
    }
}
