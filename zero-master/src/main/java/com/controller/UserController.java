package com.controller;

import com.mapper.UserMapper;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2018-04-15.
 */
@Controller
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> gerAllUser(@RequestParam Integer name) {
        if(name==null){
            throw new RuntimeException("请求参数异常");
        }

        return userMapper.selectAll(name);

    }


    @RequestMapping(value = "/user1")
    @ResponseBody
    public List<User> gerAllUser1(@RequestParam int name) {


        return userMapper.selectAll(name);

    }

}
