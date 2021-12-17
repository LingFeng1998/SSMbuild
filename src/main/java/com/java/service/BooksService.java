package com.java.service;

import com.java.pojo.Books;

import java.util.List;

public interface BooksService {
    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBook();
}
