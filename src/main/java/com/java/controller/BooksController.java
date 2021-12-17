package com.java.controller;

import com.java.pojo.Books;
import com.java.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lingfeng
 * @date 2021-12-17
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;

    @RequestMapping("/all")
    public String getAllBooks(Model model){
        List<Books> books = booksService.queryAllBook();
        model.addAttribute("booksList",books);
        return "allBooks";
    }
}
