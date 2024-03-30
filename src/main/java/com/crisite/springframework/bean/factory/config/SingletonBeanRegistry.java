package com.crisite.springframework.bean.factory.config;

/**
 * 单例注册表
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:11
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
