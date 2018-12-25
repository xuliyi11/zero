package com.test.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器---------------------1");
        if ("stu".equals(beanName) && bean instanceof Stu) {

            Stu stu = ((Stu) bean);
            System.out.println(stu.name);
            stu.setName("xukewen");
            return stu;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器---------------------2");
        if ("stu".equals(beanName) && bean instanceof Stu) {
            Stu stu = (Stu) bean;
            System.out.println(stu.name);
        }
        return bean;
    }
}
