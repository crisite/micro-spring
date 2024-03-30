package com.crisite.springframework.test;

import com.crisite.springframework.bean.factory.config.BeanDefinition;
import com.crisite.springframework.bean.factory.support.DefaultListableBeanFactory;
import com.crisite.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: Rao Sheng
 * @Date: 2024/3/30 18:23
 */
public class ApiTest {
    @Test
    public void createBeantest() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUser();
    }
}
