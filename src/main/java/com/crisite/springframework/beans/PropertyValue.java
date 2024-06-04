package com.crisite.springframework.beans;

/**
 * bean 的属性, 存放在 PropertyValue 中, 而非 map 对象
 * 这种方式具有更高的灵活性
 *
 * @Author: Rao Sheng
 * @Date: 2024/4/24 20:44
 */
public class PropertyValue {

    private final String name;

    // 如果 Object instanceof BeanReference
    // 那说明依赖于其他 bean
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
