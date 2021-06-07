package com.wxfwys.controller;

import com.wxfwys.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String testRedis(@PathVariable("reader") String reader,
                            Model model) {

        Set<String> keys = redisService.keys("*");

        model.addAttribute("keys",keys);

        return "redis";
    }
}
