package com.example.s12.controller;

import com.example.s12.model.Author;
import com.example.s12.model.Book;
import com.example.s12.model.BookDto;
import com.example.s12.model.Category;
import com.example.s12.service.IAuthorSevice;
import com.example.s12.service.impl.AuthorService;
import com.example.s12.service.impl.BookService;
import com.example.s12.service.impl.CategoryService;
import com.example.s12.service.IBookService;
import com.example.s12.service.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();
    ICategoryService categoryService = new CategoryService();
    IAuthorSevice authorSevice = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showListBook(request, response);
                break;
        }

    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookDto> bookDtoList = bookService.getAllDto();
        if (bookDtoList.size() == 0) {
            request.setAttribute("book", null);
        } else {
            request.setAttribute("book", bookDtoList);
        }
        request.getRequestDispatcher("book/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategory();
        List<Author> authors = authorSevice.getAllAuthor();
        request.setAttribute("category", categories);
        request.setAttribute("author", authors);
        request.getRequestDispatcher("book/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListBook(request, response);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        try {
            if (book == null) {
                request.getRequestDispatcher("book/error.jsp").forward(request,response);
            }
            else {
                bookService.delete(id);
                response.sendRedirect("/book");
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tittle = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int author = Integer.parseInt(request.getParameter("author"));
        int category = Integer.parseInt(request.getParameter("category"));

        Book book = new Book(tittle, pageSize, author, category);
        bookService.create(book);
        request.setAttribute("message", "Bạn đã thêm sách thành công");
        request.getRequestDispatcher("book/create.jsp").forward(request, response);
    }
}
