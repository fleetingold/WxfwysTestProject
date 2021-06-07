package com.wxfwys.dao;

import com.wxfwys.entity.BookEntity;

import java.util.List;

public interface BookDao {

    void saveBook(BookEntity bookEntity);

    void removeBook(int id);

    void updateBook(BookEntity bookEntity);

    BookEntity findBookById(int id);

    List<BookEntity> getAllBook();
}
