package com.example.s12.repository.impl;

import com.example.s12.model.Author;
import com.example.s12.repository.IAuthorRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepo implements IAuthorRepo {
    private static final String SELECT_CATEGORY = "select * from authors";

    @Override
    public List<Author> getAllAuthor() {
        Connection connection = BaseRepo.getConnection();
        List<Author> authors = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_authors");
                String name = resultSet.getString("name_authors");
                authors.add(new Author(id, name));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }
}
