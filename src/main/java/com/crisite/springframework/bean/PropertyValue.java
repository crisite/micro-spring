package com.crisite.springframework.bean;

/**
 * @Author: Rao Sheng
 * @Date: 2024/4/24 20:44
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
