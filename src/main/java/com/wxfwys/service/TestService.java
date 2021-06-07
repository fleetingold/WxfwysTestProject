package com.wxfwys.service;

import com.wxfwys.entity.BookEntity;

import java.util.List;

public interface TestService {
    List<BookEntity> getAllBook();

    List<BookEntity> getVirtualBookList();
}
