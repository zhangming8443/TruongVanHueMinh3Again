package com.example.s12.repository;

import com.example.s12.model.Book;
import com.example.s12.model.BookDto;

import java.util.List;

public interface IBookRepo {
    List<Book> getAll();

    void create(Book book);

    void edit(int id, Book book);

    Book findById(int id);

    void delete(int id);

    List<BookDto> getAllDto();
}
