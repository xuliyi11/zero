package com.test.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("config/spring/test-spring.xml"));

        Person person = (Person) beanFactory.getBean("person");

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


    }

}