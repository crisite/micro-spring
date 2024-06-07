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

    /**
     * 用于判断注册表中是否包含指定的 BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表包含的所有 BeanDefinition 的名称
     * @return
     */
    String[] getBeanDefinitionNames();


}
