package com.controller.hystrix;

import com.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HystrixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/hystrix")
    @HystrixCommand(commandKey = "queryCommand", threadPoolKey = "queryPool", fallbackMethod = "fallBackGetUserList")
    public List<User> getUserList(@RequestAttribute int id) throws InterruptedException {
        LOGGER.error("未进入熔断器");
        Thread.sleep(5000);
        LOGGER.error("请求 db 返回结果：" + testService.getUser(id));

        return testService.getUser(id);
    }

    public List<User> fallBackGetUserList(int id) {
        LOGGER.error("已进入熔断器");
        return null;
    }


    @RequestMapping("/hystrix2")
    @HystrixCommand(commandKey = "queryCommand2", threadPoolKey = "queryPool", fallbackMethod = "fallBackGetUserList")
    public List<User> getUserList2(@RequestAttribute int id) throws InterruptedException {
        LOGGER.error("未进入熔断器");
        Thread.sleep(5000);
        LOGGER.error("请求 db 返回结果：" + testService.getUser(id));

        return testService.getUser(id);
    }


    @RequestMapping("/hystrix3")
    public String getUserList3(@RequestAttribute int id) throws Exception {

        Command command = new Command("hello");
        String result = command.execute();

        return result ;
    }

}
