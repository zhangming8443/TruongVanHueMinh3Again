package com.example.s12.service.impl;

import com.example.s12.model.Category;
import com.example.s12.repository.impl.CategoryRepo;
import com.example.s12.repository.ICategoryRepo;
import com.example.s12.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.getAllCategory();
    }
}
