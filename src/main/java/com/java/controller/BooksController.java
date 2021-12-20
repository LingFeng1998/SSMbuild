package com.java.controller;

import com.java.pojo.Books;
import com.java.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book){
        System.out.println(book);
        booksService.addBook(book);
        return "redirect:/books/all";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = booksService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook( Books book) {
        System.out.println(book);
        booksService.updateBook(book);

        return "redirect:/books/all";
    }

    @RequestMapping("/del/{bookId}")
    public String delBook(@PathVariable("bookId") int id){
        booksService.deleteBookById(id);
        return "redirect:/books/all";
    }

}
