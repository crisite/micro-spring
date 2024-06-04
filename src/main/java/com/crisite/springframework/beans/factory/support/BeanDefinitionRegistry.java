package com.crisite.springframework.beans.factory.support;

import com.crisite.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean注册表
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:29
 */
public interface BeanDefinitionRegistry {

    /**
     * 在注册表中注册 BeanDefinition
     *
     * @param beanName Bean 实例名称
     * @param beanDefinition 将创建出的 BeanDefinition 存入注册表
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
