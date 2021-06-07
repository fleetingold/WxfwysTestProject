package com.wxfwys.controller;

import com.wxfwys.entity.BookEntity;
import com.wxfwys.service.MongoDBService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String testMongo(
            @PathVariable("reader") String reader,
            Model model
    ) {
        List<BookEntity> bookList = new ArrayList<>();

        List<Document> documents = mongoDBService.getDocument("mongodb_wxfwys", "bookEntity");

        if (documents.size() == 0) {
            return "mongo";
        } else {
            for (Document document :
                    documents) {
                BookEntity bookEntity = new BookEntity();
                bookEntity.setId(document.getInteger("_id"));
                bookEntity.setTitle(document.getString("title"));
                bookEntity.setDescription(document.getString("description"));
                bookEntity.setAuthor(document.getString("author"));
                bookEntity.setIsbn(document.getString("isbn"));

                bookList.add(bookEntity);
            }
        }
        model.addAttribute("books",bookList);

        return "bookList";
    }
}
