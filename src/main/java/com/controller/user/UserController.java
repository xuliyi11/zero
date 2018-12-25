package com.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.config.thread.QueryUserThread;
import com.config.thread.threadpool.ThreadPool;
import com.domain.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mq.MessageListenerService;
import com.mq.MessageProducerService;
import com.redis.ZeroRedis;
import com.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by chenyuan on 2018-04-15.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private TestService testService;

    public UserController(TestService testService) {
        this.testService = testService;
    }


    @Autowired
    private ThreadPool threadPool;

    @Autowired
    private ZeroRedis zeroRedis;

    @Autowired
    private MessageProducerService messageProducerService;

    @Autowired
    private MessageListenerService messageListenerService;


    private ArrayList<User> test;

    public ArrayList<User> getTest() {
        return test;
    }

    @Autowired
    public void setTest(ArrayList<User> test) {
        this.test = test;
    }

    @Resource(name = "demoQueueDestination")
    private Destination destination;


    @RequestMapping(value = "/user")
    @ResponseBody
    public List<User> gerAllUser(@RequestAttribute Integer id) throws InterruptedException {


        User user = new User();
        user.setId(11);
        user.setName("xiaoxu");
        System.out.println(JSON.toJSON(user));
        //  System.out.println(JSONObject.toJSONString(testList));

        System.out.println(JSONObject.toJSONString(test));
       // zeroRedis.set("name", "xkw");

        QueryUserThread queryUserThread = new QueryUserThread(testService, id);

        Future<Object> future = threadPool.getThreadPool().submit(queryUserThread);
        Thread.sleep(3000);
        List<User> users = null;
        try {
            LOGGER.error("发送时主题为 destination：{}", destination);
            users = (List<User>) future.get();
            messageProducerService.sendMessage(JSONObject.toJSONString(users));
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return users;
    }


    @RequestMapping(value = "/receiver")
    @ResponseBody
    public List<User> listenerMsg() throws JMSException {
        TextMessage textMessage = messageListenerService.receive(destination);
        String text = textMessage.getText();
        List<User> userList = (List<User>) JSON.parseObject(text, List.class);
        return userList;
    }

    public List<User> testHystrix(Integer i) {
        System.out.println("Hello world!!");
        return new ArrayList<>();
    }


    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {

        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

    }


    public static void main(String[] args) throws IOException {

        String key = "123".replace("123", "");
        System.out.println(key);
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("name", null);
        }};
        //  int i = map.get("name");


        String jsonResult = "{11226425449:{\"pid\":\"2\",\"url\":\"http://item.jd.com/2.html\"}}";

        //HashMap<String, Map<String, Object>> returnMap = (HashMap<String, Map<String, Object>>)JSON.parseObject(jsonResult,HashMap.class);

        HashMap<String, Map<String, Object>> returnMap = (HashMap<String, Map<String, Object>>) objectMapper.readValue(jsonResult, HashMap.class);

        // Map<String, Object> map = returnMap.get("11226425449");

        // System.out.println(returnMap);
        ;
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        list = list.stream().sorted(Comparator.comparingInt(User::getId).reversed()).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(list));
    }


}
