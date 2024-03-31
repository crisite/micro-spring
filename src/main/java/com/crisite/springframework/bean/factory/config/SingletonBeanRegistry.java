package com.crisite.springframework.bean.factory.config;

/**
 * 单例注册表
 * 事实上，SingletonBeanRegistry 和 BeanFactory 的职责略有重复
 * SingletonBeanRegistry 负责单例 Bean 的注册和获取
 * BeanFactory 也负责 Bean 的创建、配置、和管理，这其中当然也包含了单例 Bean
 * SingletonBeanRegistry 在功能上是 BeanFactory 的子集...?
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:11
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
