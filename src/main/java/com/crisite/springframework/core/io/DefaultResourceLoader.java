package com.crisite.springframework.core.io;

import cn.hutool.core.lang.Assert;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Rao Sheng
 * @Date: 2024/5/11 14:14
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }

        else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }
            catch (MalformedURLException ex) {
                return new FileSystemResource(location);
            }
        }
        return null;
    }
}
