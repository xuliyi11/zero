package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.domain.User;
import com.mapper.UserMapper;
import com.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xly on 2018/5/9.
 */
@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private UserMapper userMapper ;
    @Override
    public List<User> queryAllUser() {
        List<User> userList = userMapper.selectAll();
        for (User user : userList){
            logger.info(JSON.toJSONString(user));
        }
        return userMapper.selectAll();
    }
}
