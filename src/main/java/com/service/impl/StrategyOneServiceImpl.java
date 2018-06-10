package com.service.impl;

import com.service.StrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by xly on 2018/6/2.
 */

@Service("strategy1")
public class StrategyOneServiceImpl implements StrategyService {

    private static final Logger logger = LoggerFactory.getLogger(StrategyOneServiceImpl.class);

    @Override
    public Boolean cancelOrder(String orderNo) {
        logger.info("策略模式命中1，orderNo:"+orderNo);
        return Boolean.TRUE;
    }
}
