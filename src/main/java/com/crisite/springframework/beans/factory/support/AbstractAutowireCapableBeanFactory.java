package com.crisite.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.crisite.springframework.beans.BeansException;
import com.crisite.springframework.beans.PropertyValue;
import com.crisite.springframework.beans.PropertyValues;
import com.crisite.springframework.beans.factory.config.BeanDefinition;
import com.crisite.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 现在还看不出什么，但是在 spring 中这个接口实现了自动注入接口 AutowireCapableFactory
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 17:41
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    /** 记住这里是三级缓存(单例) */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            // 创建 Bean 实例
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 为 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    /**
     *  在此处调用 Bean 的实例化方法 后续应该仍需优化
     */
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 跟 入参列表长度 具有相同长度的 构造函数参数列表 的构造函数即是所需构造函数
        // 获取所需构造函数 用于创建Bean实例
        for (Constructor<?> ctor : declaredConstructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 为 Bean 填充属性
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    protected InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
