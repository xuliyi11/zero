package com.controller;

import com.aop.NullParamAop;
import com.aop.SkipNullCheck;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenyuan on 2018-04-15.
 */
@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NullParamAop nullParamAop;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public List<User> gerAllUser(@RequestBody User user) throws Throwable {
        return userMapper.selectAll();
    }

    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    @ResponseBody
    public List<User> gerAllUser1(@RequestParam Integer id, @RequestParam String userName) throws Throwable {
        return userMapper.selectAll();
    }
}
