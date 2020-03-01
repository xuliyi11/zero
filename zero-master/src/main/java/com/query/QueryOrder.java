package com.query;

import com.config.handle.QueryParamObj;

public class QueryOrder implements QueryParamObj {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void valida() {

    }
}
