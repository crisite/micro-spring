package com.crisite.springframework.bean.factory.support;

import com.crisite.springframework.bean.BeansException;
import com.crisite.springframework.bean.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib 的实例化方案
 *
 * @author: Puff
 */
public class CglibSubclassInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 1. 创建一个Enhancer工具类
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类 可以时类或接口
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // 3. 设置回调函数
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 4. 创建代理对象
        if (ctor == null) {
            return  enhancer.create();
        }
        // 5. 返回代理对象
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
