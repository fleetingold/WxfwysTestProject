package com.wxfwys.mapper;

import com.wxfwys.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<BookEntity> getAllBook();
}
