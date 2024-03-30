package com.crisite.springframework.bean.factory.support;

import com.crisite.springframework.bean.BeansException;
import com.crisite.springframework.bean.factory.config.BeanDefinition;

/**
 * 现在还看不出什么，但是在 spring 中这个接口实现了自动注入接口 AutowireCapableFactory
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 17:41
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /** 记住这里是三级缓存(单例) */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
