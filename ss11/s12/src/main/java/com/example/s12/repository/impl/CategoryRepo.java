package com.example.s12.repository.impl;

import com.example.s12.model.Category;
import com.example.s12.repository.ICategoryRepo;
import com.example.s12.repository.impl.BaseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    private static final String SELECT_CATEGORY = "select * from category";

    @Override
    public List<Category> getAllCategory() {
        Connection connection = BaseRepo.getConnection();
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                categories.add(new Category(id, name));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
