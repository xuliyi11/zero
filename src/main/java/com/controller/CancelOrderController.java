package com.controller;

import com.enumVo.OrderSource;
import com.service.StrategyService;
import com.service.impl.StrategyOneServiceImpl;
import com.service.impl.StrategyTwoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xly on 2018/6/2.
 */
@Controller
public class CancelOrderController {


    private static Map<String,StrategyService> strategyServiceMap =new HashMap<>();

    @Autowired
    private StrategyService strategy1;

    static {
        strategyServiceMap.put("1",new StrategyOneServiceImpl());
        strategyServiceMap.put("2",new StrategyTwoServiceImpl());
        strategyServiceMap.put("3",new StrategyTwoServiceImpl());
    }

    @ResponseBody
    @RequestMapping(value = "strategy")
    public Boolean cancelOrder(@RequestParam String orderNo, @RequestParam String orderSource){
        return strategyServiceMap.get(orderSource).cancelOrder(orderNo);
    }
}
