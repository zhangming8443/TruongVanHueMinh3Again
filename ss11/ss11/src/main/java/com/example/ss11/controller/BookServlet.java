package com.example.ss11.controller;

import com.example.ss11.model.Book;
import com.example.ss11.service.BookService;
import com.example.ss11.service.IBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private final IBookService bookService = new BookService();

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
            case "delete":
                delete(request, response);
                break;
            default:
                showListBook(request, response);
                break;
        }
    }


    private void showListBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.getAll();
        request.setAttribute("book", bookList);
        request.getRequestDispatcher("/book/list.jsp").forward(request, response);
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        if (book == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/book/edit.jsp").forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/book/create.jsp").forward(request, response);
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
//            case "delete":
//                delete(request, response);
//                break;
            default:
                showListBook(request, response);
                break;
        }
    }


    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) (Math.random() * 1000);
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");

        Book book = new Book(id, title, pageSize, author, category);
        bookService.add(book);
        request.setAttribute("message", "Book was added success");
        request.getRequestDispatcher("/book/create.jsp").forward(request, response);
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");

        Book book = bookService.findById(id);
        if (book == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else {
            book.setTitle(title);
            book.setPageSize(pageSize);
            book.setAuthor(author);
            book.setCategory(category);
            bookService.edit(id, book);
            request.setAttribute("book", book);
            request.setAttribute("message", "Book information was updated");
            request.getRequestDispatcher("/book/edit.jsp").forward(request, response);
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        if (book == null) {
            request.getRequestDispatcher("error-404.jsp");
        }
        else {
            bookService.delete(id);
            response.sendRedirect("book");
        }
    }
}
