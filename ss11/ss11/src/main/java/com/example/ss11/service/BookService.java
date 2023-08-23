package com.example.ss11.service;

import com.example.ss11.model.Book;
import com.example.ss11.repository.BookRepo;
import com.example.ss11.repository.IBookRepo;

import java.util.List;

public class BookService implements IBookService {
    IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public void add(Book book) {
        bookRepo.add(book);
    }

    @Override
    public void edit(int id, Book book) {
        bookRepo.edit(id,book);
    }

    @Override
    public void delete(int id) {
        bookRepo.delete(id);
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id);
    }
}
