package com.wxfwys.dao;

import com.wxfwys.entity.BookEntity;

public interface BookDao {

    void saveBook(BookEntity bookEntity);

    void removeBook(int id);

    void updateBook(BookEntity bookEntity);

    BookEntity findBookById(int id);
}
