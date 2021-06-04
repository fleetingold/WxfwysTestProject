package com.wxfwys.mapper;

import com.wxfwys.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<Book> getAllBook();
}
