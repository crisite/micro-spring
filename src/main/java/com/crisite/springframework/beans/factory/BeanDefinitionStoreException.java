package com.crisite.springframework.beans.factory;

import com.crisite.springframework.beans.FatalBeanException;
import com.sun.istack.internal.Nullable;
/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 15:13
 */
@SuppressWarnings("serial")
public class BeanDefinitionStoreException extends FatalBeanException {

    @Nullable
    private final String resourceDescription;

    @Nullable
    private final String beanName;

    public BeanDefinitionStoreException(String msg) {
        super(msg);
        this.beanName = null;
        this.resourceDescription = null;
    }

    public BeanDefinitionStoreException(String msg, @Nullable Throwable cause) {
        super(msg, cause);
        this.beanName = null;
        this.resourceDescription = null;
    }

    public BeanDefinitionStoreException(@Nullable String resourceDescription, String msg) {
        super(msg);
        this.resourceDescription = resourceDescription;
        this.beanName = null;
    }

    public BeanDefinitionStoreException(@Nullable String resourceDescription, String msg, @Nullable Throwable cause) {
        super(msg, cause);
        this.resourceDescription = resourceDescription;
        this.beanName = null;
    }

    public BeanDefinitionStoreException(@Nullable String resourceDescription, String beanName, String msg) {
        this(resourceDescription, beanName, msg, null);
    }

    public BeanDefinitionStoreException(
            @Nullable String resourceDescription, String beanName, String msg, @Nullable Throwable cause) {

        super("Invalid bean definition with name '" + beanName + "' defined in " + resourceDescription + ": " + msg,
                cause);
        this.resourceDescription = resourceDescription;
        this.beanName = beanName;
    }

    @Nullable
    public String getResourceDescription() {
        return this.resourceDescription;
    }

    @Nullable
    public String getBeanName() {
        return this.beanName;
    }
}
