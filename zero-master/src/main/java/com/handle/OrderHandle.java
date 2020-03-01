package com.handle;

import com.config.handle.Handle;
import com.domain.Order;
import com.query.QueryOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderHandle implements Handle<Order,QueryOrder> {

    public String getOrderInfo(String orderId){
        return "订单号为："+ orderId;
    }

    @Override
    public void execute(Order result, QueryOrder query) throws InterruptedException {
        Order order = new Order();
        order.setOrderId(query.getOrderId());
        order.setOrderName(query.getOrderId());
        Thread.sleep(1000);
        result.setOrderName(order.getOrderName());
        result.setOrderId(order.getOrderId());
    }
}
