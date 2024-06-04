package com.crisite.springframework.beans.factory.support;

import com.crisite.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例注册表的具体实现
 * 三级缓存在本实现中的 addSingleton 方法中可见一斑
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:48
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
