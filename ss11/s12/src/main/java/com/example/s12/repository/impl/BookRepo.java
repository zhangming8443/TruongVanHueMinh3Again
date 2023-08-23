package com.example.s12.repository.impl;

import com.example.s12.model.Book;
import com.example.s12.model.BookDto;
import com.example.s12.repository.IBookRepo;
import com.example.s12.repository.impl.BaseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    private static final String SELECT_ALL_DTO = "select id_books, title, page_size, name_authors,name_category  " +
            " from books b " +
            " join authors a on a.id_authors = b.id_authors " +
            " join category c on c.id_category= b.id_category " +
            " where is_delete = 0 " +
            " order by b.id_books ";
    private static final String INSERT_BOOK = "call sp_add_book(?, ?, ?, ?) ";
    private static final String SELECT_BY_ID = "select * " +
            "from books " +
            "where id_books = ?";
    private static final String DELETE_BOOK = "call sp_delete_book(?)";

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void create(Book book) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setString(1, book.getTittle());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setInt(3, book.getAuthor());
            preparedStatement.setInt(4, book.getCategory());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void edit(int id, Book book) {

    }

    @Override
    public Book findById(int id) {
        Connection connection = BaseRepo.getConnection();
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tittle = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                int author = resultSet.getInt("id_authors");
                int category = resultSet.getInt("id_category");
                book = new Book(id, tittle, pageSize, author, category);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void delete(int id) {
        Connection connection = BaseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<BookDto> getAllDto() {
        Connection connection = BaseRepo.getConnection();
        List<BookDto> bookDtoList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_books");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                String nameAuthor = resultSet.getString("name_authors");
                String nameCategory = resultSet.getString("name_category");
                bookDtoList.add(new BookDto(id, title, pageSize, nameAuthor, nameCategory));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookDtoList;
    }
}
