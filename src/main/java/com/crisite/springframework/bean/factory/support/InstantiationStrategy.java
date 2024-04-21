package com.crisite.springframework.bean.factory.support;


import com.crisite.springframework.bean.BeansException;
import com.crisite.springframework.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean 实例化策略
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
