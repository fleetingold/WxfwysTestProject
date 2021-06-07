package com.wxfwys.dao.impl;

import com.wxfwys.dao.BookDao;
import com.wxfwys.entity.BookEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BookDaoImpl implements BookDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveBook(BookEntity bookEntity) {
        mongoTemplate.save(bookEntity);
    }

    @Override
    public void removeBook(int id) {
        mongoTemplate.remove(id);
    }

    @Override
    public void updateBook(BookEntity bookEntity) {
        Query query = new Query(Criteria.where("id").is(bookEntity.getId()));

        Update update = new Update();
        update.set("title", bookEntity.getTitle());
        update.set("description", bookEntity.getDescription());
        update.set("author", bookEntity.getAuthor());
        update.set("isbn", bookEntity.getIsbn());
        update.set("reader", bookEntity.getReader());

        mongoTemplate.updateFirst(query, update, BookEntity.class);
    }

    @Override
    public BookEntity findBookById(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        BookEntity bookEntity = mongoTemplate.findOne(query, BookEntity.class);
        return bookEntity;
    }
}
