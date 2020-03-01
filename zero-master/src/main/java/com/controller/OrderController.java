package com.controller;

import com.config.DefaultThreadPoolExecutor;
import com.config.handle.ZeroExecutors;
import com.domain.Order;
import com.handle.OrderHandle;
import com.query.QueryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Session;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class OrderController {

    @Autowired
    private DefaultThreadPoolExecutor defaultThreadPoolExecutor;

    @Autowired
    private OrderHandle orderHandle;

    @RequestMapping(value = "/queryOrderInfo")
    @ResponseBody
    public String getOrderInfo(@RequestParam String orderId) {
        ZeroExecutors zeroExecutors = new ZeroExecutors(defaultThreadPoolExecutor);
        QueryOrder queryOrder = new QueryOrder();
        queryOrder.setOrderId(orderId);
        Order order = new Order();
        zeroExecutors.addCallables(queryOrder, order, orderHandle);
        zeroExecutors.addCallables(queryOrder, order, orderHandle);
        zeroExecutors.addCallables(queryOrder, order, orderHandle);
        zeroExecutors.addCallables(queryOrder, order, orderHandle);
        zeroExecutors.executeTask(1500);
        return order.getOrderName();
    }

    @RequestMapping(value = "/queryOrderInfo1")
    @ResponseBody
    public String getOrderInfo1(@RequestParam String orderId1) {
        ZeroExecutors zeroExecutors = new ZeroExecutors(defaultThreadPoolExecutor);
        QueryOrder queryOrder = new QueryOrder();
        queryOrder.setOrderId(orderId1);
        Order order = new Order();
        zeroExecutors.addCallables(queryOrder, order, orderHandle);
        zeroExecutors.executeTask(0);
        return order.getOrderName();
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam String test) {

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        return "";
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("主线程开始执行");
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Executors.newFixedThreadPool(10).submit(new Task(countDownLatch, i));
        }
        countDownLatch.await();
        System.out.println("主线程结束执行");
    }

    static class Task implements Runnable {

        CountDownLatch countDownLatch;
        int tag;

        Task(CountDownLatch countDownLatch, int tag) {
            this.countDownLatch = countDownLatch;
            this.tag = tag;
        }

        @Override
        public void run() {
            try {
                System.out.println(tag);
            } finally {
                countDownLatch.countDown();

            }
        }
    }


}
