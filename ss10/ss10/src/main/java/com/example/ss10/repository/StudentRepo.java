package com.example.ss10.repository;

import com.example.ss10.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo{
    @Override
    public List<Student> display() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student(1, "Nguyễn Văn Thành", 1, 8);
        Student student1 = new Student(2, "Nguyễn Văn Kim", 1, 5);
        Student student2 = new Student(3, "Nguyễn Văn Thái", 0, 7);
        Student student3 = new Student(4, "Nguyễn Văn Cung", 1, 1);
        Student student4 = new Student(5, "Nguyễn Văn Thông", 0, 3.5);
        Student student5 = new Student(6, "Nguyễn Văn Tài", 0, 4.9);
        Student student6 = new Student(7, "Nguyễn Văn Lợi", 1, 9.8);
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        return studentList;
    }

}
