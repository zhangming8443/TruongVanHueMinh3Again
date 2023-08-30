package com.example.s12.service.impl;

import com.example.s12.model.Author;
import com.example.s12.repository.impl.AuthorRepo;
import com.example.s12.repository.IAuthorRepo;
import com.example.s12.service.IAuthorSevice;

import java.util.List;

public class AuthorService implements IAuthorSevice {
    private final IAuthorRepo authorRepo = new AuthorRepo();
    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.getAllAuthor();
    }
}
