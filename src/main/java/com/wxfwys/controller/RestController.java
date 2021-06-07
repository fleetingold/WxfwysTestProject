package com.wxfwys.controller;

import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping(value = "/request")
    public String request() {
        System.out.println("request");
        return "request";
    }

    @GetMapping(value = "/test1")
    public String getTest1() {
        System.out.println("get test1");
        return "test1";
    }

    @GetMapping(value = "/test2")
    public String getTest2() {
        System.out.println("get test2");
        return "test2";
    }

    @GetMapping(value = "/test3")
    public String getTest3() {
        System.out.println("get test3");
        return "test3";
    }

    @GetMapping(value = "/test4")
    public String getTest4() {
        System.out.println("get test4");
        return "test4";
    }

    @PostMapping
    public void post() {
        System.out.println("post");
    }

    @DeleteMapping
    public void delete() {
        System.out.println("delete");
    }

    @PutMapping
    public void put() {
        System.out.println("put");
    }

    @PatchMapping
    public void patch() {
        System.out.println("patch");
    }
}
