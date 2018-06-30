package com.CallableHandle;

import com.domain.User;
import com.service.DemoService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by xly on 2018/6/16.
 */


@Service(value = "callableHandle")
public class CallableHandle implements Callable<List<User>> {

    @Resource(name = "demoService")
    private DemoService demoService;


    @Override
    public List<User> call() throws Exception {
        List<User> list =  demoService.queryAllUser();
        return list;
    }
}
