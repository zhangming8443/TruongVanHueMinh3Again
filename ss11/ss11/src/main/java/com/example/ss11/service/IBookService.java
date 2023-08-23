package com.example.ss11.service;

import com.example.ss11.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    void add(Book book);
    void edit(int id, Book book);
    void delete(int id);
    Book findById(int id);
}
