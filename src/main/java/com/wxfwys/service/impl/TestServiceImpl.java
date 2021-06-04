package com.wxfwys.service.impl;

import com.wxfwys.entity.Book;
import com.wxfwys.mapper.TestMapper;
import com.wxfwys.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;
    @Override
    public List<Book> getAllBook() {
        return testMapper.getAllBook();
    }
}
