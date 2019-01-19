package com.test;

public class construct {
    public static void main(String[] args) {
          final boolean[] flag = {false};
        final int[] x = {5};
        int y = 4;
        Runnable runnable = () -> {
            x[0] = 6;
            flag[0] = true;
        };

        Runnable runnable1 = () -> {
            if(!flag[0]){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(x[0]);
        };

        new Thread(runnable).start();
        new Thread(runnable1).start();
    }
}
