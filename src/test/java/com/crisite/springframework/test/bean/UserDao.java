package com.crisite.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Rao Sheng
 * @Date: 2024/7/6 17:09
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Rao Sheng");
        hashMap.put("10002", "xiao bai");
        hashMap.put("10003", "puff");
        hashMap.put("10004", "crisite");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
