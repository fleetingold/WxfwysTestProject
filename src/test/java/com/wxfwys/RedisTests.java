package com.wxfwys;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest(classes = WxfwysApplication.class)
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTest() {
        //保存字符串
        stringRedisTemplate.opsForValue().set("runoob", "Hello SpringBoot&Redis!");
        Assert.assertEquals("Hello SpringBoot&Redis!", stringRedisTemplate.opsForValue().get("runoob"));
    }
}
