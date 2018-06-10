package com.service;

import com.domain.User;

import java.util.List;

/**
 * Created by xly on 2018/5/9.
 */
public interface DemoService {
    /**
     * 请求所有用户
     * @return
     */
    List<User> queryAllUser();
}
