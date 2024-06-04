package com.crisite.springframework.beans.factory;

/**
 * 在spring里 BeanFactory 是 spring bean容器的根接口
 * 在spring里面的话 bean注册是交给了 SingletonBeanRegistry 来管理
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 15:39
 */
public interface BeanFactory {

    /**
     * 获取 bean 实例
     * 包括创建 bean 实例 也是在 getBean 方法中实现(实现接口)
     *
     * @param name
     * @return
     */
    Object getBean(String name);

    Object getBean(String name, Object... args);

}