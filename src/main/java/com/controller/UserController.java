package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aop.NullParamAop;
import com.exception.ParamValidException;
import com.mapper.UserMapper;
import com.domain.User;
import com.redis.RedisUtils;
import com.service.DemoService;
import com.utils.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    private RedisUtils redisUtils;

    private static final String REDIS_ALL_USER_KEY = "redis_get_all_user_key";

    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> gerAllUser(@RequestBody  User user) throws Throwable {
        Long nx = redisUtils.getJedis().setnx("xuliyi","name");
        logger.info(String.valueOf(nx) );
        String result =redisUtils.getJedis().setex("xuliyi",100,"expire");
        logger.info(result );
        return userMapper.selectAll();
    }

    @RequestMapping(value = "/user1", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<User> gerAllUser1(@RequestParam Integer id, @RequestParam String userName) throws IOException {
        List<User> userList;
        if (redisUtils.exists(REDIS_ALL_USER_KEY)){
            logger.error("redis 存在key："+REDIS_ALL_USER_KEY);
            userList = MapUtils.string2List(redisUtils.get(REDIS_ALL_USER_KEY));
            return userList;
        }else {
            logger.error("DB 查询结果："+REDIS_ALL_USER_KEY);
            userList = userMapper.selectAll();
            redisUtils.set(REDIS_ALL_USER_KEY,JSONObject.toJSONString(userList));
        }
        return userList;
    }
}
