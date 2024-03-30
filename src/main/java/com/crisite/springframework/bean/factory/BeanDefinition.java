package com.crisite.springframework.bean.factory;

/**
 * 在 spring 中 BeanDefinition 用于描述一个bean实例
 * 如这个实例拥有的属性值，构造函数的参数
 * 以及接口的具体实现类 可能提供的更进一步的信息
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 15:04
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
