package com.wxfwys.controller;

import com.alibaba.fastjson.JSONObject;
import com.wxfwys.dao.BookDao;
import com.wxfwys.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/request")
    public String request() {
        System.out.println("request");
        return "request";
    }

    @GetMapping(value = "/getallbook")
    public List<BookEntity> getAllBook() {
        System.out.println("/getallbook");
        return bookDao.getAllBook();
    }

    @GetMapping(value = "/getbook/{id}")
    public String getBookById(@PathVariable int id) {
        String response = "";

        System.out.println("/getbook/" + id);

        BookEntity bookEntity = bookDao.findBookById(id);

        if(bookEntity == null) {
            response = "未查找到id为 " + id + " BookEntity!";
        } else {
            response = JSONObject.toJSONString(bookEntity);
        }

        return response;
    }

    @GetMapping(value = "/rmbook/{id}")
    public String rmBookByid(@PathVariable int id) {
        String response = "";
        System.out.println("/rmbook/" + id);

        try {
            bookDao.removeBook(id);
            response = "移除id为 " + id + " 的Book";
        } catch (Exception e) {
            response = e.getMessage();
            e.printStackTrace();
        }

        return response;
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
