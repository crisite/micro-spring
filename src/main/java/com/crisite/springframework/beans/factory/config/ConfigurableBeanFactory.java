package com.crisite.springframework.beans.factory.config;

import com.crisite.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 15:53
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
