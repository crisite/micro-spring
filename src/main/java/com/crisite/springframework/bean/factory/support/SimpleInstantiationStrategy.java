package com.crisite.springframework.bean.factory.support;

import com.crisite.springframework.bean.BeansException;
import com.crisite.springframework.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: Puff
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    /**
     * @TODO: 不懂
     *
     * @param beanDefinition:
     * @param beanName:
     * @param ctor:
     * @param args:
     * @return Object
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
