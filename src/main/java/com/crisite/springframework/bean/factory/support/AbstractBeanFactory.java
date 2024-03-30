package com.crisite.springframework.bean.factory.support;

import com.crisite.springframework.bean.BeansException;
import com.crisite.springframework.bean.factory.BeanFactory;
import com.crisite.springframework.bean.factory.config.BeanDefinition;

/**
 * BeanDefinition 注册表接口
 * 子类主要需要实现的是 getBeanDefinition 和 createBean 方法
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:57
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        // 只有在第一次调用 getBean 的时候才 createBean吗？ 不应该啊
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 返回对应的 beanDefinition 子类实现时一般需要加缓存
     * 据spring doc说  bean definition access is an expensive operation
     * 访问 bean 的 beanDefinition 是一项很昂贵的操作
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * All bean retrieval methods delegate to this method for actual bean creation.
     * ? 所有的 bean 创建最终都要走到这个方法来 ？
     * 这个方法的话实际是将 bean 和 beanDefinition 绑定起来
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
