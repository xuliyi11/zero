package com.test.aop;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("config/spring/spring-aop.xml");
        Person person = (Person) ac.getBean("person");
        person.setStu("xuliyi");

    }
}
