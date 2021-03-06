package com.wxfwys.controller;

import com.wxfwys.entity.BookEntity;
import com.wxfwys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String testBook(
            @PathVariable("reader") String reader,
            Model model){
        List<BookEntity> bookList = testService.getAllBook();
        model.addAttribute("books",bookList);

        return "bookList";
    }


}
