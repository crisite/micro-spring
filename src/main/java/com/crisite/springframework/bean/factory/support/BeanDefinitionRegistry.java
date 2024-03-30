package com.crisite.springframework.bean.factory.support;

import com.crisite.springframework.bean.factory.config.BeanDefinition;

/**
 * Bean注册表
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:29
 */
public interface BeanDefinitionRegistry {

    /**
     * 在注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
