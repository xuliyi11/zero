package test.BlockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private LinkedList linkedList = new LinkedList();
    private int size;
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void add(Object o){
        lock.lock();
        while (linkedList.size()==size){
            try {
                addCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(o);
        takeCondition.signal();
        lock.unlock();
    }

    public Object get(){
        lock.lock();
        while (linkedList.size() == 0){
            try {
                takeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object o = linkedList.pop();
        addCondition.signal();
        lock.unlock();
        return o;
    }

}
