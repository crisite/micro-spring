package com.crisite.springframework.bean.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在spring里 BeanFactory 是 spring bean容器的根接口
 * 在spring里面的话 bean注册是交给了 SingletonBeanRegistry 来管理
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 15:39
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name);
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}