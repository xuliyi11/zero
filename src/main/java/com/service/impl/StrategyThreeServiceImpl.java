package com.service.impl;

import com.service.StrategyService;
import org.springframework.stereotype.Service;

/**
 * Created by xly on 2018/6/2.
 */
@Service("strategy3")
public class StrategyThreeServiceImpl implements StrategyService {
    @Override
    public Boolean cancelOrder(String orderNo) {
        return Boolean.TRUE;
    }
}
