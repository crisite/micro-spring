package com.crisite.springframework.test;

import com.crisite.springframework.beans.PropertyValue;
import com.crisite.springframework.beans.PropertyValues;
import com.crisite.springframework.beans.factory.config.BeanDefinition;
import com.crisite.springframework.beans.factory.config.BeanReference;
import com.crisite.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.crisite.springframework.test.bean.UserDao;
import com.crisite.springframework.test.bean.UserService;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Rao Sheng
 * @Date: 2024/3/30 18:23
 */
public class ApiTest {
    @Test
    public void createBeantest() {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2.注册 bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, null);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.第一次获取 bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUser();
//
//        // 4.第二次获取 bean from Singleton
//        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
//        userService_singleton.queryUser();

        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性 [uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果： " + result);

    }


}
