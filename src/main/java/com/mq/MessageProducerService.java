package com.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class MessageProducerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;



    public void sendMessage(Destination destination, final String msg){
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        jmsTemplate.send(destination, session -> session.createTextMessage(msg));
    }

    public void sendMessage(final String msg){
        Destination destination = jmsTemplate.getDefaultDestination();
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        jmsTemplate.send(session -> session.createTextMessage(msg));
    }
}
