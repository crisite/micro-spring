package com.crisite.springframework.beans.factory;

import com.crisite.springframework.beans.BeansException;
import com.crisite.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.crisite.springframework.beans.factory.config.BeanDefinition;
import com.crisite.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 16:05
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
