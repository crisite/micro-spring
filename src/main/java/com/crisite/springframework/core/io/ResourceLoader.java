package com.crisite.springframework.core.io;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/10 11:45
 */
public interface ResourceLoader {

   // 用于从类路径加载的伪 URL 前缀：“classpath：”
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
