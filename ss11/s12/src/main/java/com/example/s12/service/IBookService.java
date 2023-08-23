package com.example.s12.service;

import com.example.s12.model.Book;
import com.example.s12.model.BookDto;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    void create(Book book);

    void edit(int id, Book book);

    Book findById(int id);

    void delete(int id);

    List<BookDto> getAllDto();
}
