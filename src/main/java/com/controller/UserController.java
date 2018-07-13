package com.controller;

import com.CallableHandle.CallableHandle;
import com.alibaba.fastjson.JSONObject;
import com.aop.NullParamAop;
import com.aop.redisAop.RedisAnnotation;
import com.handle.ThreadPoolHandle;
import com.mapper.UserMapper;
import com.domain.User;
import com.redis.ZeroRedis;
import com.service.DemoService;
import com.utils.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * Created by chenyuan on 2018-04-15.
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NullParamAop nullParamAop;

    @Autowired
    private DemoService demoService;

    @Autowired
    private ZeroRedis zeroRedis;

    @Autowired
    private ThreadPoolHandle threadPoolHandle;

    @Resource(name = "callableHandle")
    private CallableHandle callableHandle;

    private static final String REDIS_ALL_USER_KEY = "redis_get_all_user_key";



    @RequestMapping(value = "/user")
    @ResponseBody
    @RedisAnnotation
    public List<User> gerAllUser(@RequestBody  User user) throws Throwable {
        Long nx = zeroRedis.getJedis().setnx("xuliyi","name");
        logger.info(String.valueOf(nx) );
        String result =zeroRedis.getJedis().setex("xuliyi",100,"expire");
        logger.info(result );
        return userMapper.selectAll();
    }

    @RequestMapping(value = "/user1", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    @RedisAnnotation
    public List<User> gerAllUser1(@RequestParam Integer id, @RequestParam String userName) throws IOException {
        List<User> userList;
        if (zeroRedis.exists(REDIS_ALL_USER_KEY)){
            logger.error("redis 存在key："+REDIS_ALL_USER_KEY);
            userList = MapUtils.string2List(zeroRedis.get(REDIS_ALL_USER_KEY));
            return userList;
        }else {
            logger.error("DB 查询结果："+REDIS_ALL_USER_KEY);
            userList = userMapper.selectAll();
            zeroRedis.set(REDIS_ALL_USER_KEY,JSONObject.toJSONString(userList));
        }
        return userList;
    }


    @RequestMapping(value = "/callable", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<User> testCallable(@RequestParam Integer id, @RequestParam String userName) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        List<User> userList;
        Future<List<User>> future = threadPoolHandle.submit(callableHandle);

        return future.get();
    }
}
