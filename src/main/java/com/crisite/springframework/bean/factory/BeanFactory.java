package com.crisite.springframework.bean.factory;

import com.crisite.springframework.bean.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在spring里 BeanFactory 是 spring bean容器的根接口
 * 在spring里面的话 bean注册是交给了 SingletonBeanRegistry 来管理
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 15:39
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param name
     * @return
     */
    Object getBean(String name);

    Object getBean(String name, Object... args);

}