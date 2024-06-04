package com.crisite.springframework.beans.factory;

import com.crisite.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 16:06
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 Bean 名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();

}
