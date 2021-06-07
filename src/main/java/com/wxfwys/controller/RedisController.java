package com.wxfwys.controller;

import com.wxfwys.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/keys", method = RequestMethod.GET)
    public String redisKeys(Model model) {

        Set<String> keys = redisService.keys("*");

        model.addAttribute("keys", keys);

        return "redis";
    }

    @RequestMapping(value = "/keyexists/{key}")
    public String testTemplate(@PathVariable("key") String key,
                               Model model) {

        boolean isExists = redisTemplate.hasKey(key);

        String msg = "";
        if (isExists) {
            msg = key + "存在";
        } else {
            msg = key + "不存在";
        }
        model.addAttribute("msg", msg);

        return "redis";
    }
}
