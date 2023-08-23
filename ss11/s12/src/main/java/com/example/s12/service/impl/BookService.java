package com.example.s12.service.impl;

import com.example.s12.model.Book;
import com.example.s12.model.BookDto;
import com.example.s12.repository.impl.BookRepo;
import com.example.s12.repository.IBookRepo;
import com.example.s12.service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    IBookRepo bookRepo = new BookRepo();

    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public void create(Book book) {
        bookRepo.create(book);
    }

    @Override
    public void edit(int id, Book book) {
        bookRepo.edit(id, book);
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        bookRepo.delete(id);

    }

    @Override
    public List<BookDto> getAllDto() {
        return bookRepo.getAllDto();
    }
}
