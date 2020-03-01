package test.sychronized;

import com.google.common.util.concurrent.Monitor;
import com.sun.corba.se.impl.monitoring.MonitoredObjectImpl;
import com.sun.corba.se.spi.monitoring.MonitoredObject;

public class ObjSynchronized implements Runnable {
    int i = 10000000;

    @Override
    public void run() {

        int j = 0;
        while (j < 5000000) {
            synchronized(this){
                i--;
            }
            j++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ObjSynchronized o1 = new ObjSynchronized();
        ObjSynchronized o2 = new ObjSynchronized();
        Thread thread1 = new Thread(o1);
        Thread thread2 = new Thread(o2);

        thread1.start();
        thread2.start();
    }
}
