package com.crisite.springframework.beans.factory.support;

import com.crisite.springframework.beans.factory.BeanDefinitionStoreException;
import com.crisite.springframework.core.io.Resource;
import com.crisite.springframework.core.io.ResourceLoader;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 14:41
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException;

    void loadBeanDefinitions(Resource... resources) throws BeanDefinitionStoreException;

    void loadBeanDefinitions(String location) throws BeanDefinitionStoreException;

}
