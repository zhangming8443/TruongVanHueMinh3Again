package com.example.ss10.controller;

import com.example.ss10.model.Student;
import com.example.ss10.service.IStudentService;
import com.example.ss10.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private final IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.display();
        if (studentList.size() == 0) {
            request.setAttribute("messageNull", "Empty list");
            request.getRequestDispatcher("display.jsp").forward(request, response);
        }
        else {
            request.setAttribute("student", studentList);
            request.getRequestDispatcher("/display.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
