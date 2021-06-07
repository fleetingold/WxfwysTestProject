package com.wxfwys;

import com.alibaba.fastjson.JSONObject;
import com.wxfwys.dao.BookDao;
import com.wxfwys.entity.BookEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxfwysApplication.class)
public class WxfwysApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    public void saveBookTest() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1);
        bookEntity.setTitle("Spring Boot 中使用 MongoDB");
        bookEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        bookEntity.setAuthor("souyunku");
        bookEntity.setIsbn("http://www.souyunku.com");

        bookDao.saveBook(bookEntity);

        bookEntity = new BookEntity();
        bookEntity.setId(2);
        bookEntity.setTitle("Spring Boot 中使用 MongoDB");
        bookEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        bookEntity.setAuthor("souyunku");
        bookEntity.setIsbn("http://www.souyunku.com");

        bookDao.saveBook(bookEntity);
    }

    @Test
    public void removeBookTest() {
        bookDao.removeBook(2);
    }

    @Test
    public void updateBookTest() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1);
        bookEntity.setTitle("Spring Boot 中使用 Redis");
        bookEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        bookEntity.setAuthor("fleetingold");
        bookEntity.setIsbn("http://www.fleetingold.cloud");

        bookDao.updateBook(bookEntity);
    }

    @Test
    public void findBookByIdTest() {
        BookEntity bookEntity = bookDao.findBookById(1);

        System.out.println(JSONObject.toJSONString(bookEntity));
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTest() {
        //保存字符串
        stringRedisTemplate.opsForValue().set("runoob", "Hello SpringBoot&Redis!");
        Assert.assertEquals("Hello SpringBoot&Redis!", stringRedisTemplate.opsForValue().get("runoob"));
    }
}
