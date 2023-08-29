package com.example.ss9.controller;

import com.example.ss9.service.ILoginService;
import com.example.ss9.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private ILoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123abc".equals(password)) {

            request.setAttribute("message", "Admin đăng nhập thành công " + loginService.checkDate());
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Tài khoản hoặc mật khẩu không chính xác !");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
