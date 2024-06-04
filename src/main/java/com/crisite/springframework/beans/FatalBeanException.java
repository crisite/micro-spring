package com.crisite.springframework.beans;

import com.sun.istack.internal.Nullable;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 15:10
 */
public class FatalBeanException extends BeansException {

    public FatalBeanException(String msg) {
        super(msg);
    }

    public FatalBeanException(String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }

}
