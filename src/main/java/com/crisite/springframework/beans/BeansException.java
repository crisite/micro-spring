package com.crisite.springframework.beans;

/**
 * Bean 相关的 Exception
 *
 * @Author: Rao Sheng
 * @Date: 2024/3/30 16:13
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) { super(msg); }

    public BeansException(String msg, Throwable cause) { super(msg, cause); }

}