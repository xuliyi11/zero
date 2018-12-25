package com.service.Impl;

import com.domain.User;
import com.mapper.user.UserMapper;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestService testService;

    @Autowired
    private UserMapper userMapper;

    public List<User> getUser(int id) {

        testService.getUser(12);
        return userMapper.selectAll(id);
    }
}
