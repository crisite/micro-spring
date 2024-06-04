package com.crisite.springframework.beans.factory.config;

/**
 * @Author: Rao Sheng
 * @Date: 2024/4/24 20:49
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
