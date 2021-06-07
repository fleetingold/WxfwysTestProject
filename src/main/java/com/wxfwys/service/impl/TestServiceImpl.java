package com.wxfwys.service.impl;

import com.wxfwys.entity.BookEntity;
import com.wxfwys.mapper.TestMapper;
import com.wxfwys.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;
    @Override
    public List<BookEntity> getAllBook() {
        return testMapper.getAllBook();
    }

    @Override
    public List<BookEntity> getVirtualBookList() {
        BookEntity book = new BookEntity();
        book.setId(1);
        book.setReader("jeffrey");
        book.setIsbn("ISBN-1");
        book.setTitle("Fleetingold Virtual Book");
        book.setAuthor("fleetingold");
        book.setDescription("fleetingold virtual book");

        List<BookEntity> bookList = new ArrayList<>();
        bookList.add(book);
        return bookList;
    }
}
