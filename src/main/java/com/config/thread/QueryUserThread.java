package com.config.thread;

import com.service.TestService;

import java.util.concurrent.Callable;

public class QueryUserThread implements Callable<Object> {


    private TestService testService;
    private int id;

    public QueryUserThread(TestService testService, int id) {
        this.testService = testService;
        this.id = id;
    }


    @Override
    public Object call() throws Exception {

        return testService.getUser(id);

    }
}
